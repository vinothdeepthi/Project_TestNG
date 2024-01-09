package Base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Constents.Constent;
import Page_Class.Cart_Page;
import Page_Class.Product_Page;
import Utils.Utility;

public class Commons extends Constent{
	
	public static org.apache.logging.log4j.Logger log;
	
	@BeforeMethod
	public void Lounch_Application_And_Login() throws IOException {
		
		log = LogManager.getLogger(Commons.class);
		
		log.info("Calling Read Properties Fille To Fatch The Data");
	
        Utility til = new Utility();
       
		til.Read_Properties();
		
		log.info("Lounching The Browser");
		
		switch (Constent.Name) {
		case "chrome":
			
			System.setProperty(Constent.system,Constent.Browser_Path );
			ChromeOptions option = new ChromeOptions();
			driver = new ChromeDriver(option);
			option.addArguments("--disable-notifications");
		    wait = new WebDriverWait(driver, 30);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			log.info("Lounching The Application");
			driver.get(Url);
		
			break;
			
         case "firefox":
			
			System.setProperty(system,Browser_Path );
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
			break;
			
         case "edge":
 			
 			System.setProperty(system,Browser_Path );
 			driver = new FirefoxDriver();
 			driver.manage().window().maximize();
 			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 		
 			break;

		default:
			
			log.info("invalid Browser name ");
		}
		
		
	}
	
	public String TakeScreenShots( WebDriver driver) throws IOException {
		
		log.info("Take The Screen Shot Failed Test Case");
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File des = new File(System.getProperty("user.dir")+"\\Screenshots\\screen.png");
		
		FileUtils.copyFile(source, des);
	
		return des.getAbsolutePath();
	}
	
	
	 public static ExtentReports GetExtendReports()  {
		
		report = new ExtentReports();
		
		File file = new File("C:\\Users\\admin\\eclipse-workspace\\Project_TestNG\\src\\test\\resources\\Report\\report.html");
		
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		
		spark.config().setReportName("this Project Name ");
		
		spark.config().setDocumentTitle("this document Name ");
		
		report.attachReporter(spark);
		
		return report; }
		
		
	 public static void ScrollDownPage() {
		 
		 log.info("Down The Page");
		 
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
		   
	     jse.executeScript("window.scrollBy(0,600)");
	 }
	 
	 @AfterMethod
	    public static void User_Exit() {
	    	
		 log.info("Close The Application");
		 
	    	driver.quit();
	    }
	 
	 public static void SelectProduct(String ProductName) {
		 
		 Product_Page product = new Product_Page(driver);
		 
		 log.info("User Select The Product");
	 		
		    for(WebElement product1 : product.getproduct_Category()) {
		 	
		 	   if(product1.getText().equalsIgnoreCase(ProductName)) { 
		 			
	                wait.until(ExpectedConditions.elementToBeClickable(product1)).click();
		 		   
		 		   break;
		 		}
		 
				
			} 
	 }
	 
	 public static void ValidateCartProduct(String CartProduct) {
		 
		 Cart_Page cart = new Cart_Page(driver);
	 		
	 		for (WebElement carts : cart.getAll_Cart_Product()) {
	 			
	 			if(carts.getText().equalsIgnoreCase(CartProduct)) {
	 				
	 				Assert.assertTrue(true);
	 			}
	 			
	 			else {
	 				Assert.assertTrue(false);
	 			}
	 		}
	 }

	
	

}



