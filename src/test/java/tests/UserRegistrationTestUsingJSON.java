package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistration;

public class UserRegistrationTestUsingJSON extends TestBase{
	HomePage homeObject;
	UserRegistration registerObject;
	LoginPage loginObject;
	
	@Test (priority = 1 )
	public void userRegisterSuccessfully() throws IOException, ParseException {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		JsonReader reader = new JsonReader();
		reader.JsonDataReader();
		
		registerObject = new UserRegistration(driver);
		registerObject.userRegistration(reader.firstname, reader.lastname, reader.mail, reader.password);
		Assert.assertTrue(registerObject.successMsg.getText().contains("completed"));
		registerObject.userlogout();
		
	}
	
}
