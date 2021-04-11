package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import config.Properties;

/**
 * This class contains what is needed to run the test using a default browser.
 * @author Matias Oviedo
 */
public class BaseTest {

	public static WebDriver driver;

	@BeforeTest
	public void setup() {

		System.setProperty(Properties.CHROME, Properties.DRIVERPATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Properties.SECONDS, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Properties.URL_ES);
	}

	@AfterTest
	public void endSession() {
		driver.quit();
	}

	public void expectedResult(String msg) {
		System.out.println("Expected result: " + msg + ".");
	}

}
