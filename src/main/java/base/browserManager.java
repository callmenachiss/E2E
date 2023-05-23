package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.ReadConfig;

public class browserManager{
	public static RemoteWebDriver driver;
	ReadConfig readconfig = new ReadConfig();
	public String Baseurl = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public String browsername = readconfig.getbrowser();
	
	
	public void browsersetup() {
		
		if(browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}else if(browsername.equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
		}else{
			System.err.println("Driver is not defined");
		}

	}

}
