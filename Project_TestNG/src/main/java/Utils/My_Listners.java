package Utils;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.Commons;

public class My_Listners extends Commons implements ITestListener {
	
	ExtentReports report = Commons.GetExtendReports();
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		log.info("On Executed The Test Case");
		String TestName = result.getName();
		
	    test = report.createTest(TestName);
	    
	    test.log(Status.INFO, TestName+" Excecution Started");
	    
	}
	

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		
		log.info("Test Case Is Successfully Executed");
		String Testname = result.getName();
		
		test.log(Status.INFO, Testname+" got Successfully Executed");
	}
	

	@Override
	public void onTestFailure(ITestResult result) {
		
		log.error(result.getThrowable());
		
		log.info("Test Case Is failed");
		String TestName = result.getName();
		
		test.log(Status.FAIL, TestName+" Test Case is Failed");
		
		test.log(Status.INFO, result.getThrowable());
		
		WebDriver driver = this.driver;
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			
			e.printStackTrace();
		} catch (SecurityException e) {
			
			e.printStackTrace();
		
		}
		try {
			test.addScreenCaptureFromPath(TakeScreenShots(driver), TestName);
			
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		log.debug(result.getInstanceName());
		
		log.info("Test Case Is Skipped");
		
		String Testname = result.getName();
		
		test.log(Status.SKIP, "The Test case Or Skiped" );
		
	}

	
	@Override
	public void onFinish(ITestContext context) {
		
		log.info("Test Case Sccessfully Finished");
		report.flush();
		
	}


}
