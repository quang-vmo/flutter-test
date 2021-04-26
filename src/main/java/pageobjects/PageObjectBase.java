package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class PageObjectBase {
	public int baseWaitElement = 10;
	/**
	 * find an element based on another element
	 * @param driver
	 * @param baseElement
	 * @param elementSelector
	 * @return null if no such element is found; otherwise, return the found element
	 */
	public MobileElement findElementBasedOnAnother(MobileElement baseElement, By elementSelector) {
		try {
			return baseElement.findElement(elementSelector);
		}catch(NoSuchElementException ex) {
			return null;
		}
	}
	
	/**
	 * Return an element with matching text from an element list
	 * @param driver : an instance of AppiumDriver
	 * @param by : selector of the element
	 * @param text : text to match
	 * @return
	 */
	public MobileElement getElementWithTextFromList(AppiumDriver driver, List<MobileElement> elementList, String text){
		for (MobileElement mobileElement : elementList) {
			if(mobileElement.getText().equals(text))
				return mobileElement;
		}
		return null;
	}
	
	/**
	 * click an element
	 * @param element
	 */
	public void click(MobileElement element) {
		element.click();
	}
	
	/**
	 * Tap an element
	 * @param driver: an instance of AppiumDriver
	 * @param element: element to tap
	 */
	public void tapElement(AppiumDriver driver, WebElement element){
		new TouchAction(driver).tap(new TapOptions().withElement(new ElementOption().withElement(element))).perform();
	}
	
	/**
	 * sned keys to element
	 * @param driver
	 * @param element
	 * @param keys
	 */
	public void sendKeys(AppiumDriver driver, MobileElement element, String keys) {
		click(element);
		new Actions(driver).sendKeys(keys).perform();
	}
	
	/**
	 * wait until an element is displayed
	 * @param driver
	 * @param element
	 * @param timeoutInSec
	 */
	public void waitForElementDisplayed(WebDriver driver, MobileElement element, int timeoutInSec) {
		new WebDriverWait(driver, timeoutInSec).until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * wait until text of element equals a value
	 * @param driver
	 * @param element
	 * @param text
	 * @param timeoutInSec
	 */
	public void waitForTextOfElementToEqual(WebDriver driver, MobileElement element, String text, int timeoutInSec) {
		new WebDriverWait(driver, timeoutInSec).until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	/**
	 * fixed wait
	 * @param millisec : wait in milliseconds
	 */
	public void wait(int millisec){
		try {
			Thread.sleep(millisec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
