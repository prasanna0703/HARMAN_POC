package requirements;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import configuration.Configuration;
import data.CommonData;
import data.CreateAnAccountData;
import data.OrderSummaryData;
import data.PaymentMethodsData;
import data.WomenData;
import pages.AddressInSummaryPage;
import pages.CreateAnAccountPage;
import pages.HomePage;
import pages.OrderSummaryPage;
import pages.PaymentPage;
import pages.SharedPage;
import pages.ShippingPage;
import pages.WomenPage;

public class UserCanBuyProducts extends Configuration{
	
	SharedPage shared;
	HomePage home;
	CreateAnAccountPage createAnAccountPage;
	CreateAnAccountData accountData;
	WomenPage womenPage;
	AddressInSummaryPage address;
	ShippingPage shipping;
	PaymentPage payment;
	OrderSummaryPage orderSummary;
	
	@Test(description = "Verify user can register to the application")
	public void registeringTotheApplication() throws Exception{

		//Creating page objects
		 shared					= new SharedPage(driver, wait);
		 home					= new HomePage(driver, wait);
		 accountData			= new CreateAnAccountData();
		 womenPage				= new WomenPage(driver, wait);
		 address				= new AddressInSummaryPage(driver, wait);
		 createAnAccountPage	= new CreateAnAccountPage(driver, wait);
		 shipping				= new ShippingPage(driver, wait);
		 payment				= new PaymentPage(driver, wait);
		 orderSummary			= new OrderSummaryPage(driver, wait);
		 
		 ArrayList<String> dressNames = new ArrayList<String>(Arrays.asList(WomenData.PRINTED_DRESS, WomenData.PRINTED_SUMMER_DRESS));
		 ArrayList<String> price = new ArrayList<String>(Arrays.asList(WomenData.PRINTED_DRESS_PRICE, WomenData.PRINTED_SUMMER_DRESS_PRICE));
		 
		 String firstName	= accountData.firstName,
				 lastName	= accountData.lastName,
				 email		= accountData.email;
		 
		 //Test Steps to register as user
		 shared.launchURL(CommonData.URL);
		 home.clickOnSignIn();
		 createAnAccountPage.registerUser(firstName, lastName, email, CreateAnAccountData.PASSWORD, CreateAnAccountData.ADDRESS, CreateAnAccountData.CITY, CreateAnAccountData.STATE, CreateAnAccountData.ZIP, CreateAnAccountData.MOBILE_NUMBER, email);
		 shared.naviagteToWomen()
		 	   .searchForProduct(CommonData.SEARCH_TEXT_PRINTED);
		 String totalAmount = womenPage.addMutlipleProductsToCart(dressNames, price);
		 womenPage.clickOnCartToView()
		          .verifyTotalPriceOnSummaryPage(totalAmount);
		 shared.proceedToCheckout();
		 address.verifyDeliveryAddressDetails(firstName, lastName, CreateAnAccountData.CITY, CreateAnAccountData.STATE, CreateAnAccountData.ZIP, CreateAnAccountData.COUNTRY_NAME, CreateAnAccountData.MOBILE_NUMBER);
		 shipping.selectTermsOfService();
		 payment.verifyTotalAmountAndSelectPaymentMethod(PaymentMethodsData.PAY_BY_BANK_WIRE, totalAmount);
		 orderSummary.verifyOrderSummaryDetails(OrderSummaryData.BANK_WIRE_PAYMENT, PaymentMethodsData.PAY_BY_BANK_WIRE, totalAmount);
		 shared.takeScreenShot();
	}
}
