package utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.seleniumBase;

public class Helper extends seleniumBase{	
	

	
	public static  String getCurrentDateandTime() {
		DateFormat customFormat =new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}	

	public static String captureScreenShot(String TestCaseName){
		TakesScreenshot ts = ((TakesScreenshot)getDriver());
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshots/"+TestCaseName+getCurrentDateandTime()+".png";
		try {
			FileHandler.copy(source, new File(path));
			System.out.println("Screenshot Captured");
		} catch (Exception e) {
			System.out.println("Unable to Capture Screenshot"+e.getMessage());
		}
		return path;
	}

}
