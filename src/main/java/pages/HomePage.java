package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.Properties;

public class HomePage extends BasePage {

	// Section header
	/**
	 * loyal of the section menu
	 */
	@FindBy(xpath = "//li/a[@href='/loyal']")
	private WebElement lnk_loyal;
	/**
	 * product of the section menu
	 */
	@FindBy(xpath = "//*[@id='navbar-collapse-1']/ul/li[2]")
	private WebElement ddwn_product;
	/**
	 * contact of the section menu
	 */
	@FindBy(xpath = "//li/a[@href='/contact']")
	private WebElement lnk_contact;
	/**
	 * language of the section header
	 */
	@FindBy(id = "languange-selector")
	private WebElement ddwn_language;
	/**
	 * home of the section page-intro
	 */
	@FindBy(xpath = "//li/a[@href='/home']")
	private WebElement lnk_home;

	// Section contact
	/**
	 * email of the section form
	 */
	@FindBy(id = "email")
	private WebElement txt_email;
	/**
	 * name of the section form
	 */
	@FindBy(name = "name")
	private WebElement txt_name;
	/**
	 * surname of the section form
	 */
	@FindBy(xpath = "//input[@id='surname']")
	private WebElement txt_surname;
	/**
	 * country of the section form
	 */
	@FindBy(id = "country")
	private WebElement txt_country;
	/**
	 * phone of the section form
	 */
	@FindBy(id = "phone")
	private WebElement txt_phone;
	/**
	 * company of the section form
	 */
	@FindBy(id = "company")
	private WebElement txt_company;
	/**
	 * massage of the section form
	 */
	@FindBy(id = "message")
	private WebElement txt_message;

	// Section FAQ
	/**
	 * faq of the section menu/product
	 */
	@FindBy(xpath = "//li/ul/li/a[@href='/products/faq']")
	private WebElement lnk_faq;
	/**
	 * accordion of the section accordion
	 */
	@FindBy(id = "accordion")
	private WebElement lst_panel;

	public HomePage(WebDriver driver) {
		super(driver);
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	/*
	 * public methods
	 */

	/**
	 * Check the Home link exists and click the link Home.
	 * 
	 * @return success boolean
	 */
	public boolean verifyLinkHomeAndReturnHome() {
		boolean success = false;

		steps(1, "Go to option Loyal");
		goSectionNavBar(lnk_loyal);
		try {
			steps(2, "Check the Home link exists");
			waitForElement(lnk_home);
			if (lnk_home.isDisplayed()) {
				success = true;
				steps(2, "Is displayed");
			} else {
				success = false;
				stepFail("Is not displayed");
			}
		} catch (NoSuchElementException ns) {
			ns.printStackTrace();
		}
		steps(3, "Go to link Home");
		goToHome();

		steps(4, "Check if it is home");
		try {
			if (getCurrentUrl().contains(Properties.URL_EN)) {
				success = true;
				steps(4, "Is the correct URL");
			} else {
				success = false;
				stepFail("Is the not correct URL");
			}
		} catch (NoSuchElementException ns) {
			ns.printStackTrace();
		}
		return success;
	}

	/**
	 * verify if the text change for language.
	 * 
	 * @return success boolean
	 */
	public boolean verifyLanguage() {
		boolean success = false;

		try {
			steps(1, "Select to language English");
			selectTo(ddwn_language, Properties.EN);
			steps(2, "Wait for text change to empresa for company");
			if (waitForTextChange(lnk_loyal, "Company")) {
				steps(2, "The text is change correct");
				success = true;
			} else {
				stepFail("The text is not change correct");
				success = false;
			}
		} catch (NoSuchElementException ns) {
			ns.printStackTrace();
		}
		return success;
	}

	/**
	 * check if the fields of the contact form are present.
	 * 
	 * @return boolean
	 */
	public boolean verifyContactFields() {
		List<String> fields = new ArrayList<String>();
		List<String> logs = new ArrayList<String>();

		try {
			steps(1, "Go to link Contact");
			goSectionNavBar(lnk_contact);
			driver.get(Properties.URL_ES_CONTACT);

			steps(2, "Verify contacts fields");
			if (validateElementText("Correo electrónico*", txt_email.findElement(By.xpath("./ancestor::div/label")))) {
				fields.add("Correo electrónico");
			} else {
				logs.add(stepFail("The text Correo electrónico does not match"));
			}
			if (validateElementText("Nombre*", txt_name.findElement(By.xpath("./ancestor::div/label")))) {
				fields.add("Nombre");
			} else {
				logs.add(stepFail("The text Nombre does not match"));
			}
			if (validateElementText("Apellido*", txt_surname.findElement(By.xpath("./ancestor::div/label")))) {
				fields.add("Apellido");
			} else {
				logs.add(stepFail("The text Apellido does not match"));
			}
			if (validateElementText("País*", txt_country.findElement(By.xpath("./ancestor::div/label")))) {
				fields.add("País");
			} else {
				logs.add(stepFail("The text País does not match"));
			}
			if (validateElementText("Teléfono*", txt_phone.findElement(By.xpath("./ancestor::div/label")))) {
				fields.add("teléfono");
			} else {
				logs.add(stepFail("The text teléfono does not match"));
			}
			if (validateElementText("Empresa*", txt_company.findElement(By.xpath("./ancestor::div/label")))) {
				fields.add("Empresa");
			} else {
				logs.add(stepFail("The text Empresa does not match"));
			}
			if (validateElementText("Mensaje*", txt_message.findElement(By.xpath("./ancestor::div/label")))) {
				fields.add("Mensaje");
			} else {
				logs.add(stepFail("The text Mensaje does not match"));
			}
			if (fields.size() == 7) {
				steps(3, "The quantity is checked");
			}

		} catch (NoSuchElementException ns) {
			ns.printStackTrace();
		}

		return logs.isEmpty();

	}

	/**
	 * Verify items in the Faqs page.
	 * 
	 * @return success boolean
	 */
	public boolean verifyItemsFaqs() {
		boolean success = false;
		steps(1, "Mouse over to Product");
		mouseHover(ddwn_product);
		steps(2, "Click to Faq");
		clickElement(lnk_faq);

		List<WebElement> Items = lst_panel.findElements(By.xpath("./div/div/div/a"));

		steps(3, "Check the number of items found " + "Items " + Items.size());
		if (Items.size() == 12) {
			for (WebElement item : Items) {
				steps(99, item.getText());
			}
			success = true;
		} else {
			stepFail("the quantity does not match");
		}

		return success;
	}

	/*
	 * keywords
	 */

	/**
	 * Enter the option by clicking on the element.
	 * 
	 * @param element webElement
	 */
	public void goSectionNavBar(WebElement element) {
		try {
			waitForElement(element);
			clickElement(element);
		} catch (NoSuchElementException ns) {
			ns.printStackTrace();
		}
	}

	/**
	 * Go to link Home
	 */
	public void goToHome() {
		try {
			waitForElement(lnk_home);
			clickElement(lnk_home);
		} catch (NoSuchElementException ns) {
			ns.printStackTrace();
		}
	}

}
