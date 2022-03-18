package stepDefinations;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TextContextSetup;

public class OfferPageStepDefination {
	
	
	public String offerpageProductName;
	TextContextSetup textcontextsetup;
	PageObjectManager pageObjectManager;
	OffersPage offersPage;
	
	
	
	public OfferPageStepDefination(TextContextSetup textcontextsetup)
	{
		this.textcontextsetup = textcontextsetup;
		
	}
	
	
	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
	   
		
		switchToOffersPage();
		
		OffersPage offersPage  =textcontextsetup.pageObjectManager.OfferPage();
		offersPage.searchItem(shortName);
		Thread.sleep(2000);
		offerpageProductName = offersPage.getProductName();
		
		//pageObjectManager= new PageObjectManager(textcontextsetup.driver);
		
		//LandingPage landingpage =textcontextsetup.pageObjectManager.getLandingPage();
		//LandingPage landingpage =pageObjectManager.getLandingPage(); 
	//	landingpage.selectTopDealsPage();
		//textcontextsetup.geneticUtils.SwitchWindowToChild();
		
		//textcontextsetup.driver.findElement(By.linkText("Top Deals")).click();
		
	//	Thread.sleep(2000);
		//SwitchToOfferPage();
		
	//	offersPage=textcontextsetup.pageObjectManager.OfferPage();
		//offersPage =textcontextsetup.pageObjectManager.getLandingPage();
		//OffersPage offersPage = new OffersPage(textcontextsetup.driver);
	//	offersPage.searchItem(shortName);
		//textcontextsetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		
	//	//Thread.sleep(2000);
		//offerpageProductName = offersPage.getProductName();
		//System.out.println("The Offer Page :" +textcontextsetup.offerpageProductName);
		//Thread.sleep(2000);
		
	}
	
	
	public void switchToOffersPage()
	{
		//if switched to offer page-> skip below part
		LandingPage landingPage  =textcontextsetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		textcontextsetup.geneticUtils.SwitchWindowToChild();
		//explicit wait, parse string
		
		
	}
	
	
	
	
	@And("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_Landing_Page() throws InterruptedException
	{
		Thread.sleep(3000);	
		Assert.assertEquals(offerpageProductName, textcontextsetup.landingPageProductName);
	}

}
