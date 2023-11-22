package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporting {
	
	public static ExtentReports getExtentReports()
	{
		String extentReportPath =  System.getProperty("user.dir") + "/ExtentReports/index.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportPath);
		
		sparkReporter.config().setDocumentTitle("Standard Store Reporting");
		sparkReporter.config().setReportName("Test Report");
		
		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		
		return extentReport;
	}

}
