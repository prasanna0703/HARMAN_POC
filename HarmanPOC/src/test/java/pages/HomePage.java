package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import locators.AuthenticationLocators;
import locators.HomeLocators;
import pages.HomePage;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait	= wait;
	}

	public HomePage clickOnSignIn() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className(HomeLocators.SIGN_IN))));
		driver.findElement(By.className(HomeLocators.SIGN_IN)).isDisplayed();
		driver.findElement(By.className(HomeLocators.SIGN_IN)).click();
		assertTrue(driver.findElement(By.cssSelector(AuthenticationLocators.CREATE_AN_ACCOUNT_HEADER)).isDisplayed(),"Create an Account header is not displayed");
		return this;
	}

	public HomePage verifyLoggedInUser(String firstName, String lastname) throws Exception{
		assertTrue(driver.findElement(By.xpath(HomeLocators.FIRST_AND_LAST_NAME + firstName+ " " + lastname + HomeLocators.CLOSING_BRACKETS)).isDisplayed(),firstName+ " " + lastname +" is not displayed");
		return this;
	}
}
