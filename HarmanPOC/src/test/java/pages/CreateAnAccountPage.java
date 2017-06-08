package pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.CreateAnAccountLocators;

public class CreateAnAccountPage {

	WebDriver driver;
	WebDriverWait wait;
	AuthenticationPage authenticationPage;

	public CreateAnAccountPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait	= wait;
	}

	private CreateAnAccountPage enterFirstName(String firstName) throws Exception{
		driver.findElement(By.id(CreateAnAccountLocators.FIRSTNAME)).clear();
		driver.findElement(By.id(CreateAnAccountLocators.FIRSTNAME)).sendKeys(firstName);
		assertEquals(driver.findElement(By.id(CreateAnAccountLocators.FIRSTNAME)).getAttribute("value"),firstName);
		return this;
	}

	private CreateAnAccountPage enterLastName(String lastName) throws Exception{
		driver.findElement(By.id(CreateAnAccountLocators.LASTNAME)).clear();
		driver.findElement(By.id(CreateAnAccountLocators.LASTNAME)).sendKeys(lastName);
		assertEquals(driver.findElement(By.id(CreateAnAccountLocators.LASTNAME)).getAttribute("value"),lastName);
		return this;
	}

	private CreateAnAccountPage verifyEmailAddress(String email) throws Exception{
		assertEquals(driver.findElement(By.id(CreateAnAccountLocators.EMAIL)).getAttribute("value"),email);
		return this;
	}

	private CreateAnAccountPage enterPassword(String password) throws Exception{
		driver.findElement(By.id(CreateAnAccountLocators.PASSWORD)).clear();
		driver.findElement(By.id(CreateAnAccountLocators.PASSWORD)).sendKeys(password);
		return this;
	}

	private CreateAnAccountPage verifyFirstName(String firstName) throws Exception{
		assertEquals(driver.findElement(By.id(CreateAnAccountLocators.FIRSTNAME_ADDRESS)).getAttribute("value"),firstName);
		return this;
	}

	private CreateAnAccountPage verifyLastName(String lastName) throws Exception{
		assertEquals(driver.findElement(By.id(CreateAnAccountLocators.LASTNAME_ADDRESS)).getAttribute("value"),lastName);
		return this;
	}

	private CreateAnAccountPage enterAddress(String address) throws Exception{
		driver.findElement(By.id(CreateAnAccountLocators.ADDRESS)).clear();
		driver.findElement(By.id(CreateAnAccountLocators.ADDRESS)).sendKeys(address);
		assertEquals(driver.findElement(By.id(CreateAnAccountLocators.ADDRESS)).getAttribute("value"),address);
		return this;
	}

	private CreateAnAccountPage enterCity(String city) throws Exception{
		driver.findElement(By.id(CreateAnAccountLocators.CITY)).clear();
		driver.findElement(By.id(CreateAnAccountLocators.CITY)).sendKeys(city);
		assertEquals(driver.findElement(By.id(CreateAnAccountLocators.CITY)).getAttribute("value"),city);
		return this;
	}

	private CreateAnAccountPage selectState(String state) throws Exception{
		Select dropdown = new Select(driver.findElement(By.id(CreateAnAccountLocators.STATE)));
		dropdown.selectByVisibleText(state);
		assertEquals(dropdown.getFirstSelectedOption().getText(),state);
		return this;
	}

	private CreateAnAccountPage enterZip(String zip) throws Exception{
		driver.findElement(By.id(CreateAnAccountLocators.ZIP)).clear();
		driver.findElement(By.id(CreateAnAccountLocators.ZIP)).sendKeys(zip);
		assertEquals(driver.findElement(By.id(CreateAnAccountLocators.ZIP)).getAttribute("value"),zip);
		return this;
	}

	private CreateAnAccountPage enterMobilePhone(String mobileNumber) throws Exception{
		driver.findElement(By.id(CreateAnAccountLocators.MOBILE_PHONE)).clear();
		driver.findElement(By.id(CreateAnAccountLocators.MOBILE_PHONE)).sendKeys(mobileNumber);
		assertEquals(driver.findElement(By.id(CreateAnAccountLocators.MOBILE_PHONE)).getAttribute("value"),mobileNumber);
		return this;
	}

	private CreateAnAccountPage enterAliasAddress(String aliasAddress) throws Exception{
		driver.findElement(By.id(CreateAnAccountLocators.ALIAS_ADDRESS)).clear();
		driver.findElement(By.id(CreateAnAccountLocators.ALIAS_ADDRESS)).sendKeys(aliasAddress);
		assertEquals(driver.findElement(By.id(CreateAnAccountLocators.ALIAS_ADDRESS)).getAttribute("value"),aliasAddress);
		return this;
	}

	private CreateAnAccountPage clickOnRegister() throws Exception{
		driver.findElement(By.id(CreateAnAccountLocators.REGISTER)).click();
		return this;
	}

	public CreateAnAccountPage registerUser(String firstName, String lastName, String email, String password,
			String address, String city, String state, String zip, String mobileNumber, String aliasAddress) throws Exception {
		authenticationPage = new AuthenticationPage(driver, wait);
		authenticationPage.enterEmailAddress(email)
						  .clickOnCreateAnAccount();
		this.enterFirstName(firstName);
		this.enterLastName(lastName);
		this.verifyEmailAddress(email);
		this.enterPassword(password);
		this.enterAddress(address);
		this.enterCity(city);
		this.selectState(state);
		this.enterZip(zip);
		this.enterMobilePhone(mobileNumber);
		this.enterAliasAddress(aliasAddress);
		this.verifyFirstName(firstName);
		this.verifyLastName(lastName);
		this.clickOnRegister();
		
		return this;
	}

}
