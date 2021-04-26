package pageobjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginView extends PageObjectBase{
	private AppiumDriver driver;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='username']")
	private MobileElement usernameInput;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='password']")
	private MobileElement passwordInput;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Login']")
	private MobileElement loginButton;
	
	public LoginView(AppiumDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	private void setUsername(String username) {
		sendKeys(driver, usernameInput, username);
	}
	
	private void setPassword(String password) {
		sendKeys(driver, passwordInput, password);
	}
	
	private void clickLogin() {
		click(loginButton);
	}
	
	public void login(String username, String password) {
		setUsername(username);
		setPassword(password);
		clickLogin();
	}
}
