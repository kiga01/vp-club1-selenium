package automationSelenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import helpers.ActionHelpers;
import helpers.AssertHelpers;

/**
 * Created by Kiga01 on 15/03/2016.
 */

public class LorenIpsum {
	private static WebDriver driver;
	private String baseURL = "http://www.lipsum.com";

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
	public void paragraphTest() throws Exception {
		AssertHelpers.verifyPageExist("Lorem Ipsum - All the facts - Lipsum generator", driver.getTitle());
		String paragraphTitle = ActionHelpers.getParagraphTitle(driver, ".lc h2 span");
		AssertHelpers.verifyParagraphTitle("What is Lorem Ipsum?", paragraphTitle);
		String paragraph = ActionHelpers.getParagraph(driver, ".lc p");
		AssertHelpers.verifyContainedText("Lorem Ipsum is simply dummy text of the printing and typesetting industry",
				paragraph);
		Thread.sleep(3000);
	}

	@Test
	public void createParagraphTest() throws Exception {
		String paragraphQuantity = "3";
		AssertHelpers.verifyPageExist("Lorem Ipsum - All the facts - Lipsum generator", driver.getTitle());
		ActionHelpers.setImputValue(driver, paragraphQuantity, "amount");
		ActionHelpers.setCheckboxValue(driver, "paras");
		ActionHelpers.submitButton(driver, "generate");
		int paragraphsShowed = ActionHelpers.getParagraphQuantity(driver, "#lipsum p");
		AssertHelpers.numberOfParagraphs(Integer.parseInt(paragraphQuantity), paragraphsShowed);
		int paragraphsNumber = ActionHelpers.getParagraphQuantityNumber(driver, "#generated");
		AssertHelpers.numberOfParagraphs(Integer.parseInt(paragraphQuantity), paragraphsNumber);
		Thread.sleep(3000);
	}

	@After
	public static void teardown() {
		driver.quit();
	}
}
