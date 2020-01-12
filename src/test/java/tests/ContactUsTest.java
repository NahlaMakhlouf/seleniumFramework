package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
	
	HomePage homeObject;
	ContactUsPage contactusObject;
	
	@Test
	public void UseContactUs() {
		homeObject = new HomePage(driver);
		contactusObject = new ContactUsPage(driver);
		
		homeObject.openContactUsPage();
		contactusObject.ContactUs("Nahla", "nahla@test.com", "test message ");
		
		Assert.assertTrue(contactusObject.successMsg.getText().contains("Your enquiry has been successfully sent "));
	}

}
