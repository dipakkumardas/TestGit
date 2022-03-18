package stepDefinations;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TextContextSetup;

public class CheckoutPageStepDefination {

	public WebDriver driver;
	public String landingPageProductName;
	public String offerpageProductName;
	public CheckoutPage checkoutPage;
	TextContextSetup textcontextsetup;
	LandingPage landingpage;

	// Create a Constructor and Pass the instance of text Content setup

	public CheckoutPageStepDefination(TextContextSetup textcontextsetup) {

		this.textcontextsetup = textcontextsetup;
		this.checkoutPage = textcontextsetup.pageObjectManager.getCheckoutPage();
	}

	@Then("verify user has ability to enter promo code and place the order")
	public void  verify_user_has_ability_enter_promo()
	{
		
		checkoutPage=textcontextsetup.pageObjectManager.getCheckoutPage();
		Assert.assertTrue(checkoutPage.VerifyPromoBtn());
		Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
		
	}
	
	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout(String name) throws InterruptedException
	{
		
		checkoutPage.CheckoutItems();
		
		//Assertion to extract name from screen and compare with name
	}


}
