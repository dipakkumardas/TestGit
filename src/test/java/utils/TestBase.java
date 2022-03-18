package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");

		// Driver Initialize only once , If It's already Initialize then it's only
		// Return the driver
		// This Checking is hare

		if (driver == null) {

			if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"//src//test//resources//chromedriver.exe");
				driver = new ChromeDriver(); // Driver get his Life
			}

			if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				// Firefox Code
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);

		}
		return driver;
	}

}
