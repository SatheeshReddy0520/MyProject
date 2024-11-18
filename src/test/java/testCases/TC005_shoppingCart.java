package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.SearchPageProduct;
import pageObject.ShoppingCartPage;
import pageObject.addToCartPage;
import pageObject.loginpage;
import testBase.BaseClass;

public class TC005_shoppingCart extends BaseClass {
	
	
	@Test
	public void MyShoppingCart() {
		
		try {
		logger.info("TC_005 Started Sucessfully");
		
		Homepage hp=new Homepage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		logger.info("Clicked on login page");
		
		loginpage lp=new loginpage(driver);
		lp.setemail(p.getProperty("email"));
		lp.setpassword(p.getProperty("Password"));
		lp.clicklogin();
		logger.info("Sucessfully logged in");
		
		Thread.sleep(2000);
		
		SearchPageProduct sp=new SearchPageProduct(driver);
		
		sp.searchproduct("imac");
		sp.click();
		logger.info("Product displayed");
		
	WebElement product=	driver.findElement(By.xpath("//div[@class=\"caption\"]//a[text()=\"iMac\"]"));
	
			if(product.isDisplayed()) {
	            product.click();
				Assert.assertTrue(true);
			}
			else {
				Assert.fail();
			}
		
		addToCartPage acp=new addToCartPage(driver);
		acp.setProductQuantity("2");
		logger.info("Quantity Added Sucessfully");
		acp.clickaddt();
		Thread.sleep(3000);
		acp.confirmmsg();
		logger.info("Product Added To Cart");
		
		Thread.sleep(3000);
		ShoppingCartPage scp=new ShoppingCartPage(driver);
		scp.clickshoppingcart();
	    String price=scp.ProductPrice();
	    System.out.println("Toatal Price of product is "+ price);
         Thread.sleep(2000);

		}
		catch(Exception e) {
		e.printStackTrace();	
		}
	}
}


