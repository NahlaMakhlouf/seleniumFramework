package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegistration;

public class RegisteredUserCheckoutTest extends TestBase{
	
	HomePage homeObject;
	UserRegistration registerObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartObject;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderDetailsObject;
	
	String productName = "Samsung Series 9 NP900X4C Premium Ultrabook";
	
	@Test (priority = 1 )
	public void userRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new UserRegistration(driver);
		registerObject.userRegistration("Nahla", "Elsayed", "test12@yahoo.com", "123456");
		Assert.assertTrue(registerObject.successMsg.getText().contains("completed"));	
	}
	
	@Test (priority = 2) 
	public void UserCanSearchUsingAutoSuggest() {
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutosuggest("samsung");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
	}
	
	@Test(priority = 3)
	public void UserCanAddProductToCart() throws InterruptedException {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.addProductToShoppingCart();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
	}
	
	@Test(priority = 4)
	public void RegisteredUserCanCheckout() throws InterruptedException {
		cartObject = new ShoppingCartPage(driver);
		cartObject.OpenCheckoutPage();
		
		checkoutObject = new CheckoutPage(driver);
		checkoutObject.RegisteredUserCheckout("Egypt", "Alex", "Victoria", "123", "01007383387");
		Assert.assertTrue(checkoutObject.successMsg.isDisplayed());
		Thread.sleep(4000);
		
		checkoutObject.OpenOrderDetails();
		
		orderDetailsObject = new OrderDetailsPage(driver);
		orderDetailsObject.DownloadPDFInvoice();
		orderDetailsObject.PrintOrderDetails();
				
	}
	
	//@Test(priority = 5)
	//public void registeredUserLogoutTest() {
	//	registerObject.userlogout();
	//} 
	


}
