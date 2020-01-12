package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistration;

public class UserRegistrationTest extends TestBase{
	HomePage homeObject;
	UserRegistration registerObject;
	LoginPage loginObject;
	
	@Test (priority = 1 )
	public void userRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new UserRegistration(driver);
		registerObject.userRegistration("Nahla", "Elsayed", "test133@yahoo.com", "123456");
		Assert.assertTrue(registerObject.successMsg.getText().contains("completed"));
		
	}
	@Test (dependsOnMethods= {"userRegisterSuccessfully"})
	public void registeredUserLogoutTest() {
		registerObject.userlogout();
	}
	
	@Test(dependsOnMethods= {"registeredUserLogoutTest"})
	public void registeredUserLoginTest() {
		homeObject.openLoginPage();
	    loginObject = new LoginPage(driver);
		loginObject.userLogin("testnahla2@gmail.com","123456");
		Assert.assertTrue(registerObject.logoutBtn.getText().equalsIgnoreCase("log out"));
	}

}
