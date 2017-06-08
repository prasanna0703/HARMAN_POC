package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.SharedLocators;
import locators.WomenLocators;

public class SharedPage {

	WebDriver driver;
	WebDriverWait wait;

	public SharedPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait	= wait;
	}

	public SharedPage launchURL(String URL) {
		driver.get(URL);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return this;
	}

	public SharedPage naviagteToWomen() {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(SharedLocators.WOMEN))));
		driver.findElement(By.xpath(SharedLocators.WOMEN)).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(SharedLocators.WOMEN))));
		assertTrue(driver.findElement(By.xpath(WomenLocators.WOMEN_HEADER)).isDisplayed(),"Woman header is not displayed");
		return this;
	}


	private SharedPage enterInSearchField(String searchData) throws Exception{
		driver.findElement(By.id(SharedLocators.SEARCH_BOX)).clear();
		driver.findElement(By.id(SharedLocators.SEARCH_BOX)).sendKeys(searchData);
		assertEquals(driver.findElement(By.id(SharedLocators.SEARCH_BOX)).getAttribute("value"),searchData);
		return this;
	}

	private SharedPage clickSearchButton(String searchData) throws Exception{
		driver.findElement(By.name(SharedLocators.SEARCH_BUTTON)).click();
		return this;
	}

	public SharedPage verifySearchedText(String searchedText) throws Exception{
		assertTrue(driver.findElement(By.xpath(SharedLocators.SEARCHED_TEXT + searchedText + SharedLocators.DOUBLE_CLOSING_BRACKETS)).isDisplayed(),searchedText + " is not displayed");
		return this;
	}

	public SharedPage searchForProduct(String searchData) throws Exception{
		this.enterInSearchField(searchData);
		this.clickSearchButton(searchData);
		this.verifySearchedText(searchData);
		return this;
	}

	public SharedPage proceedToCheckout() throws Exception{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(SharedLocators.PROCEED_TO_CHECKOUT))));
		WebElement element = driver.findElement(By.xpath(SharedLocators.PROCEED_TO_CHECKOUT));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.xpath(SharedLocators.PROCEED_TO_CHECKOUT)).isDisplayed();
		driver.findElement(By.xpath(SharedLocators.PROCEED_TO_CHECKOUT)).isDisplayed();
		driver.findElement(By.xpath(SharedLocators.PROCEED_TO_CHECKOUT)).click();
		return this;
	}

	public SharedPage takeScreenShot() throws Exception {
		System.out.println("----Taking Screenshot----");
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File screenshotAs = takeScreenshot.getScreenshotAs(OutputType.FILE);
		Calendar calendar = Calendar.getInstance();
		Date time = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("dd_M_yyyy_HH_mm_ss");
		String screenshotTakeAt = format.format(time);
		File file = new File(".//src//test/resources//Screenshots//Scrrenshot" + screenshotTakeAt + ".png");
		FileUtils.copyFile(screenshotAs, file);
		String property = System.getProperty("user.dir");
		System.out.println("Screenshot taken and stored at:\n" + property + "/src/test/resources/Screenshots\n"
				+ "as \nScrrenshot" + screenshotTakeAt);
		return this;
	}
}
