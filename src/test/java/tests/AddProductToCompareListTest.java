package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareListPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareListTest extends TestBase{
	
	String firstProductName="Apple MacBook Pro 13-inch";
	String secondProductName="Samsung Series 9 NP900X4C Premium Ultrabook";
	
	ProductDetailsPage detailsObject;
	SearchPage searchObject;
	CompareListPage compareObject;
	
	@Test (priority = 1)
	public void UserCanCompareProducts() throws InterruptedException{
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		compareObject = new CompareListPage(driver);
		
		searchObject.ProductSearch(firstProductName);
		detailsObject.addProductToCompareList();
		
		searchObject.ProductSearch(secondProductName);
		detailsObject.addProductToCompareList();
		
		Thread.sleep(2000);
		
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");		
		compareObject.compareProducts();
		 
	}
	@Test(priority = 2)
	public void UserCanClearCompareList() {
		compareObject.clearCompareList();
		Assert.assertTrue(compareObject.nodataHint.getText().contains("You have no items"));
	}

}
