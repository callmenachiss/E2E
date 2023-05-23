package base;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class seleniumBase extends browserManager{
	
	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<>();
	public static WebDriverWait wait;
	
	long timeouts = 10;	

	public static RemoteWebDriver getDriver() {
		return dr.get();
	}
	
	public static void setDriver(RemoteWebDriver driverref) {
		dr.set(driverref);
	}
	
	public static void unload() {
		dr.remove();
	}
	
	
	@BeforeMethod
	public void setup() {
		browsersetup();
		setDriver(driver);
		getDriver().get(Baseurl);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(timeouts));
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
		unload();
	}
	
	public WebElement waitforelement(WebElement ele) {
		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
	    return element;
	}
	
	public void click(WebElement ele) {
		WebElement element = waitforelement(ele);
		element.click();
	}
	
	public void type(WebElement ele,String data) {
		WebElement element = waitforelement(ele);
		element.sendKeys(data);
	}

	
	

	

	



}
