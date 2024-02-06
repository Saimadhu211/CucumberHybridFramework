package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement serachButton;
	
	
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	}
	
	public LoginPage clickOnLogin() {
		loginOption.click();
		return new LoginPage(driver);
	}
 
	public RegisterPage clickOnRegister() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterValidProductIntoSearchbox(String validProductText) {
		searchBoxField.sendKeys(validProductText);
	}
	public SerchReasultsPage clickonSearchButton() {
		serachButton.click();
		return new SerchReasultsPage(driver);
	}
}
