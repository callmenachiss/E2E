package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportListners {

	static ExtentReports extent;
	
	public static ExtentReports generateExtentReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(new File(System.getProperty("user.dir")+
				"/reports/"+"HRM"+Helper.getCurrentDateandTime()+".html"));
		reporter.config().setReportName("Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Nachiyappan Karuppiah");
		return extent;
	}
}
