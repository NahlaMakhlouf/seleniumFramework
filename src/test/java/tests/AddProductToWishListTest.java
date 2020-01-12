package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase{
	
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishListPage wishlistObject;
	
	String productName = "Samsung Series 9 NP900X4C Premium Ultrabook";
	
	@Test(priority = 1)
	public void UserCanSearchUsingAutoSuggest() {
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutosuggest("samsung");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
	}
	
	@Test(priority = 2)
	public void UserCanAddProductToWishList() throws InterruptedException{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.addProductToWishList();
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");
		wishlistObject = new WishListPage(driver);
		Assert.assertTrue(wishlistObject.wishListHeader.getText().contains("Wishlist"));
		
	}
	
	@Test(priority = 3)
	public void UserCanRemoveProductFromWishList() {
		wishlistObject = new WishListPage(driver);
		wishlistObject.removeProductFromWishList();
		Assert.assertTrue(wishlistObject.emptyListHint.getText().contains("empty!"));
		
	}
}
