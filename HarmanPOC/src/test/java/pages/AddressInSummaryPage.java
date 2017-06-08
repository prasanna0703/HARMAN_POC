package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import locators.AddressInSummaryLocators;
import locators.SharedLocators;

public class AddressInSummaryPage {

	WebDriver driver;
	WebDriverWait wait;

	public AddressInSummaryPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait	= wait;
	}

	public AddressInSummaryPage verifyDeliveryAddressDetails(String firstName, String lastName, String city, String State, String zip, String countryName, String phone) throws Exception{
		driver.navigate().refresh();
		String fullName = firstName + SharedLocators.SPACE + lastName;
		String fullAddress = city + SharedLocators.COMMA + State + SharedLocators.SPACE + zip;
		assertEquals(driver.findElement(By.cssSelector(AddressInSummaryLocators.FIRST_AND_LASTNAME_DELIVERY)).getText(), fullName );
		assertEquals(driver.findElement(By.cssSelector(AddressInSummaryLocators.CITY_STATE_DELIVERY)).getText(), fullAddress);
		assertEquals(driver.findElement(By.cssSelector(AddressInSummaryLocators.COUNTRY_NAME)).getText(), countryName);
		assertEquals(driver.findElement(By.cssSelector(AddressInSummaryLocators.PHONE)).getText(),  phone);
		return this;
	}
}