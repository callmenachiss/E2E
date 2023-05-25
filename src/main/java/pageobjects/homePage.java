package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.seleniumBase;
import utils.customlistners;

public class homePage extends seleniumBase{
	
	public homePage(RemoteWebDriver driver) {
		this.driver = getDriver();
		PageFactory.initElements(getDriver(),this);	
	}
	
	@FindBy(xpath="//span[text()='Admin']")
	WebElement adminMenu;
	
	
	public adminPage clickAdminMenu(){
		click(adminMenu);
		customlistners.extentTest.get().pass("User is navigate into admin menu");
		return new adminPage(driver);
	}
	
	
	

}
