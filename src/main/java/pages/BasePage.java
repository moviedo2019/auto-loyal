package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.Properties;

/**
 * This class represents a basic page for any page object.
 * @author Matias Oviedo
 *
 */
public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Checks and waits until the item is visible.
	 * 
	 * @param element webElement
	 * @return true if the element is present or false if the element is not
	 *         present.
	 */
	public boolean waitForElement(WebElement element) {
		waitSeconds(1);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Properties.WAIT);

			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Wait for text change.
	 * 
	 * @param element WebElement
	 * @param text    expected for change
	 * @return true if the text is change or false if the text is not change.
	 */
	public boolean waitForTextChange(WebElement element, String text) {
		waitSeconds(1);
		try {
			waitForElement(element);
			WebDriverWait wait = new WebDriverWait(driver, Properties.WAIT);

			return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Verify the element text
	 * 
	 * @param text    is expected to display.
	 * @param element WebElement
	 * @return true if the text is in element, otherwise false.
	 */
	public boolean validateElementText(String text, WebElement element) {
		waitSeconds(1);
		try {
			String elementText = element.getText();
			return elementText.contentEquals(text);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Method to select a specific option from a combo box.
	 * 
	 * @param element WebElement
	 * @param value   Value to be selected in the combo box.
	 */
	public void selectTo(WebElement element, String value) {
		waitSeconds(1);
		try {
			waitForElement(element);
			Select select = new Select(element);
			select.selectByValue(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mouse hover to element
	 * 
	 * @param element
	 */
	public void mouseHover(WebElement element) {
		waitSeconds(1);
		try {
			waitForElement(element);
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void clickElement(WebElement element) {
		waitSeconds(1);
		try {
			waitForElement(element);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the URL of the current page.
	 * 
	 * @return URL of the current page.
	 */
	public String getCurrentUrl() {
		waitSeconds(1);
		return driver.getCurrentUrl();
	}

	/**
	 * Display a message on the console. Contains a step and a message.
	 * 
	 * @param step number
	 * @param msg  message
	 */
	public void steps(int step, String msg) {
		System.out.println(step + ": " + msg + ".");
	}

	/**
	 * Display a message failed on the console.
	 * 
	 * @param msg message
	 * @return msgFinal
	 */
	public String stepFail(String msg) {
		String msgFinal = ("Fail: " + msg + ".");
		System.out.println(msgFinal);
		return msgFinal;

	}

	/**
	 * wait a few seconds
	 * 
	 * @param time
	 */
	public void waitSeconds(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

}
