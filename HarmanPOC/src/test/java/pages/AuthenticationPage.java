package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import locators.AuthenticationLocators;
import locators.CreateAnAccountLocators;

public class AuthenticationPage {

	WebDriver driver;
	WebDriverWait wait;

	public AuthenticationPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait	= wait;
	}

	public AuthenticationPage enterEmailAddress(String email) throws Exception{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(AuthenticationLocators.EMAIL_ADDRESS)));
		driver.findElement(By.id(AuthenticationLocators.EMAIL_ADDRESS)).clear();
		driver.findElement(By.id(AuthenticationLocators.EMAIL_ADDRESS)).sendKeys(email);
		assertEquals(driver.findElement(By.id(AuthenticationLocators.EMAIL_ADDRESS)).getAttribute("value"),email);
		return this;
	}

	public AuthenticationPage clickOnCreateAnAccount() throws Exception{
		driver.findElement(By.id(AuthenticationLocators.CREATE_AN_ACCOUNT)).click();
		assertTrue(driver.findElement(By.xpath(CreateAnAccountLocators.YOUR_PERSONAL_INFORMATION)).isDisplayed(),"YOUR PERSONAL INFORMATION header is not displayed");
		return this;
	}

}
