package locators;

public class SharedLocators {
	public static final String CLOSING_BRACKETS = "']",
			DOUBLE_CLOSING_BRACKETS = "')]",
			SEARCH_BOX				= "search_query_top",
			SEARCH_BUTTON			= "submit_search",
			WOMEN					= "//a[text()='Women'][@title='Women']",
			SEARCHED_TEXT			= "//span[@class='lighter'][contains(text(),'",
			PROCEED_TO_CHECKOUT		= "//span[contains(.,'Proceed to checkout')]/parent::a[@style='']",
			PRODUCT_DETAILS			= "//a[text()='Printed Dress']/parent::p/parent::td/following-sibling::td//span[text()='$50.99']/parent::span/parent::td/following-sibling::td/input[@value='1']/parent::td/following-sibling::td/span[contains(text(),'$50.99')]",
			SPACE					= " ",
			COMMA					= ", ";
	
			
}
