package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareListPage extends PageBase{

	public CompareListPage(WebDriver driver) {
		super(driver);
	}
	 @FindBy(css="a.clear-list")
	 WebElement clearListBtn;
	 
	 @FindBy(css="table.compare-products-table")
	 WebElement compareTable;
	 
	 @FindBy(tagName="tr")
	 public List<WebElement> allRows;
	 
	 @FindBy(tagName="td")
	 public List<WebElement> allCols;
	 
	 @FindBy(css="div.no-data")
	 public WebElement nodataHint;
	 
	 public void clearCompareList() {
		 clickButton(clearListBtn);
	 }
	 
	 public void compareProducts() {
		 for (WebElement row :allRows) {
			 System.out.println(row.getText() + "\t");
			 for(WebElement col:allCols) {
				 System.out.println(col.getText() + "\t");
			 }
		 }
	 }

}
