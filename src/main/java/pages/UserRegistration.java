package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistration extends PageBase{

	public UserRegistration(WebDriver driver) {
		super(driver);	
	}
  @FindBy(id="gender-male")
  WebElement gender;
  
  @FindBy(id="FirstName")
  WebElement firstName;
  
  @FindBy (id="LastName")
  WebElement lastName;
  
  @FindBy(id="Email")
  WebElement Email;
  
  @FindBy(id="Password")
  WebElement Password;
  
  @FindBy(id="ConfirmPassword")
  WebElement Confirm;
  
  @FindBy(id="register-button")
  WebElement registerBtn;
  
  @FindBy(css="div.result")
  public WebElement successMsg;
  
  @FindBy(linkText="Log out")
  public WebElement logoutBtn;
  
  @FindBy(linkText="My account")
  WebElement myAccount;
  
  public void userRegistration(String firstname , String lastname, String email, String password) {
	  clickButton(gender);
	  setTextElements(firstName, firstname);
	  setTextElements(lastName, lastname);
	  setTextElements(Email, email);
	  setTextElements(Password, password);
	  setTextElements(Confirm, password);
	  clickButton(registerBtn);  
  }
  public void userlogout() {
	  clickButton(logoutBtn);
  }
  
  public void openMyAccount() {
	  clickButton(myAccount);
  }
}
