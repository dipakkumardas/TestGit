package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TextContextSetup;

public class Hooks {
	
	TextContextSetup textContextSetup;
	
	public Hooks(TextContextSetup textContextSetup)
	{
		this.textContextSetup=textContextSetup;
	}
	
	@After
	public void AfterScenario() throws IOException
	{
		textContextSetup.testBase.WebDriverManager().quit();
	}
	
	/** Taking Screen shots if any Fail
	 * 
	 * @param scenario
	 * @throws IOException
	 */
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException
	{
		
		
		WebDriver driver =textContextSetup.testBase.WebDriverManager();
		if(scenario.isFailed())
		{
		
		File sourcePath= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
		
		}
	}

}
