package TestComponents;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utilities.ExtentReporting;



public class Listeners extends BaseTest implements ITestListener  {
	
	ExtentTest test;
	ExtentReports extentReports = ExtentReporting.getExtentReports();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	Logger logger = (Logger) LogManager.getLogger();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test = extentReports.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		logger.info(result.getMethod().getMethodName()+" _test started");
	
		 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().getStatus();
		extentTest.get().fail(result.getThrowable());
		logger.info(result.getMethod().getMethodName()+ " has FAILED");
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String screenShotPath = null;
		
		try {
			screenShotPath = getScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentTest.get().addScreenCaptureFromPath(screenShotPath, result.getMethod().getMethodName());
		logger.info(result.getMethod().getMethodName() + "'s SCREENSHOT CAPTURED");
		 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	 
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		 extentReports.flush();
	}

}
