package base;

import java.time.Duration;
// maven


import io.cucumber.testng.AbstractTestNGCucumberTests;
import listeners.Execution;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import drivers.factory.DriverFactory;
import listeners.WebEventListener;
import utilities.dataHelpers.ConfigReader;

public class BaseTest extends AbstractTestNGCucumberTests {
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static final int PAGE_LOAD_TIMEOUT = ConfigReader.getIntegerProperty("pageLoadTimeOut");
	private static final int IMPLICIT_WAIT = ConfigReader.getIntegerProperty("implicitlyWait");
	private static Logger log = LogManager.getLogger();
	@BeforeMethod(groups = {"setUp"})
	public void setUp() {
		var browser = ConfigReader.getStringProperty("browser").toLowerCase();
		driver.set(new DriverFactory().createWebDriver(browser));
		log.info("Initialize '" + browser + "' driver successfully at" + " " + "Thread" + " "
				+ Thread.currentThread().getId());
		getDriver().get(ConfigReader.getStringProperty("baseURL"));
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
                System.out.println(System.getProperty("os.name"));
	
	}

	@AfterMethod(groups = {"tearDown"})
	public void tearDown() {
		getDriver().quit();
		log.info("close the session");
	}

	protected static WebDriver getDriver() {
		return driver.get();
	}
}
