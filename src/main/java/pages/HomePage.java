
package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	 public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	 }
		@FindBy(linkText="Register")
		WebElement registerbtn; 
		
		@FindBy(linkText="Log in")
		WebElement loginbtn;
		
		@FindBy(linkText="Contact us")
		WebElement contactUs;
		
		@FindBy(id="customerCurrency")
		WebElement currencyDDL;
		
		@FindBy(linkText="Computers")
		WebElement computersMenu;
		
		@FindBy(linkText="Notebooks")
		WebElement notebooksMenu;
		
	public void openRegistrationPage() {
		clickButton(registerbtn);
	}
	
	public void openLoginPage() {
		clickButton(loginbtn);
	}
	
	public void openContactUsPage() {
		scrollToButtom();
		clickButton(contactUs);	
	}
	
	public void changeCurrency() {
		select = new Select(currencyDDL);
		select.selectByVisibleText("Euro");
		
	}
	
	public void selectNotebooksMenu() {
		action.moveToElement(computersMenu).moveToElement(notebooksMenu).click().build().perform();
		
	}

}