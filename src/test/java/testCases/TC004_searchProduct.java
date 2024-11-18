package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.SearchPageProduct;
import pageObject.addToCartPage;
import pageObject.loginpage;
import testBase.BaseClass;

public class TC004_searchProduct extends BaseClass {
	

	@Test
	public void searchProductandAddToCart() throws Exception {
		try {
		logger.info("TC_004 Started....");
		Homepage hp=new Homepage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		loginpage lgp=new loginpage(driver);
		lgp.setemail(p.getProperty("email"));
		lgp.setpassword(p.getProperty("Password"));
		lgp.clicklogin();
		logger.info("login to the account");
		
		SearchPageProduct srcp=new SearchPageProduct(driver);
		logger.info("Searching Product");
		srcp.searchproduct("imac");
		srcp.click();
			
		WebElement product=driver.findElement(By.xpath("//img[@class=\"img-responsive\"]"));
		
		try {
		if(product.isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail();
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		logger.info("Product Displayed Sucessfully");
		
		driver.findElement(By.xpath("//div[@class=\"caption\"]//a[text()=\"iMac\"]")).click();
		
		addToCartPage acp=new addToCartPage(driver);
		acp.setProductQuantity("2");
		logger.info("product Qunatity Added.....");
		Thread.sleep(2000);
		acp.clickaddt();
		logger.info("Clicked on add to cart...");
		Thread.sleep(2000);
		acp.confirmmsg();
		logger.info("Product Added Sucessfully");
		
		
		}
	finally{
		logger.info("Test Executed Sucessfully");
	
				
	}
}

}

