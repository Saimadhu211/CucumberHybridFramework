package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SerchReasultsPage {
	
	WebDriver driver;
  public SerchReasultsPage(WebDriver driver) {
	
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
	  
}
  @FindBy(linkText="HP LP3065")
  private WebElement validProduct;
  
  @FindBy(xpath="//input[@id='button-search']/following-sibling::p")
  private WebElement invalidProduct;
  
  
  
  public boolean displayStatusOfValidProduct() {
	  return validProduct.isDisplayed();
  }
  public boolean displayStatusOfInvalidProduct() {
	  return invalidProduct.isDisplayed();
  }
  
}
