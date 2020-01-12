package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggest extends TestBase {
	
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	@Test
	public void UserCanSearchUsingAutoSuggest() {
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutosuggest("macbook");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
	}

}
