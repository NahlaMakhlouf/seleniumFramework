package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistration;

public class UserRegistrationTestUsingExcel extends TestBase{
	HomePage homeObject;
	UserRegistration registerObject;
	LoginPage loginObject;
	
	@DataProvider(name="testdata")
	public static Object[][] userRegistrationData() throws IOException{
		ExcelReader ER = new ExcelReader();
			return ER.getExcelData();
		}
	
	@Test (priority = 1, alwaysRun= true,dataProvider="testdata")
	public void userRegisterSuccessfully(String fname , String lname , String mail , String password) throws InterruptedException {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new UserRegistration(driver);
		registerObject.userRegistration(fname, lname, mail, password);
		Assert.assertTrue(registerObject.successMsg.getText().contains("completed"));
		registerObject.userlogout();
		Thread.sleep(2000);
		//homeObject.openLoginPage();
	   // loginObject = new LoginPage(driver);
		//loginObject.userLogin(mail,password);
		//Assert.assertTrue(registerObject.logoutBtn.getText().equalsIgnoreCase("log out"));
		//registerObject.userlogout();
		
	}
	
}
