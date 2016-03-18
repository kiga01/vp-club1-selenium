package automationSelenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import helpers.AssertHelpers;

/**
 * Created by Kiga01 on 15/03/2016.
 */

public class GoggleTest {
	private static WebDriver driver;
	private String baseURL = "http://www.google.com";

	@BeforeClass
	public static void preSetup() {
		// System.setProperty("webdriver.chrome.driver",
		// "/Users/alejandrohinestrosa/Dropbox/vp-club1-selenium/chromedriver");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\xdevadmin\\Documents\\vp-club1-selenium\\chromedriver.exe");
	}

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void seleniumTest() throws Exception {
		AssertHelpers.verifyPageExist("Google", driver.getTitle());
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium");
		searchBox.submit();
		Thread.sleep(3000);
	}

	@After
	public static void teardown() {
		driver.quit();
	}
}
