package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="small-searchterms")
	WebElement searchBar;
	@FindBy(css="input.button-1.search-box-button")
	WebElement searchBtn;
	@FindBy(id="ui-id-1")
	List<WebElement> productList;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement productTitle;
	
	public void ProductSearch(String productName)
	{
		setTextElements(searchBar, productName);
		clickButton(searchBtn); 
	}
	
	public void OpenProductDetails() 
	{
		clickButton(productTitle);
	}
	
	public void ProductSearchUsingAutosuggest(String product_Name)
	{
		setTextElements(searchBar, product_Name);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		productList.get(0).click();
	}

}
