package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="removefromcart")
	WebElement removeFromCartBtn;
	
	@FindBy(name="updatecart")
	WebElement updateCartBtn;
	
	@FindBy(id="itemquantity67886")
	WebElement productQty;
	
	@FindBy(css="td.subtotal")
	WebElement totalPrice;
	
	@FindBy(css="div.no-data")
	public WebElement emptyCartHint;
	
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	
	@FindBy(id="termsofservice")
	WebElement agreementCheckbox;
	
	@FindBy(css="input.button-1.checkout-as-guest-button")
	WebElement guestBtn;
	
	public void RemoveProductFromCart() {
		clickButton(removeFromCartBtn);
		clickButton(updateCartBtn);
	}
	
	public void UpdateProductQtyInCart(String qty) throws InterruptedException {
		clearTextBox(productQty);
		setTextElements(productQty, qty);
		clickButton(updateCartBtn);
		
	}
	
	public void OpenCheckoutPage() {
		clickButton(agreementCheckbox);
		clickButton(checkoutBtn);
	}
	
	public void OpenCheckoutPageAsGuest() {
		clickButton(agreementCheckbox);
		clickButton(checkoutBtn);
		clickButton(guestBtn);
	}

}
