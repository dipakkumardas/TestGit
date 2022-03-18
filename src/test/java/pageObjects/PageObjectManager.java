package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	// This Page Object Manger is creating the Object and assigning to the driver
	public WebDriver driver;
	public LandingPage landingpage;
	public OffersPage offersPage;
	public CheckoutPage checkoutPage;

	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}

	public LandingPage getLandingPage() {
		landingpage = new LandingPage(driver);
		return landingpage;
	}
	
	public OffersPage OfferPage()
	{
		offersPage = new OffersPage(driver);
		return offersPage;
	}
	
	public CheckoutPage getCheckoutPage()
	{
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
	
	

}
