package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.loginpage;
import pageObject.myaccountpage;
import testBase.BaseClass;
import utilities.Dataproviders;

public class TC003_LoginDDT extends BaseClass {
	
	
	@Test(dataProvider="logindata",dataProviderClass=Dataproviders.class,groups="DataDriven")     //getting data from diffrent class
	public void Verify_LoginDDT(String email,String psd,String exp) {
		logger.info("*** Started TestCase TC003_LoginDD ***");
		
		try {
		Homepage hp=new Homepage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		loginpage lp=new loginpage(driver);
		lp.setemail(email);
		lp.setpassword(psd);
		lp.clicklogin();
		
		myaccountpage acc=new myaccountpage(driver);
	   boolean targetpage=acc.verifymyaccount();
	   
	   /* Data ia valid ----login success --test pass--logout
	                     ----login failed ---test fail
	                     
	     Data is Invalid ---login sucess--test fail--logout
	                     ----login failed---test pass                
	    */
	   
	   
	   if(exp.equalsIgnoreCase("Valid")) {
		   acc.Clicklogout();
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   Assert.assertTrue(false);
	   }
	   
	   if(exp.equalsIgnoreCase("Invalid"))
	   {
		   acc.Clicklogout();
		   Assert.assertTrue(false);	   
	   }
	   else
	   {
		   Assert.assertTrue(true);
	   }
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	   logger.info("***Finished Test case****");
	}	   
	
}


