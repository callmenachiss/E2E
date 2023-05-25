package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.seleniumBase;
import utils.customlistners;

public class resetPasswordPage extends seleniumBase {
	
	public resetPasswordPage(RemoteWebDriver driver) {
		this.driver = getDriver();
		PageFactory.initElements(getDriver(),this);
	}	
	
	
	@FindBy(name="username")
	WebElement usernametxt;
	
	@FindBy(tagName="h6")
	public WebElement resetPwdMsglbl;
	
	@FindBy(xpath="//button[text()=' Reset Password ']")
	WebElement resetpwdbtn;
	
	public void resetPassword(String uname) {
		type(usernametxt,uname);
		customlistners.extentTest.get().pass("User is entered the username to reset the password");
		click(resetpwdbtn);
	}
}
