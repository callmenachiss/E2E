package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.seleniumBase;
import utils.customlistners;

public class forgotPasswordPage extends seleniumBase{
	
	public forgotPasswordPage(RemoteWebDriver driver) {
		this.driver = getDriver();
		PageFactory.initElements(getDriver(),this);
	}
	
	@FindBy(xpath="//p[text()='Forgot your password? ']")
	WebElement forgotyourpasswordlnktxt;
	
	
	public resetPasswordPage clickforgotpwdlnktxt(){
		click(forgotyourpasswordlnktxt);
		customlistners.extentTest.get().pass("User is clicked on forgot your password link");
		return new resetPasswordPage();
	}

}
