package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="BillingNewAddress_FirstName")
	WebElement firstName;
	
	@FindBy(id="BillingNewAddress_LastName")
	WebElement lastName;
	
	@FindBy(id="BillingNewAddress_Email")
	WebElement email;
	
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countryList;
	
	@FindBy(id="BillingNewAddress_City")
	WebElement city;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement address;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement postalCode;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneNumber;
	
	@FindBy(css="input.button-1.new-address-next-step-button")
	WebElement continueBtn;
	
	@FindBy(id="shippingoption_1")
	WebElement shippingMethodRdoBtn;
	
	@FindBy(css="input.button-1.shipping-method-next-step-button")
	WebElement shippingContinueBtn;
	
	@FindBy(css="input.button-1.payment-method-next-step-button")
	WebElement paymentMethodContinueBtn;
	
	@FindBy(css="input.button-1.payment-info-next-step-button")
	WebElement paymentInfoContinueBtn;
	
	@FindBy(css="input.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;
	
	@FindBy(css="div.title")
	public WebElement successMsg;
	
	@FindBy(linkText="Click here for order details.")
	WebElement orderDetailsLink;
	
	public void RegisteredUserCheckout(String Country, String City, String Address, String PostalCode, String Phone) throws InterruptedException {
		
	select = new Select(countryList);
	select.selectByVisibleText(Country);
	setTextElements(city, City);
	setTextElements(address, Address);
	setTextElements(postalCode, PostalCode);
	setTextElements(phoneNumber, Phone);
	clickButton(continueBtn);
	Thread.sleep(1000);
	
	clickButton(shippingMethodRdoBtn);
	clickButton(shippingContinueBtn);
	Thread.sleep(3000);
	
	clickButton(paymentMethodContinueBtn);
	Thread.sleep(3000);
	
	clickButton(paymentInfoContinueBtn);
	Thread.sleep(3000);
	
	clickButton(confirmBtn);
	
	}
	

	public void GuestCheckout(String Fname,String Lname,String Mail,String Country, String City, String Address, String PostalCode, String Phone) throws InterruptedException {
		
	setTextElements(firstName, Fname);
	setTextElements(lastName, Lname);
	setTextElements(email, Mail);
	select = new Select(countryList);
	select.selectByVisibleText(Country);
	setTextElements(city, City);
	setTextElements(address, Address);
	setTextElements(postalCode, PostalCode);
	setTextElements(phoneNumber, Phone);
	clickButton(continueBtn);
	Thread.sleep(1000);
	
	clickButton(shippingMethodRdoBtn);
	clickButton(shippingContinueBtn);
	Thread.sleep(3000);
	
	clickButton(paymentMethodContinueBtn);
	Thread.sleep(3000);
	
	clickButton(paymentInfoContinueBtn);
	Thread.sleep(3000);
	
	clickButton(confirmBtn);
	
	}
	
	
	public void OpenOrderDetails() {
		clickButton(orderDetailsLink);
	}
	
	
	
	
	

}
