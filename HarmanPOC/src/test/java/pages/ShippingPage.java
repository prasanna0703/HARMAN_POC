package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import locators.ShippingLocators;

public class ShippingPage {

	WebDriver driver;
	WebDriverWait wait;

	public ShippingPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait	= wait;
	}
	
	public ShippingPage proceedToCheckout() throws Exception{
		driver.findElement(By.xpath(ShippingLocators.PROCEED_TO_CHECKOUT)).isDisplayed();
		driver.findElement(By.xpath(ShippingLocators.PROCEED_TO_CHECKOUT)).isDisplayed();
		driver.findElement(By.xpath(ShippingLocators.PROCEED_TO_CHECKOUT)).click();
		return this;
	}

	public ShippingPage selectTermsOfService() throws Exception{
		this.proceedToCheckout();
		if(!driver.findElement(By.id(ShippingLocators.TERMS_OF_SERVICE)).isSelected()){
			driver.findElement(By.id(ShippingLocators.TERMS_OF_SERVICE)).click();
		}
		assertTrue(driver.findElement(By.id(ShippingLocators.TERMS_OF_SERVICE)).isSelected(),"Terms of service is not selected");
		return this;
	}

}
