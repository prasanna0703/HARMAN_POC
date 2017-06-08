package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.OrderSummaryLocators;
import locators.SharedLocators;

public class OrderSummaryPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public OrderSummaryPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait	= wait;
	}

	private OrderSummaryPage verifyOrderSummaryPage() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(OrderSummaryLocators.ORDER_SUMMARY_HEADER))));
		assertTrue(driver.findElement(By.xpath(OrderSummaryLocators.ORDER_SUMMARY_HEADER)).isDisplayed());
		return this;
	}
	
	private OrderSummaryPage verifyPaymentMethod(String paymentMethod) throws Exception{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(OrderSummaryLocators.PAYMENT_METHOD+paymentMethod+SharedLocators.DOUBLE_CLOSING_BRACKETS))));
		assertTrue(driver.findElement(By.xpath(OrderSummaryLocators.PAYMENT_METHOD+paymentMethod+SharedLocators.DOUBLE_CLOSING_BRACKETS)).isDisplayed());
		return this;
	}
	
	private OrderSummaryPage verifyPaymentMethodConfirmation(String selectedPaymetnMethod) throws Exception{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(OrderSummaryLocators.PAYMENT_METHOD_CONFIRMATION_PART1+selectedPaymetnMethod+OrderSummaryLocators.PAYMENT_METHOD_CONFIRMATION_PART2))));
		assertTrue(driver.findElement(By.xpath(OrderSummaryLocators.PAYMENT_METHOD_CONFIRMATION_PART1 + selectedPaymetnMethod + OrderSummaryLocators.PAYMENT_METHOD_CONFIRMATION_PART2)).isDisplayed());
		return this;
	}
	
	private OrderSummaryPage verifyTotalAmount(String amount) throws Exception{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(OrderSummaryLocators.TOTAL_AMOUNT_SUMMARY))));
		assertTrue(driver.findElement(By.xpath(OrderSummaryLocators.TOTAL_AMOUNT_SUMMARY)).isDisplayed());
		assertEquals(driver.findElement(By.xpath(OrderSummaryLocators.TOTAL_AMOUNT_SUMMARY)).getText(), amount);
		return this;
	}
	
	private OrderSummaryPage clickOnConfirmOrder() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(OrderSummaryLocators.CONFIRM_ORDER))));
		WebElement element = driver.findElement(By.xpath(OrderSummaryLocators.CONFIRM_ORDER));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		return this;
	}
	
	private OrderSummaryPage verifyOrderIsComplete() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(OrderSummaryLocators.ORDER_COMPLETE))));
		assertTrue(driver.findElement(By.xpath(OrderSummaryLocators.ORDER_COMPLETE)).isDisplayed());
		return this;
	}
	
	public OrderSummaryPage verifyOrderSummaryDetails(String paymentMethod, String selectedPaymetnMethod, String amount) throws Exception{
		selectedPaymetnMethod = selectedPaymetnMethod.replace(".", "");
		selectedPaymetnMethod = selectedPaymetnMethod.toLowerCase();
		this.verifyOrderSummaryPage();
		this.verifyPaymentMethod(paymentMethod);
		this.verifyPaymentMethodConfirmation(selectedPaymetnMethod);
		this.verifyTotalAmount(amount);
		this.clickOnConfirmOrder();
		this.verifyOrderIsComplete();
		return this;
	}
}