package utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class customlistners extends Helper implements ITestListener{

	ExtentReports extent=ReportListners.generateExtentReport();
	ExtentTest test;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		test =extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS,"TestCase Passed");
	}

	
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		try {
			extentTest.get().addScreenCaptureFromPath(captureScreenShot(result.getMethod().getMethodName()),result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//captureScreenShot(result.getMethod().getMethodName());
	}
	

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
