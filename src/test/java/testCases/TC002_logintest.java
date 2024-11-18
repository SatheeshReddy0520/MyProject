package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.loginpage;
import pageObject.myaccountpage;
import testBase.BaseClass;

public class TC002_logintest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		
		try {
			
		logger.info("*** Started TestCase TC002 ***");
		Homepage hp=new Homepage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		loginpage lp=new loginpage(driver);
		lp.setemail(p.getProperty("email"));
		lp.setpassword(p.getProperty("Password"));
		lp.clicklogin();
		
		myaccountpage acc=new myaccountpage(driver);
	   boolean targetpage=acc.verifymyaccount();
	    
	// Assert.assertEquals(targetpage, true);
	   Assert.assertTrue(targetpage);
		}
		catch(Exception e) {
			Assert.fail();
		}
	   
	   logger.info("*** Finished TestCase ***");
		
	
		
	}

}
