package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.PaymentLocators;
import locators.SharedLocators;

public class PaymentPage {
	
	WebDriver driver;
	WebDriverWait wait;
	ShippingPage shipping;

	public PaymentPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait	= wait;
	}

	private PaymentPage verifyTotalPrice(String totalPrice) throws Exception{
		shipping = new ShippingPage(driver, wait);
		shipping.proceedToCheckout();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(PaymentLocators.TOTAL))));
		assertEquals(driver.findElement(By.id(PaymentLocators.TOTAL)).getText(),totalPrice);
		return this;
	}

	private PaymentPage selectPayementMethod(String paymentMethod) {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(PaymentLocators.PAYMENT_METHOD_PART1 + paymentMethod + SharedLocators.CLOSING_BRACKETS))));
		driver.findElement(By.xpath(PaymentLocators.PAYMENT_METHOD_PART1 + paymentMethod + SharedLocators.CLOSING_BRACKETS)).click();
		return this;
	}
	
	public PaymentPage verifyTotalAmountAndSelectPaymentMethod(String paymentMethod, String totalPrice) throws Exception {
		this.verifyTotalPrice(totalPrice);
		this.selectPayementMethod(paymentMethod);
		return this;
	}
}
