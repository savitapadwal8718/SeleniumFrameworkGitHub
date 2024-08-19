package seleniumframework.testObjects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentObject {

	public static ExtentReports getExtentReporter()
	{

		String path = System.getProperty("user.dir") + "\\reports\\indexreprort.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Apeksha Test");
		reporter.config().setReportName("First Report Test");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Savita PAdwal");
		return extent;
		
		
		
	}
	
	
	
	
	
}
