package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class addToCartPage extends BasePage  {

	public addToCartPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@name=\"quantity\"]")
	WebElement productquantity;
	
	@FindBy(xpath="//button[@id=\"button-cart\"]")
	WebElement addtocart;
	
	@FindBy(xpath="//*[text()='Success: You have added ']")
	WebElement cnfmsg;
	
	
	
	public void setProductQuantity(String qty) {
		productquantity.clear();
		productquantity.sendKeys(qty);
	}
	public void clickaddt() {
		addtocart.click();
	}
	
	public boolean confirmmsg() {
		if(cnfmsg.isDisplayed()) {
		return true;
		}
		else
	   return false;
		
	}
		
	}
	

