package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (name="removefromcart")
	WebElement removeBtn;
	
	@FindBy(name="updatecart")
	WebElement updateWishlistBtn;
	
	@FindBy(css="td.product")
	WebElement productCell;
	
	@FindBy(css="div.no-data")
	public WebElement emptyListHint;
	
	@FindBy (css="h1")
	public WebElement wishListHeader;
	
	public void removeProductFromWishList() {
		clickButton(removeBtn);
		clickButton(updateWishlistBtn);
		
	}

}
