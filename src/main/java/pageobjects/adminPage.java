package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.seleniumBase;
import utils.customlistners;

public class adminPage extends seleniumBase{
	
	public adminPage(RemoteWebDriver driver) {
		this.driver = getDriver();
		PageFactory.initElements(getDriver(),this);	
	}
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement searchBtn;
	
	@FindBy(xpath="//h6[text()='Admin']")
	public WebElement admintxtlbl;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement employeenamebox;
	
	@FindBy(xpath="(//label[text()='Username']/following::input)[1]")
	WebElement usernamebox;	
	
	@FindBy(xpath="(//div[text()='Admin'])[1]")
	public WebElement txtusername;
	
	public adminPage searchSystemUsers(String uname) throws InterruptedException{
		type(usernamebox,uname);
		type(employeenamebox,uname);
		click(searchBtn);
		customlistners.extentTest.get().pass("User is entered the username in username box to search the active system users");
		return this;
	}

}
