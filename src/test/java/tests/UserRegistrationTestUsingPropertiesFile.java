package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistration;

public class UserRegistrationTestUsingPropertiesFile extends TestBase{
	HomePage homeObject;
	UserRegistration registerObject;
	LoginPage loginObject;
	String firstname=LoadProperties.userData.getProperty("firstname");
	String lastname=LoadProperties.userData.getProperty("lastname");
	String email=LoadProperties.userData.getProperty("email");
	String password=LoadProperties.userData.getProperty("password");
	
	
	@Test (priority = 1 )
	public void userRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new UserRegistration(driver);
		registerObject.userRegistration(firstname, lastname, email, password);
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
		loginObject.userLogin(email,password);
		Assert.assertTrue(registerObject.logoutBtn.getText().equalsIgnoreCase("log out"));
	}

}
