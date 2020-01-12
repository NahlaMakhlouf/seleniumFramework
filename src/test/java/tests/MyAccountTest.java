package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistration;

public class MyAccountTest extends TestBase{
	HomePage homeObject;
	LoginPage loginObject;
	UserRegistration registerObject;
	MyAccountPage myaccountObject;
	
	@Test (priority = 1 )
	public void userRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new UserRegistration(driver);
		registerObject.userRegistration("Nahla", "Elsayed", "test4@yahoo.com", "123456");
		Assert.assertTrue(registerObject.successMsg.getText().contains("completed"));	
	}
	@Test (priority = 2 )
	public void userChangePassword() {
		myaccountObject = new MyAccountPage(driver);
		registerObject.openMyAccount();
		myaccountObject.openChangePassword();
		myaccountObject.userChangePassword("123456", "12345678");
		Assert.assertTrue(myaccountObject.resultLabel.getText().contains("Password was changed"));
	}
	
	@Test (priority = 3 )
	public void registeredUserLogoutTest() {
		registerObject.userlogout();
	}
	
	@Test(priority = 4 )
	public void registeredUserLoginTest() {
		homeObject.openLoginPage();
	    loginObject = new LoginPage(driver);
		loginObject.userLogin("testnahla5@gmail.com","12345678");
		Assert.assertTrue(registerObject.logoutBtn.getText().equalsIgnoreCase("log out"));
	}


}
