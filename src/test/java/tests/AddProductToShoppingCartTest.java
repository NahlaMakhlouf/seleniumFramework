package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase{
	
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartObject;
	
	String productName="Samsung Series 9 NP900X4C Premium Ultrabook";
	
	@Test (priority = 1)
	public void UserCanSearchUsingAutoSuggest() {
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutosuggest("samsung");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
	}
	
	@Test(priority = 2)
	public void UserCanAddProductToCart() throws InterruptedException {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.addProductToShoppingCart();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
	}
	
	@Test(priority = 3)
	public void UserCanRemoveProductFromCart() {
		cartObject = new ShoppingCartPage(driver);
		cartObject.RemoveProductFromCart(); 
		Assert.assertTrue(cartObject.emptyCartHint.getText().contains("empty!"));
	}

}
