package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.seleniumBase;
import utils.customlistners;

public class loginPage extends seleniumBase{
	
	public loginPage(RemoteWebDriver driver) {
		this.driver = getDriver();
		PageFactory.initElements(getDriver(),this);
		
		
	}
	
	@FindBy(name="username")
	WebElement usernametxt;
	
	@FindBy(xpath="//label[text()='Username']")
	public WebElement usernamelbl;
	
	@FindBy(name="password")
	WebElement passwordtxt;
	
	@FindBy(xpath="//label[text()='Password']")
	public WebElement passwordlbl;
	
	@FindBy(tagName ="button")
	WebElement loginbtn;
	
	@FindBy(xpath="//p[text()='Forgot your password? ']")
	WebElement forgotyourpasswordlnktxt;
	
	public loginPage enterUsername(String uname){
		type(usernametxt,uname);
		customlistners.extentTest.get().pass("User is entered the username in username field");
		return this;
	}
	
	public loginPage enterPassword(String pwd){
		type(passwordtxt,pwd);
		customlistners.extentTest.get().pass("User is entered the password in password field");
		return this;
	}
	
	public homePage clickLoginbtn(){
		click(loginbtn);
		customlistners.extentTest.get().pass("User is clicked on the login button");
		customlistners.extentTest.get().pass("User is landing in Homepage");
		return new homePage(driver);
	}
	
	public homePage login() {
		 enterUsername(username)
		.enterPassword(password)
		.clickLoginbtn();
		 return new homePage(driver);
	}
	
	public resetPasswordPage clickforgotpwdlnktxt(){
		click(forgotyourpasswordlnktxt);
		customlistners.extentTest.get().pass("User is clicked on forgot your password link");
		return new resetPasswordPage(driver);
	}

}
