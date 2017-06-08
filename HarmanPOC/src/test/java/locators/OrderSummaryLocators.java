package locators;

public class OrderSummaryLocators {

	public static final String ORDER_SUMMARY_HEADER	= "//h1[contains(text(),'Order summary')]",
			PAYMENT_METHOD						= "//h3[contains(text(),'",
			PAYMENT_METHOD_CONFIRMATION_PART1	= "//strong[contains(text(),'You have chosen to ",
			PAYMENT_METHOD_CONFIRMATION_PART2 	= ". Here is a short summary of your order:')]",
			TOTAL_AMOUNT_SUMMARY				= "//p[contains(text(),'The total amount of your order comes to:')]/span[@id='amount']",
			CONFIRM_ORDER						= "//span[text()='I confirm my order']",
			ORDER_COMPLETE						= "//strong[text()='Your order on My Store is complete.']";
			
}