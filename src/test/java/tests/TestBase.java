package tests;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests {

	public static WebDriver driver;
	
	public static String downloadPath = System.getProperty("user.dir")+"\\downloads";
	
	public static ChromeOptions chromeoption() {
		ChromeOptions option = new ChromeOptions();
		HashMap<String, Object> chromepref = new HashMap<String, Object>();
		chromepref.put("profile.default.content_settings.popups", 0);
		chromepref.put("download.default_directory", downloadPath);
		option.setExperimentalOption("prefs", chromepref);
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);	
		return option;
	}
	
	public static FirefoxOptions firefoxOption() {
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("drowser.download.dir", downloadPath);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf,application/octet-stream");
	    options.addPreference("browser.download.manager.showWhenStarting", false);
	    options.addPreference("pdfjs.disabled", true);
		return options;
	}
	
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserValue) {
		if(browserValue.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver =new ChromeDriver(chromeoption());
		}
		if(browserValue.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver =new FirefoxDriver(firefoxOption());
		}
		if(browserValue.equalsIgnoreCase("headless")) 
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir")+"/drivers/PHANTOMJS.exe");
			String[] phantomJsArgs = {"--web-security=no","--ignore-ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgs);
			driver = new PhantomJSDriver(caps); 
		}

		driver.manage().window().maximize();
		driver.navigate().to("https://demo.nopcommerce.com/");
	}

	@AfterSuite
	public void stopDriver() {
		//driver.quit();
	}

	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) 
		{
			System.out.println("Failed...");
			System.out.println("taking Screenshot...");
			Helper.captureScreenshot(driver, result.getName());
		}

	}

}
