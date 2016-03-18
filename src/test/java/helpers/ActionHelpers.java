package helpers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Kiga01 on 16/03/2016.
 */

public class ActionHelpers {
	public static void setImputValue(WebDriver driver, String value, String selector) {
		WebElement input = driver.findElement(By.name(selector));
		input.clear();
		input.sendKeys(value);
	}

	public static void setCheckboxValue(WebDriver driver, String selector) {
		WebElement checbox = driver.findElement(By.id(selector));
		if (!checbox.isSelected()) {
			checbox.click();
		}
	}

	public static void submitButton(WebDriver driver, String selector) {
		WebElement submitButton = driver.findElement(By.name(selector));
		submitButton.submit();
	}

	public static int getParagraphQuantity(WebDriver driver, String selector) {
		List<WebElement> elementsList = driver.findElements(By.cssSelector(selector));
		return elementsList.size();
	}

	public static int getParagraphQuantityNumber(WebDriver driver, String selector) {
		String paragraph = driver.findElement(By.cssSelector(selector)).getText();
		String[] numbers = paragraph.replaceAll(",", "").split(" ");
		return Integer.parseInt(numbers[1]);
	}

	public static String getParagraphTitle(WebDriver driver, String selector) {
		String paragraphTitle = driver.findElement(By.cssSelector(selector)).getAttribute("innerHTML");
		return paragraphTitle;
	}

	public static String getParagraph(WebDriver driver, String selector) {
		String paragraph = driver.findElement(By.cssSelector(selector)).getAttribute("innerHTML");
		paragraph = paragraph.replace("<strong>", "");
		paragraph = paragraph.replace("</strong>", "");
		return paragraph;
	}
}
