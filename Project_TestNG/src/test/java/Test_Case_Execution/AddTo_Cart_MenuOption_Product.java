package Test_Case_Execution;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import Base.Commons;
import Page_Class.Cart_Page;
import Page_Class.DashBoard_Page;
import Page_Class.Product_Page;

public class AddTo_Cart_MenuOption_Product extends Commons {
	
	@Test
	public void Menu_Product() throws Exception {
		
        log.info("Create An Object All Page To Finding The WebElement");
		
		Product_Page product = new Product_Page(driver);
		
		DashBoard_Page dash = new DashBoard_Page(driver);
		
		Cart_Page cart = new Cart_Page(driver);
		
		 log.info("Craete Object LoginFuction");
		 
		Verify_Login_Functionality logins = new Verify_Login_Functionality();
		
		log.info("login the Application");
		
		logins.Login_Function();
		
		log.info("User Click On The Menu Button");
		
		dash.getMenu_Button().click();
		
		log.info("User Select The Menu Options");
		
		for (WebElement options : dash.getMenu_Options()) {
			
			if(options.getText().equalsIgnoreCase(Menuoption)) {
				
				options.click();
				break;
			}
			
		}
		
		log.info("User The The Product Category");
		
		for(WebElement winter : dash.getWinter_products()) {
			
			if(winter.getText().equalsIgnoreCase(Winterproduct)) {
				winter.click();
				break;
			}}
			
		log.info("User Select The Product");
		
		SelectProduct(Sweatshirt);
		
		ScrollDownPage();
		
		log.info("User Click On the AddToCart Button");
		
		wait.until(ExpectedConditions.elementToBeClickable(product.getAddToCart_Button())).click();
		
		log.info("User Click On The View Cart Button" );
		
		product.getView_Cart_Button().click();
		
		log.info("Validate The Correct Product Add To The Cart Page");
		
		ValidateCartProduct(Sweatshirt);
		
	}

}
