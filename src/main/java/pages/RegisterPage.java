package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	public RegisterPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
    @FindBy(id="input-firstname")
	private WebElement firstNameField;
    
    @FindBy(id="input-lastname")
    private WebElement LastNameField;
    
    @FindBy(id="input-email")
    private WebElement emailField;
    
    @FindBy(id="input-telephone")
    private WebElement telephoneField;
    
    @FindBy(id="input-password")
    private WebElement passwordField;
    
    @FindBy(id="input-confirm")
    private WebElement confirmPasswordField;
    
    @FindBy(xpath="//input[@name='agree']")
    private WebElement privacyPolicy;
    
    @FindBy(xpath="//input[@value='Continue']")
    private WebElement continueButton;
    
    @FindBy(xpath="//input[@name='newsletter']")
    private WebElement newsLetterButton;
    
    @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
    private WebElement warningText;
    
    @FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
    private WebElement firstNamewarningText;
    
    @FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
    private WebElement lastNamewarningText;
    
    @FindBy(xpath="//input[@id='input-email']/following-sibling::div")
    private WebElement emailWarningtext;
    
    @FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
    private WebElement telephoneWarningText;
    
    @FindBy(xpath="//input[@id='input-password']/following-sibling::div")
    private WebElement passwordWarningtext;
    
    @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
    private WebElement dublicateEmailRegistrationText;
    
    public void enterFirstName(String firstNameText) {
    	firstNameField.sendKeys(firstNameText);
    }
    
    public void enterLastName(String lastNameText) {
    	LastNameField.sendKeys(lastNameText);
    }
    
    public void enteremail(String email) {
    	emailField.sendKeys(email);
    }
    
    public void enterTelephoneNumber(String telephone) {
    	telephoneField.sendKeys(telephone);
    }
    
    public void enterPassword(String Password) {
    	passwordField.sendKeys(Password);
    }
    
    public void enterConfirmPassword(String Password) {
    	confirmPasswordField.sendKeys(Password);
    }
    
    public void clickOnPrivacyPolicyButton() {
    	privacyPolicy.click();
    }
    
    public AccountSuccessPage clickOnContinueButton() {
    	continueButton.click();
    	return new AccountSuccessPage(driver);
    }
    
    public void clickOnNewsLetterButton() {
    	newsLetterButton.click();
    }
    
    public boolean getWarningText() {
    	return warningText.isDisplayed();
    }
    
    public String getFirstNameWarningText() {
    	return firstNamewarningText.getText();
    }
    
    public String getLastNamewarningText() {
    	return lastNamewarningText.getText();
    }
    
    public String getEmailWarningText() {
    	return emailWarningtext.getText();
}
    public String getTelephoneWarningText() {
    	return telephoneWarningText.getText();
    }
    
    public String getPasswordWarningtext() {
    return passwordWarningtext.getText();
}
    public String getDublicateEmailRegistrationWarningText() {
    	return dublicateEmailRegistrationText.getText();
    }
    
}