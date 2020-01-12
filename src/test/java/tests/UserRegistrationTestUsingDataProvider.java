package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistration;

public class UserRegistrationTestUsingDataProvider extends TestBase{
	HomePage homeObject;
	UserRegistration registerObject;
	LoginPage loginObject;
	
	@DataProvider (name="testData")
	public static Object[][] userData(){
		return new Object[][] {
			{"Nahla","Elsayed","test24@yahoo.com","123456"},{"Noha","Elsayed","test25@yahoo.com","123456"}
			};
		
	}
	
	@Test (priority = 1, dataProvider="testData" )
	public void userRegisterSuccessfully(String fname, String lname, String mail, String Password) {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new UserRegistration(driver);
		registerObject.userRegistration(fname,lname,mail,Password);
		Assert.assertTrue(registerObject.successMsg.getText().contains("completed"));
		registerObject.userlogout();
	
	}
	
	
	@Test(dependsOnMethods= {"registeredUserLogoutTest"}, enabled=false)
	public void registeredUserLoginTest() {
		homeObject.openLoginPage();
	    loginObject = new LoginPage(driver);
		loginObject.userLogin("testnahla2@gmail.com","123456");
		Assert.assertTrue(registerObject.logoutBtn.getText().equalsIgnoreCase("log out"));
	}

}
