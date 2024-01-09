package Test_Case_Execution;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Commons;
import Page_Class.Login_Page;

public class Verify_Login_Functionality extends Commons {

	@Test
	 static void Login_Function() throws Exception {
		
		log.info("Craete An Object on loginPage To Finding The Element");
		
		Login_Page logins = new Login_Page(driver);
			
	        log.info("User Click On The Account Logo");
	        
			logins.getProfile_Logo().click();
			
			log.info("User Entering The UserName");
			
			logins.getUserName().sendKeys(UserName);
			
			log.info("User Entering The Password");
			
			logins.getPassword().sendKeys(Password);
			
			log.info("User Click The Login Button");
			
			logins.getLogin_Button().click();
			
			log.info("User Get The Account User Name");
			
			String Account_Detaties = logins.getAccount_Detiles().getText();
			
			log.info("Validate The Correct User As Been Logged Or Not" );
			
			Assert.assertEquals(Account_Detaties,AccountName);
		
			log.info("User Click On The Home Button");
			
		    logins.getHome_Button().click();
	
	}
}
