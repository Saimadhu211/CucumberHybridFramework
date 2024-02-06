package stepdefinitions;

import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonUtils;

	
	@Given("User navigates to Register Account page")
	public void  User_navigates_to_Register_Account_page() {
		driver=DriverFactory.getDriver();
		HomePage homePage= new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage=homePage.clickOnRegister();
		}
	
	@When("User entres below details into the fields")
	public void User_entres_below_details_into_the_fields(DataTable Table) {
		Map<String, String> map = Table.asMap(String.class,String.class);
		
		registerPage.enterFirstName(map.get("firstname"));
		registerPage.enterLastName(map.get("lastname"));
		commonUtils=new CommonUtils();
		registerPage.enteremail(commonUtils.getEmailWithTimeStamp());
		registerPage.enterTelephoneNumber(map.get("telephone"));
		registerPage.enterPassword(map.get("password"));
		registerPage.enterConfirmPassword(map.get("password"));

	}
	@When("User entres below details into below fields with duplicate email")
	public void User_entres_below_details_into_below_fields_with_duplicate_email(DataTable Table) {
		Map<String, String> map = Table.asMap(String.class,String.class);
		registerPage.enterFirstName(map.get("firstname"));
		registerPage.enterLastName(map.get("lastname"));
		registerPage.enteremail(map.get("emailaddress"));
		registerPage.enterTelephoneNumber(map.get("telephone"));
		registerPage.enterPassword(map.get("password"));
		registerPage.enterConfirmPassword(map.get("password"));
	}
	
	@And("Selects Privacy Policy field")
	public void selects_privacy_policy_field() {
		registerPage.clickOnPrivacyPolicyButton();
	}

	@And("Clicks on Continue button")
	public void clicks_on_continue_button() {
		accountSuccessPage=registerPage.clickOnContinueButton();
   }

	@Then("Account should get Successfully created")
	public void account_should_get_successfully_created() {
		
	    Assert.assertEquals("Congratulations! Your new account has been successfully created!", accountSuccessPage.getPageHeading());
	}

	@And("Selects Yes for Newsletters")
	public void selects_yes_for_newsletters() {
		registerPage.clickOnNewsLetterButton();
 }

	@When("User dont enter details into any fields")
	public void user_dont_enter_details_into_any_fields() {
		
	}


	@Then("Warning messages should be displayed under all the mandatory fields")
	public void warning_messages_should_be_displayed_under_all_the_mandatory_fields() {
    
	Assert.assertTrue(registerPage.getWarningText());
    Assert.assertEquals("First Name must be between 1 and 32 characters!",registerPage.getFirstNameWarningText());
    Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerPage.getLastNamewarningText());
    Assert.assertEquals("E-Mail Address does not appear to be valid!",registerPage.getEmailWarningText());
    Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerPage.getTelephoneWarningText());
    Assert.assertEquals("Password must be between 4 and 20 characters!",registerPage.getPasswordWarningtext());
	}

	@Then("Warning message informating the user about duplicate email should be displayed")
	public void warning_message_informating_the_user_about_duplicate_email_should_be_displayed() {
		Assert.assertEquals("Warning: E-Mail Address is already registered!",registerPage.getDublicateEmailRegistrationWarningText());

}
	
}

	


