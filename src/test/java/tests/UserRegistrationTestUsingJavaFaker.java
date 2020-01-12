package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistration;

public class UserRegistrationTestUsingJavaFaker extends TestBase{
	HomePage homeObject;
	UserRegistration registerObject;
	LoginPage loginObject;
	Faker fakeData = new Faker();
	String firstname = fakeData.name().firstName();
	String lastname = fakeData.name().lastName();
	String mail = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();
	
	@Test (priority = 1 )
	public void userRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new UserRegistration(driver);
		registerObject.userRegistration(firstname,lastname,mail,password);
		Assert.assertTrue(registerObject.successMsg.getText().contains("completed"));
		
	}
	@Test (dependsOnMethods= {"userRegisterSuccessfully"})
	public void registeredUserLogoutTest() throws InterruptedException {
		registerObject.userlogout();
		Thread.sleep(1000);
	}
	
	@Test(dependsOnMethods= {"registeredUserLogoutTest"})
	public void registeredUserLoginTest() {
		homeObject.openLoginPage();
	    loginObject = new LoginPage(driver);
		loginObject.userLogin(mail, password);
		Assert.assertTrue(registerObject.logoutBtn.getText().equalsIgnoreCase("log out"));
	}

}
