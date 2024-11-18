package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//span[text()='Shopping Cart']")
	WebElement clickshoppingcart;
	
	@FindBy(xpath="//tbody//tr//td[6]")
	WebElement productprice;
	
/*	@FindBy(xpath="//div//form//table[@class=\"table table-bordered\"]")
	List<WebElement> productdetails;
	
   @FindBy(xpath="//div//div//div[@class=\"row\"]//table[@class=\"table table-bordered\"]")
   List<WebElement> totalprice;
                                          */

    public void clickshoppingcart() {
    	clickshoppingcart.click();
	
    }
    public String ProductPrice() {
    	return productprice.getText();
    }
 
    
}