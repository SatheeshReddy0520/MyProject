package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myaccountpage extends BasePage {

	public myaccountpage(WebDriver driver) {
		super(driver);
	}
     
	 @FindBy(xpath="//h2[text()='My Account']")
	 WebElement verify;
	@FindBy(xpath="//div[@class=\"list-group\"]//a[text()='Logout']") 
	 WebElement logout;   //Added in step no 6
	
	
	 public boolean verifymyaccount() {
		 try {
		return (verify.isDisplayed());		 
		 
	 }
	  catch(Exception e) {
		  return false;
	  }
	
	
	 }
	
	 public void Clicklogout() {
		 logout.click();
		 
	 }
	 
	 
}
