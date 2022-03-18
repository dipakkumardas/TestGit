package stepDefinations;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TextContextSetup;

public class LandingPageStepDefination {

	public WebDriver driver;
	public String landingPageProductName;
	public String offerpageProductName;
	TextContextSetup textcontextsetup;
	LandingPage landingpage;

	// Create a Constructor and Pass the instance of text Content setup

	public LandingPageStepDefination(TextContextSetup textcontextsetup) {

		this.textcontextsetup = textcontextsetup;
		this.landingpage=textcontextsetup.pageObjectManager.getLandingPage();
		
	}

	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "D:\\AllBrowserDriver\\chromedriver.exe"); textcontextsetup.driver = new
		 * ChromeDriver(); textcontextsetup.driver.get(
		 * "https://rahulshettyacademy.com/seleniumPractise/#/");
		 */
		
		//Assert.assertTrue(landingpage.getTitleLandingPage().contains("GreenKart"));
		
		Assert.assertTrue(landingpage.getTitleLandingPage().contains("GreenKart"));
		
	
	}

	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {
		
		landingpage =textcontextsetup.pageObjectManager.getLandingPage();
		landingpage.searchItem(shortName);
		Thread.sleep(4000);
		textcontextsetup.landingPageProductName =landingpage.getProductName().split("-")[0].trim(); 
		
		//textcontextsetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(4000);
	//	textcontextsetup.landingPageProductName = landingpage.getProductName().split("-")[0].trim();
		System.out.println("Product Name Extracted from the Home Page :" + landingPageProductName);
	}
	
	
	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity)
	{
		
		landingpage.incrementQuantity(Integer.parseInt(quantity));
		landingpage.addToCart();
		
	}

}
