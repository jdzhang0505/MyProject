package PageClassesUseGrid;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;


public class TestSuiteBase{
	protected WebDriver driver;
	protected SearchPageFactory search;

	@Parameters({ "browser","platform", "url" })
	@BeforeClass
	public void beforeClass(String browser,String platform, String url) throws MalformedURLException {

		driver = getWebDriverInstance(browser,platform,url);
		search = PageFactory.initElements(driver, SearchPageFactory.class);
	}

	public static WebDriver getWebDriverInstance(String browser, String platform, String url)
			throws MalformedURLException {

		String nodeurl = "http://192.168.96.165:4444/wd/hub";
		DesiredCapabilities cap = new DesiredCapabilities();
		WebDriver driver = null;
		
		if (browser.equalsIgnoreCase("chrome")) {
			cap = DesiredCapabilities.chrome();
		} else if (browser.equalsIgnoreCase("firefox")) {
			cap = DesiredCapabilities.firefox();
		}

		if (platform.equalsIgnoreCase("windows")) {
			cap.setPlatform(Platform.WINDOWS);
		} 

		

		driver = new RemoteWebDriver(new URL(nodeurl), cap);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);

		return driver;
	}

	@AfterClass
	public void afterClass() throws Exception {
		driver.quit(); 
	}

}
