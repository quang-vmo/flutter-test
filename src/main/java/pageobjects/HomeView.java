package pageobjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeView extends PageObjectBase{
	private AppiumDriver driver;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Continue with email']")
	private MobileElement logOutButton;
	
	public HomeView(AppiumDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public boolean isLogOutVisible() {
		return logOutButton.isDisplayed();
	}
}
