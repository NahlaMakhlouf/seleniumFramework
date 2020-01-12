package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="strong.current-item")
	public WebElement productNamebreadCrumb;
	
	@FindBy(css="input.button-2.email-a-friend-button")
	WebElement emailfriendbtn; 
	
	@FindBy(css="span.price-value-4")
	public WebElement priceLabel; 
	
	@FindBy(linkText="Add your review")
	WebElement addYourReview;
	
	// different product (Samsung Series 9 NP900X4C Premium Ultrabook)
	@FindBy(id="add-to-wishlist-button-6")
	WebElement addToWishList;  
	
	@FindBy(css="input.button-2.add-to-compare-list-button")
	WebElement addToCompareList;
	
	// different product (Samsung Series 9 NP900X4C Premium Ultrabook) 
	@FindBy(id="add-to-cart-button-6")
	WebElement addToCartBtn;
	
	public void openSendEmailPage() {
		clickButton(emailfriendbtn);
	}
	
	public void openAddYourReview() {
		clickButton(addYourReview);
	}
	
	// different product (Samsung Series 9 NP900X4C Premium Ultrabook)
	public void addProductToWishList() {
		clickButton(addToWishList);
			
	}
	
	public void addProductToCompareList() {
		clickButton(addToCompareList);
	}
	
	public void addProductToShoppingCart() {
		clickButton(addToCartBtn);
	}

}
