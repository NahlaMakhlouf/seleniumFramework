package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistration;

public class AddProductReviewTest extends TestBase{
	HomePage homeObject;
	UserRegistration registerObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage emailObject;
	ProductReviewPage reviewObject;
	
	String productName = "Apple MacBook Pro 13-inch";
	
	//1-user registration
	@Test (priority = 1 )
	public void userRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new UserRegistration(driver);
		registerObject.userRegistration("Nahla", "Elsayed", "test10@yahoo.com.com", "123456");
		
		Assert.assertTrue(registerObject.successMsg.getText().contains("completed"));	
	}
	//2- user search for product
	@Test (priority = 2 )
	public void UserCanSuggestUsingAutoSuggest() {
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutosuggest("macbook");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
	}
	//3- user add review
	@Test (priority= 3)
	public void RegisteredUserCanAddReview() {
		detailsObject.openAddYourReview();
		reviewObject = new ProductReviewPage(driver);
		reviewObject.AddProductReview("mac bro", "test review");			
	}
	//4- user log out 
	@Test (priority = 4)
	public void registeredUserLogoutTest() {
		registerObject.userlogout();
	}


}
