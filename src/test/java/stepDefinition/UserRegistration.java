package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import tests.TestBase;

public class UserRegistration extends TestBase  {
	
	HomePage homeObj;
	pages.UserRegistration registerObj;
	
	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
		homeObj = new HomePage(driver);
		homeObj.openRegistrationPage();
		
	   
	}

	@When("click on registration link")
	public void click_on_registration_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
		
	   
	}

	/*@When("enter registration data")
	public void enter_registration_data() {
	   registerObj = new pages.UserRegistration(driver);
	   registerObj.userRegistration("Nahla", "test", "testttt@yahoo.com", "123456");
	}*/
	
	@When("enter {string},{string},{string},{string}")
	public void enter(String firstname, String lastname, String email, String password) throws InterruptedException {
		registerObj = new pages.UserRegistration(driver);
		   registerObj.userRegistration(firstname, lastname, email, password);
		   Thread.sleep(2000);
	    
	}

	@Then("user register successfully")
	public void user_register_successfully() throws InterruptedException {
		registerObj.userlogout();
		Thread.sleep(1000);
	   
	}



}
