package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);	
	}
	@FindBy (id="FullName")
	WebElement fullName;
	
	@FindBy (id="Email")
	WebElement email;
	
	@FindBy (id="Enquiry")
	WebElement enquiry;
	
	@FindBy (css="input.button-1.contact-us-button")
	WebElement submitBtn;
	
	@FindBy (css="div.result")
	public WebElement successMsg;
	
	public void ContactUs(String name, String mail, String enquiryMsg) {
		
		setTextElements(fullName, name);
		setTextElements(email, mail);
		setTextElements(enquiry, enquiryMsg);
		clickButton(submitBtn);
		
	}
	
	
	

}
