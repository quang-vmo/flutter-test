package login;

import org.springframework.util.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageobjects.HomeView;
import pageobjects.LoginView;

public class LoginTests extends BaseTest{
	
	@Test
	public void TestLoginFlutter() {
		LoginView loginView = new LoginView(driver);
		HomeView homeView = new HomeView(driver);
		loginView.login("username", "password");
		Assert.isTrue(homeView.isLogOutVisible(), "Logout button is not displayed");
	}
}
