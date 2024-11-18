package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class accountregistration extends BasePage {

	public accountregistration(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@name=\"firstname\"]") 
	WebElement fstname;
	
	@FindBy(xpath="//input[@name=\"lastname\"]")
	WebElement lstname;
	
	@FindBy(xpath="//input[@name=\"email\"]")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@name=\"telephone\"]")
	WebElement telephone;
	
	@FindBy(xpath="//input[@name=\"password\"]")	
	WebElement password;
	
	@FindBy(xpath="//input[@name=\"confirm\"]")
	WebElement cfpassword;
	
	@FindBy(xpath="//input[@name=\"agree\"]")
	WebElement agree;
	
	@FindBy(xpath="//input[@value=\"Continue\"]")
	WebElement Continue;
	
	@FindBy(xpath="//h1[normalize-space()=\"Your Account Has Been Created!\"]")
	WebElement created;
	
	//Actions
	
	public void setfirstname(String fname) {
		fstname.sendKeys(fname);
	}
	
	public void setlastname(String Lname) {
		lstname.sendKeys(Lname);
		
	}
	
	public void setemail(String email) {
		txtemail.sendKeys(email);
		
	}
	
	public void settelephone(String tel) {
		telephone.sendKeys(tel);
		
	}
	public void setpassword(String psd)	{
		password.sendKeys(psd);
	}
	public void cnfpassword(String cnfpsd) {
		cfpassword.sendKeys(cnfpsd);
	}
	public void clickagree() {
		agree.click();
	}
	public void clickcontinue() {
		Continue.click();
		
		//or 
//		Actions act=new Actions(driver);
//		act.moveToElement(Continue).click().perform();
		
	}
	
	
	public String cnfmessage() {
		try {
		return (created.getText());
		}	
		catch (Exception e) {			
		return(e.getMessage());
		
		
	}
	
		
	}
}


