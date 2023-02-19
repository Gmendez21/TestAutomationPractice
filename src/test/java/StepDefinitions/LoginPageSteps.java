package StepDefinitions;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;

import io.cucumber.java.en.Given;
	import io.cucumber.java.en.When;
	import io.cucumber.java.en.Then;
	import org.junit.Assert;

	public class LoginPageSteps {
	  
	    LoginPage loginPage;
	    ProductsPage productsPage;

	    @Given("I am on the SauceDemo login page")
	    public void i_am_on_the_saucedemo_login_page() {
	        loginPage = new LoginPage();
	        loginPage.navigateToLoginPage();
	    }

	    @When("I enter valid username and password")
	    public void i_enter_valid_username_and_password() {
	        loginPage.enterUsername("standard_user");
	        loginPage.enterPassword("secret_sauce");
	    }

	    @When("I enter valid username and incorrect password")
	    public void i_enter_valid_username_and_incorrect_password() {
	        loginPage.enterUsername("standard_user");
	        loginPage.enterPassword("wrong_password");
	    }

	    @When("I enter non-existent username and password")
	    public void i_enter_non_existent_username_and_password() {
	        loginPage.enterUsername("non_existent_user");
	        loginPage.enterPassword("secret_sauce");
	    }

	    @When("I click the login button")
	    public void i_click_the_login_button() {
	        productsPage = loginPage.clickLoginButton();
	    }

	    @Then("I should be on the products page")
	    public void i_should_be_on_the_products_page() {
	        Assert.assertTrue(productsPage.isOnProductsPage());
	    }

	    @Then("I should see an error message saying {string}")
	    public void i_should_see_an_error_message_saying(String expectedErrorMessage) {
	        String actualErrorMessage = loginPage.getErrorMessage();
	        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	    }
	}
	

