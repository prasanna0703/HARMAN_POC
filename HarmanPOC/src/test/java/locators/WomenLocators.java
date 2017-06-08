package locators;

public class WomenLocators {
	public static final String WOMEN_HEADER = "//div[@class='cat_desc']/span[contains(text(),'Women')]",
			ADD_TO_CART1 = "//a[@title='",
			ADD_TO_CART2 = "']/parent::h5/following-sibling::div/span[@itemprop='price'][contains(text(),'$",
			ADD_TO_CART3 = "')]/parent::div/following-sibling::div/a/span[text()='Add to cart']",
			PRODUCT_TITLE = "layer_cart_product_title",
			PRODCUT_PRICE = "layer_cart_product_price",
			ADDED_TO_CART_SUCCESS_MESSAGE = "//h2[contains(.,'Product successfully added to your shopping cart')]",
			CONTINUE_SHOPPING = "//span[contains(.,'Continue shopping')]/i",
			TOTAL = "//strong[@class='dark']/following-sibling::span[@class='ajax_block_cart_total']",
			VIEW_CART = ".shopping_cart>a",
			TOTAL_PRICE_SUMMARY = "total_price";
}
