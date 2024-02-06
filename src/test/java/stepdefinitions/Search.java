package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SerchReasultsPage;

public class Search {
	WebDriver driver;
	private HomePage homePage;
	private SerchReasultsPage searchResultPage;


@Given("User opens the application")
public void user_opens_the_application() {
   driver= DriverFactory.getDriver();
}

@When("User entered valid product {string} into Search field")
public void user_entered_valid_product_into_search_field(String validProduct) {
     homePage = new HomePage(driver);
	homePage.enterValidProductIntoSearchbox(validProduct);
}

@And("User click on search button")
public void user_click_on_search_button() {
    homePage = new HomePage(driver);
    searchResultPage=homePage.clickonSearchButton();
}

@Then("Valid product should get displayed in search reasults")
public void valid_product_should_get_displayed_in_search_reasults() {
	Assert.assertTrue(searchResultPage.displayStatusOfValidProduct());
}

@When("User enters non-existing product {string} into search field")
public void user_enters_non_existing_product_into_search_field(String invalidProduct) {
    homePage = new HomePage(driver);
	homePage.enterValidProductIntoSearchbox(invalidProduct);

}

@Then("Proper text informing the user that there is no product matching should be displayed")
public void proper_text_informing_the_user_that_there_is_no_product_matching_should_be_displayed() {
	Assert.assertTrue(searchResultPage.displayStatusOfInvalidProduct());
}

@When("User dont enter any product into search field")
public void user_dont_enter_any_product_into_search_field() {

}

}
