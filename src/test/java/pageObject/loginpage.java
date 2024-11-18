package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage extends BasePage {

	public loginpage(WebDriver driver) {
		super(driver);
	}
		@FindBy(xpath="//input[@name=\"email\"]") WebElement Setemail;
		@FindBy(xpath="//input[@type=\"password\"]") WebElement password;
		@FindBy(xpath="//input[@value=\"Login\"]") WebElement login;
		
		
		//Actions
		
		public void setemail(String email) {
			Setemail.sendKeys(email);	
		}
		 
		public void setpassword(String psd) {
			password.sendKeys(psd);
		}
		public void clicklogin() {
			login.click();
			
		}
		 
		
	}


