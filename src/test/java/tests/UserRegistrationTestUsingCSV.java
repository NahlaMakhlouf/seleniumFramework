package tests;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistration;

public class UserRegistrationTestUsingCSV extends TestBase{
	HomePage homeObject;
	UserRegistration registerObject;
	LoginPage loginObject;
	
	CSVReader reader;
	
	@Test (priority = 1 )
	public void userRegisterSuccessfully() throws   InterruptedException, CsvValidationException, IOException {
		
		String CSV_file =System.getProperty("user.dir")+"/src/test/java/data/UserData.csv";
		try {
			reader = new CSVReader(new FileReader(CSV_file));
			System.out.println("Deenaaaaaaaaaaaaaaaaaaa");
			System.out.println(reader);
			System.out.println(reader.readNext());
		} catch (FileNotFoundException e) {
			System.out.println("cant read data"+e.getMessage());
			
		}
	
		String[] csvcell = {};
		try {
			while ((csvcell = reader.readNext()) != null) {
				System.out.println(csvcell);
				String firstname = csvcell[0];
				Thread.sleep(1000);
				String lastname = csvcell[1];	
				Thread.sleep(1000);
				String email = csvcell[2];
				Thread.sleep(1000);
				String password = csvcell[3];
				Thread.sleep(1000);
				
				
			homeObject = new HomePage(driver);
			homeObject.openRegistrationPage();
			
			registerObject = new UserRegistration(driver);
			registerObject.userRegistration(firstname, lastname, email, password);
			Assert.assertTrue(registerObject.successMsg.getText().contains("completed"));
			registerObject.userlogout();
			Thread.sleep(2000);
			}
		} catch (IOException e) {
			System.out.println("cant loop "+e.getMessage());
		}
		
	}
	
	

}
