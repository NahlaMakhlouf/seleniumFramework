package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText="Change password")
	WebElement changePassword;
	@FindBy(id="OldPassword")
	WebElement oldPassword;
	@FindBy(id="NewPassword")
	WebElement newPassword;
	@FindBy(id="ConfirmNewPassword")
	WebElement confirmPassword;
	@FindBy(css="input.button-1.change-password-button")
	WebElement changePasswordBtn;
	@FindBy(css="div.result")
	public WebElement resultLabel;
	
	
	public void openChangePassword()
	{
		clickButton(changePassword);
	}
	
	public void userChangePassword(String OldPassword, String NewPassword) {
		setTextElements(oldPassword, OldPassword);
		setTextElements(newPassword, NewPassword);
		setTextElements(confirmPassword, NewPassword);
		clickButton(changePasswordBtn);
	}
	

}
