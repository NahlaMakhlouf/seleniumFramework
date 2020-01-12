package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="AddProductReview_Title")
	WebElement reviewTitle;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement reviewText;
	
	@FindBy(id="addproductrating_4")
	WebElement rating4thBtn;
	
	@FindBy(css="input.button-1.write-product-review-button")
	WebElement submitReviewBtn;
	
	public void AddProductReview(String title, String text) {
		setTextElements(reviewTitle, title);
		setTextElements(reviewText, text);
		clickButton(rating4thBtn);
		clickButton(submitReviewBtn); 
		
	}

}
