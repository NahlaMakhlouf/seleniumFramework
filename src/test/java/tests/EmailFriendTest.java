package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistration;

public class EmailFriendTest extends TestBase {
	
	HomePage homeObject;
	UserRegistration registerObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage emailObject;
	
	String productName = "Apple MacBook Pro 13-inch";
	
	//1-user registration
	@Test (priority = 1 )
	public void userRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new UserRegistration(driver);
		registerObject.userRegistration("Nahla", "Elsayed", "test2@yahoo.com", "123456");
		
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
	//3- user send mail to friend
	@Test (priority= 3)
	public void RegisteredUserCanSendEmailToFriend() {
		detailsObject.openSendEmailPage();
		emailObject = new EmailPage(driver);
		emailObject.SendEmailToFriend("nahlamakhlouf1@gmail.com", "test message");
		Assert.assertTrue(emailObject.sucessMsg.getText().contains("has been sent"));
				
	}
	//4- user log out 
	@Test (priority = 4)
	public void registeredUserLogoutTest() {
		registerObject.userlogout();
	}


}
