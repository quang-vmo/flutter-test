package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	protected AndroidDriver driver;
	
	@BeforeSuite
	public void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("udid", CommonUtility.getConfigInfo("udid"));
		capabilities.setCapability("platformName", CommonUtility.getConfigInfo("platformName"));
	    capabilities.setCapability("appPackage", CommonUtility.getConfigInfo("appPackage"));
		capabilities.setCapability("appActivity", CommonUtility.getConfigInfo("appActivity")); 
		driver = new AndroidDriver(new URL(CommonUtility.getConfigInfo("appiumURL")), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
}
