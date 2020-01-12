package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{

	public EmailPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="FriendEmail")
	WebElement f_mail;
	
	@FindBy(id="PersonalMessage")
	WebElement msg;
	
	@FindBy(name="send-email")
	WebElement sendBtn;
	
	@FindBy(css="div.result")
	public WebElement sucessMsg;
	
	public void SendEmailToFriend(String FriendMail, String PersonalMsg) {
		setTextElements(f_mail, FriendMail);
		setTextElements(msg, PersonalMsg);
		clickButton(sendBtn);
		
	}

}
