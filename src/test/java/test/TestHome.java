package test;

import pages.HomePage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

public class TestHome extends BaseTest {

	HomePage home;

	@BeforeClass
	public void beforeClass() {
		home = PageFactory.initElements(driver, HomePage.class);

	}

	@Test(testName = "test_1", description = "Check if there is a home link and when click on it, it returns you to the main page.", groups = "home")
	public void test_1() {

		if (home.verifyLinkHomeAndReturnHome()) {
			Assert.assertTrue(true);
			expectedResult("It is visible on the website and return the home");
		} else {
			Assert.fail("An error occurred");
			Assert.assertTrue(false);
		}
	}

	@Test(testName = "test_2", description = "Validate that when changing the language from Spanish to English, the text changes.", groups = "home")
	public void test_2() {

		if (home.verifyLanguage()) {
			Assert.assertTrue(true);
			expectedResult("The text is change");
		} else {
			Assert.fail("An error occurred");
			Assert.assertTrue(false);
		}
	}

	@Test(testName = "test_3", description = "Check the following fields on the contacts page.", groups = "contact")
	public void test_3() {

		if (home.verifyContactFields()) {
			Assert.assertTrue(true);
			expectedResult("The fields of the contact form are displayed");
		} else {
			Assert.fail("An error occurred");
			Assert.assertTrue(false);
		}
	}

	@Test(testName = "test_4", description = "Verify the page contains 12 items.", groups = "faq")
	public void test_4() {

		if (home.verifyItemsFaqs()) {
			Assert.assertTrue(true);
			expectedResult("The items of the Faq page is displayed");
		} else {
			Assert.fail("An error occurred");
			Assert.assertTrue(false);
		}
	}
}
