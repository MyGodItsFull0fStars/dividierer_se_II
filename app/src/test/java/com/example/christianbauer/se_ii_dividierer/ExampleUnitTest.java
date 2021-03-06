package com.example.christianbauer.se_ii_dividierer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
	@Test
	public void addition_isCorrect() throws Exception {
		assertEquals(4, 2 + 2);
	}


	@Test
	public void checkRegex() {
		MainActivity mainActivity = new MainActivity();
		StringActivity stringActivity  = new StringActivity();

		String text = "0.0";
		String wrong = "s.0";
		String number = "1";
		String regexPattern = "(-?([0-9]+[0-9]*\\.{1}[0-9]+[0-9]*))";
		String regexInt = "-?([0-9]+)";

		Assert.assertTrue(text.matches(regexPattern));
		Assert.assertFalse(wrong.matches(regexPattern));
		Assert.assertTrue(number.matches(regexInt));
	}

	@Test
	public void checkStringCorrectionMethod() {
		StringActivity stringActivity = new StringActivity();

		String text = "0.0";
		String number = "1";
		String periodWrongText = ".0";
		String negativeText = "-0.0";
		String negativePeriod = "-.";


		Assert.assertEquals(text, stringActivity.stringCorrection(text));
		Assert.assertEquals(text, stringActivity.stringCorrection(periodWrongText));
		Assert.assertEquals(number, stringActivity.stringCorrection(number));
		Assert.assertEquals(negativeText, stringActivity.stringCorrection(negativePeriod));

	}
}