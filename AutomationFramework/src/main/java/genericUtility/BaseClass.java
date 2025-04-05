package genericUtility;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {

	PropertyFileUtility putil = new PropertyFileUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sDriver;

	@BeforeSuite(groups = { "Smoke", "Regression" })
	public void beforeSuiteConfiguration() {
		Reporter.log("---DataBase connection established---", true);
	}

	// @Parameters("browser")
	// @BeforeTest
	@BeforeClass(groups = { "Smoke", "Regression" })
	public void beforeClassConfiguration(/* String BROWSER */) throws IOException {
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");
		if (BROWSER.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.contains("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.contains("firefox")) {
			driver = new FirefoxDriver();
		}
		sDriver = driver; // Listeners
		Reporter.log("Browser got launched", true);
		wutil.toMaximize(driver);
		wutil.toImplicitWait(driver);
		driver.get(URL);

	}

	@BeforeMethod(groups = { "Smoke", "Regression" })
	public void beforeMethodConfiguration() throws IOException {
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.getUsernametextfield().sendKeys(USERNAME);
		lp.getPasswordtextField().sendKeys(PASSWORD);
		lp.getLogintextfield().click();
		Reporter.log("Logged in Successfully", true);
		;

	}

	@AfterMethod(groups = { "Smoke", "Regression" })
	public void afterMethodConfiguration() {

		HomePage hp = new HomePage(driver);
		wutil.toMouseHover(driver, hp.getLogoutlink());
		hp.getSignoutlink().click();
		Reporter.log("Logged Out Successfully", true);
	}

	@AfterClass(groups = { "Smoke", "Regression" })
	public void afterClassConfiguration() {
		Reporter.log("Browser was closed Successfully", true);
		driver.quit();

	}

	@AfterSuite(groups = { "Smoke", "Regression" })
	public void afterSuitConfiguration() {

		Reporter.log("--DataBase Disconnected Successfully--", true);
	}

}
