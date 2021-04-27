package pageobjects;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeView extends PageObjectBase{
	private AppiumDriver driver;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Logout']")
	private MobileElement logOutButton;
	
	public HomeView(AppiumDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void verifyLogOutVisible() {
		Assert.assertTrue(logOutButton.isDisplayed(), "Logout button is not displayed");
	}
}
