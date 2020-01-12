package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{
	
	HomePage homeObject;
	ProductDetailsPage detailsObject;
	SearchPage searchObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Test (priority = 1)
	public void UserCanChangeCurrency() {
		homeObject = new HomePage(driver);
		homeObject.changeCurrency();	
	}
	@Test (priority= 2)
	public void UserCanSearchUsingAutoSuggest() {
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutosuggest("macbook");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(detailsObject.priceLabel.getText().contains("Ђ"));
	}

}
