package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.WomenData;
import locators.WomenLocators;

public class WomenPage {

	WebDriver driver;
	WebDriverWait wait;

	public WomenPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait	= wait;
	}

	/*public WomenPage addProductsToCart(ArrayList<String> dressName, List<Double> price) throws Exception{
		Iterator<String> iterator = dressName.iterator();
		Iterator<Double> iterator1 = price.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			Double nextPrice = iterator1.next();
			WebElement element = driver.findElement(By.xpath(WomenLocators.ADD_TO_CART1 + next + WomenLocators.ADD_TO_CART2 + nextPrice + WomenLocators.ADD_TO_CART3));
			Actions action = new Actions(this.driver);
			action.moveToElement(element).build().perform();
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}
		return this;
	}*/


	public WomenPage addProductsToCart(String dressName, String price) throws Exception{
		WebElement element = driver.findElement(By.xpath(WomenLocators.ADD_TO_CART1 + dressName + WomenLocators.ADD_TO_CART2 + price + WomenLocators.ADD_TO_CART3));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Actions action = new Actions(this.driver);
		action.moveToElement(element).build().perform();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		return this;
	}


	public WomenPage verifyAddedToCartSuccessMessage() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(WomenLocators.ADDED_TO_CART_SUCCESS_MESSAGE))));
		assertTrue(driver.findElement(By.xpath(WomenLocators.ADDED_TO_CART_SUCCESS_MESSAGE)).isDisplayed(),"Success Message is not displayed after adding to cart");
		return this;
	}

	public WomenPage verifyProductName(String dressName) throws Exception{
		wait.until(ExpectedConditions.numberOfElementsToBe(By.id(WomenLocators.PRODUCT_TITLE), 1));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(WomenLocators.PRODUCT_TITLE))));
		driver.findElement(By.id(WomenLocators.PRODUCT_TITLE)).isDisplayed();
		assertEquals(driver.findElement(By.id(WomenLocators.PRODUCT_TITLE)).getText(),dressName);
		return this;
	}

	public WomenPage verifyProductPrice(String price) throws Exception{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(WomenLocators.PRODCUT_PRICE))));
		driver.findElement(By.id(WomenLocators.PRODCUT_PRICE)).isDisplayed();
		assertEquals(driver.findElement(By.id(WomenLocators.PRODCUT_PRICE)).getText(),price);
		return this;
	}

	public String clickOnContinueShopping() throws Exception{
		String total = driver.findElement(By.xpath(WomenLocators.TOTAL)).getText();
		System.out.println("total"+total);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(WomenLocators.CONTINUE_SHOPPING))));
		driver.findElement(By.xpath(WomenLocators.CONTINUE_SHOPPING)).click();
		return total;
	}

	public String addMutlipleProductsToCart(ArrayList<String> dressName, ArrayList<String> price) throws Exception{
		Iterator<String> iterator = dressName.iterator();
		Iterator<String> iterator1 = price.iterator();
		String total = "";
		while (iterator.hasNext()) {
			String dress = iterator.next();
			String nextPrice = iterator1.next();
			this.addProductsToCart(dress, nextPrice);
			this.verifyAddedToCartSuccessMessage();
			this.verifyProductName(dress);
			this.verifyProductPrice(WomenData.DOLLAR+nextPrice);
			total = this.clickOnContinueShopping();
		}
		return total;
	}

	public WomenPage clickOnCartToView() throws Exception{
		driver.findElement(By.cssSelector(WomenLocators.VIEW_CART)).isDisplayed();
		driver.findElement(By.cssSelector(WomenLocators.VIEW_CART)).isEnabled();
		driver.findElement(By.cssSelector(WomenLocators.VIEW_CART)).sendKeys(Keys.ENTER);
		return this;
	}

	public WomenPage verifyTotalPriceOnSummaryPage(String total) throws Exception{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id((WomenLocators.TOTAL_PRICE_SUMMARY)))));
		assertTrue(driver.findElement(By.id((WomenLocators.TOTAL_PRICE_SUMMARY))).isDisplayed(),total + " is not displayed");
		return this;
	}

}
