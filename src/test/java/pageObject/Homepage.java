package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Homepage extends BasePage {

	public Homepage(WebDriver driver) {
		super(driver);
	}
//Locators
		@FindBy(xpath="//span[normalize-space()=\"My Account\"]") WebElement myaccount;
		
		@FindBy(xpath="//*[text()=\"Register\"]") WebElement register;
		
		@FindBy(xpath="//*[text()='Login']") WebElement login;
	
	//Actions

         public void clickmyaccount() {
	      myaccount.click();
            }
        public void clickregister() {
        register.click();
        }
        
       public void clicklogin() {
    	   login.click();
       }
        
        
        
        
        
}
