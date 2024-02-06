package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMessgage;

	public void enterEmailAddress(String email) {
		emailField.sendKeys(email);
	}
	
	public void enterPasswordField(String password) {
		passwordField.sendKeys(password);
	}
	
	public AccountPage clickonLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public String getWarningMessageText() {
		return warningMessgage.getText();
	}

}
