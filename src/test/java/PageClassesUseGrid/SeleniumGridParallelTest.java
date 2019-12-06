package PageClassesUseGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumGridParallelTest {
	WebDriver driver;
	   
    String baseurl;
    String nodeurl;
    SearchPageFactory spFactory;
	
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	 
		//	driver = new ChromeDriver();
	   
		
		  baseurl="https://taap.expedia.cn/";
		  
		  //node �� url�� test case����������ϱ����е� 
		  nodeurl="http://192.168.96.165:5555/wd/hub"; 
		  
		  DesiredCapabilities cap=DesiredCapabilities.firefox(); 
		 
		/*
		 * FirefoxOptions opt = new FirefoxOptions(); opt.merge(cap);
		 */
		  
		  cap.setBrowserName("firefox");
		  cap.setPlatform(Platform.WINDOWS); 
		  cap.setVersion("66.0.3");
		  driver=new RemoteWebDriver(new URL(nodeurl),cap);
		 
		    
			
		//	spFactory =new SearchPageFactory(driver);
			
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		
	  
  }

  @Test
  public void test() throws InterruptedException {
	    driver.get(baseurl);
		spFactory.setDestination("�Ϻ� (�����ܱߵ���), �й�");	
		spFactory.setCheckinDate("2019/11/22");
		spFactory.setCheckoutDate("2019/11/23");
		Thread.sleep(3000);
		
		spFactory.clickHotelGuestTextbox();
		spFactory.setAdultsTotal(2);
		spFactory.clickSearchButton();
	  
  }
  @AfterClass
  public void afterClass() throws InterruptedException {
	    Thread.sleep(3000);
	//	driver.quit();
  }

}
