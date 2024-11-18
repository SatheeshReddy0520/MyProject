package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageProduct extends BasePage {

		public SearchPageProduct(WebDriver driver) {
		super(driver);
	}

		@FindBy(xpath="//input[@name='search']") 
		WebElement search;
		@FindBy(xpath="//i[@class='fa fa-search']")
		WebElement searchClick;
		
		

		
		
	public void searchproduct(String ser) {
		search.sendKeys(ser);
	}
	public void click() {
		searchClick.click();
		
	
	}		
}
