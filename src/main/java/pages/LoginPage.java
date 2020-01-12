package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);	
	}
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(css="input.button-1.login-button")
	WebElement loginBtn;
	
	public void userLogin(String Email, String Password) {
		setTextElements(email, Email);
		setTextElements(password, Password); 
		clickButton(loginBtn);
	}
	
}
