package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.accountregistration;
import testBase.BaseClass;

public class TC001_registrationAccount extends BaseClass {
	
	
	@Test(groups= {"Regression","Master"})
	public void registration() {
		try {
		logger.info("..Started TC001_registrationAccount..");
		Homepage hp=new Homepage(driver);
		hp.clickmyaccount();
		logger.info("Clicked on my account link");
		hp.clickregister();
		logger.info("Clicked on register link");
		
		accountregistration regpage=new accountregistration(driver);
		
		logger.info("started customer deatils");
//		regpage.setfirstname("satheesh");
		regpage.setfirstname(randomstring().toUpperCase());
		
//		regpage.setlastname("reddy");
		regpage.setlastname(randomstring().toUpperCase());
		
//		regpage.setemail("satheeshtesting123@gmail.com");
		regpage.setemail(randomstring()+"@gmail.com");
//		regpage.settelephone("9911223344");
		regpage.settelephone(randomnumber());
		
		String password=randomAlphaNumeric();
		
//		regpage.setpassword("qwerty");
		regpage.setpassword(password);
//		regpage.cnfpassword("qwerty");
		regpage.cnfpassword(password);     
		regpage.clickagree();
		regpage.clickcontinue();
		String cnfmsg=regpage.cnfmessage();
		
		if(cnfmsg.equals("Your Account Has Been Created!")) //give invalid confirmation message
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed");
	    //	logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		
		logger.info("confirmation message passed");
		
	}	
		catch(Exception e) {
			
			Assert.fail();
		}
	logger.info("finished TC001_registrationAccount");
	
}
}