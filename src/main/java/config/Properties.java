package config;

/**
 * 
 * Browser and driver Properties.
 * @author Matias Oviedo
 */
public interface Properties {

	public static final String DRIVERPATH = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
	public static final String CHROME = "webdriver.chrome.driver";
	public static final Integer SECONDS = 10;
	public static final Integer WAIT = 5;
	public static final String URL_ES = "https://loyal-solutions.com/es/home/";
	public static final String URL_EN = "https://loyal-solutions.com/en/home/";
	public static final String URL_ES_CONTACT = "https://loyal-solutions.com/es/contact/";
	public static final String ES = "es";
	public static final String EN = "en";
	public static final String PT = "pt";
}
