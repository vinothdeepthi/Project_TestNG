package Test_Case_Execution;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import Base.Commons;
import Page_Class.Cart_Page;
import Page_Class.DashBoard_Page;
import Page_Class.Product_Page;

public class Add_To_Cart_Dashboard_Category_Product extends Commons {
		
	@Test
	public void AddToCart_Category_Product() throws Exception {
		
		log.info("Create An Object All Page To Finding The WebElement");
		
		Product_Page product = new Product_Page(driver);
		
		DashBoard_Page dash = new DashBoard_Page(driver);
		
		Cart_Page cart = new Cart_Page(driver);
		
		
		log.info("Craete Object LoginFuction");
		
		Verify_Login_Functionality login = new Verify_Login_Functionality();
		
		log.info("login the Application");
		
		login.Login_Function();
		
		log.info("down The Page");
		
		ScrollDownPage();
	     
	    log.info("Select The Product Category");
	    for(WebElement category : dash.getBaby_Category()) {
	 			
	 		if(category.getText().equalsIgnoreCase(Category)) {
	 				
	 			category.click();
	 			break;
	 		}}
	 		
	 	log.info("User Select The Product");
	 		
	    SelectProduct(Product_Name);
	    
	    log.info("Down The Page");
	    
	    ScrollDownPage();
		
	    log.info("Select The Quantity");
	    
        product.getQuantity().sendKeys("2");
        
        ScrollDownPage();
   
       log.info("User Click On the AddToCart Button");
   
       wait.until(ExpectedConditions.elementToBeClickable(product.getAddToCart_Button())).click();
   
      log.info("User Click On The View Cart Button" );
   
      product.getView_Cart_Button().click();
		
	  log.info("Validate The Correct Product Add To The Cart Page");
		
	  ValidateCartProduct(Product_Name);
		
	}

}
