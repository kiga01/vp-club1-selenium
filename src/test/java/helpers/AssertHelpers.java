package helpers;

import org.junit.Assert;

/**
 * Created by Kiga01 on 16/03/2016.
 */

public class AssertHelpers {
	public static void verifyPageExist(String expectedTitle, String obtainedTitle) {
		Assert.assertEquals("Page not found", expectedTitle, obtainedTitle);
	}

	public static void verifyParagraphTitle(String expectedTitle, String obtainedTitle) {
		Assert.assertEquals(expectedTitle, obtainedTitle);
	}

	public static void verifyContainedText(String expectedText, String obtainedText) {
		Assert.assertTrue(obtainedText.contains(expectedText));
	}

	public static void numberOfParagraphs(int inputValue, int obtainedValue) {
		Assert.assertEquals(inputValue, obtainedValue);
	}
}
