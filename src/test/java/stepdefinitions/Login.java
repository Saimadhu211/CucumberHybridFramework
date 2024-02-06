package stepdefinitions;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;

	@Given("User navigates to Login page")
	public void User_navigates_to_Login_page () {
		driver=DriverFactory.getDriver();
		HomePage homePage= new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage=homePage.clickOnLogin();
	}
	
	@When("^User enters valid email address (.+)$")
	public void User_enters_valid_email_address(String email) {
		loginPage.enterEmailAddress(email);
	}
	
	@And("^Enters valid password (.+)$")
	public void Enters_valid_password(String password) {
		loginPage.enterPasswordField(password);
	}
	
	@And("Clicks on Login button")
	public void Clicks_on_Login_button() {
	
		accountPage=loginPage.clickonLoginButton();
	}
	
	@Then("User should login successfully")
	public void User_should_login_successfully() {
		Assert.assertTrue(accountPage.displaySatusOfEditYourAccountInformation());
	}
	
	@When("User enters invalid email address")
	public void User_enters_invalid_email_address() {
		commonUtils=new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		
	}
	@And("Enters invalid password {string}")
	public void Enters_invalid_password(String invalidPassword) {
		loginPage.enterPasswordField(invalidPassword);;		
		}
	
	@Then("User should get a proper warning message")
	public void User_should_get_a_proper_warning_message() {
		Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}
	
	@When("User dont enter any credentials")
	public void User_dont_enter_any_credentials() {
		
	}
	
}
