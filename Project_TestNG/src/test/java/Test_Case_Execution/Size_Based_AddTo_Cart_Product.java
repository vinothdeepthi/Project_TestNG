package Test_Case_Execution;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Commons;
import Page_Class.Cart_Page;
import Page_Class.DashBoard_Page;
import Page_Class.Product_Page;

public class Size_Based_AddTo_Cart_Product extends Commons {
	
	@Test
	public void FiterSize_AddToCart() throws Exception {
		
        log.info("Create An Object All Page To Finding The WebElement");
		
		Product_Page product = new Product_Page(driver);
		
		DashBoard_Page dash = new DashBoard_Page(driver);
		
		Cart_Page cart = new Cart_Page(driver);
		
		log.info("Craete Object LoginFuction");
		
		Verify_Login_Functionality login = new Verify_Login_Functionality();
		
		log.info("User login the Application");
		
		login.Login_Function();
		
		log.info("Select The Product Category");
		
		 for(WebElement category : dash.getBaby_Category()) {
	 			
	 			if(category.getText().equalsIgnoreCase(secondcategory)) {
	 				
	 				category.click();
	 				break;
	 			}
		 }
		 
		 log.info("User Click On The Filter Button");
		 
		 product.getFilter_Button().click();
		 
		 log.info("User Select The Filter Options");
		 
		 for(WebElement filter : product.getFilter_Product()) {
			 
			 if(filter.getText().equalsIgnoreCase(FilterOption)) {
				 
				 filter.click();
				 break;
			 }
		 }
		 
		 Thread.sleep(2000);
		 
		 log.info("User Select The Product ");
			
		  SelectProduct(Nightsuite);
		  
		  ScrollDownPage();
		   
		   log.info("User Select The Product Size Which is Available");
		    
		    for (WebElement size : product.getProduct_Size()) {
		    	
		    	switch (size.getText()) {
				case "0-3M":
					
					Assert.assertTrue(size.isEnabled());
					size.click();
					break;
					
				case "3-6M":
				
				Assert.assertTrue(size.isEnabled());
				size.click();
				
				break;
				
				case "2-3Y":
					
					Assert.assertTrue(size.isEnabled());
					size.click();
					break;
					
                   case "9-12M":
					
					Assert.assertTrue(size.isEnabled());
					size.click();
					break;
					
                   case "18-24M":
   					
   					Assert.assertTrue(size.isEnabled());
   					size.click();
   					break;
				
				default:
					
					log.info("Product Size Not Avaliable "+size.getText());
					break;
				}
				
			}
		    
		    log.info("User Click n The AddTo Cart Button");
		    
		    wait.until(ExpectedConditions.elementToBeClickable(product.getAddToCart_Button())).click();
		    
		    log.info("User Click On The Cart View Button");
		    
		    product.getView_Cart_Button().click();
		    
		    log.info("Validate The Correct Product Add To The Cart Page");
		    
		    ValidateCartProduct(Nightsuite);
		 		
		 	}
			
		 }
	


