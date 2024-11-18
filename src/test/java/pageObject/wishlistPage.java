package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class wishlistPage extends BasePage {

	public wishlistPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//span[text()='Wish List (0)']")
	WebElement wishlistpageclick;
	 
	
	
	
	

	public void clickWishListpage() {
		wishlistpageclick.click();
	}
	
}
