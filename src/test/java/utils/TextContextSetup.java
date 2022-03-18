package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TextContextSetup {

	//This class is used to share variable which is used to other class
	// This class is Initialization of Object of Page Object manager
	
	// All Variable we declare on this Class
	public WebDriver driver;
	public String landingPageProductName;
	public String offerpageProductName;
	public TestBase testBase;
	public GenericUtils geneticUtils;

	public PageObjectManager pageObjectManager;

	public TextContextSetup() throws IOException {
		
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		geneticUtils = new GenericUtils(testBase.WebDriverManager());

	}

}
