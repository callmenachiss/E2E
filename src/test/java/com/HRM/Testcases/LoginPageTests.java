package com.HRM.Testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.seleniumBase;
import pageobjects.forgotPasswordPage;
import pageobjects.loginPage;
import utils.customlistners;


public class LoginPageTests extends seleniumBase{
	

	@Test
	public void verifyLoginFeature(){		
				
		loginPage lp=new loginPage(driver);
		
		lp.enterUsername(username).enterPassword(password);		
		Assert.assertEquals(lp.usernamelbl.getText(),"Username");
		
		Assert.assertEquals(lp.passwordlbl.getText(),"Password");		
		lp.clickLoginbtn();	
     }
	
	@Test
	public void verifyForgotPasswordlnkFeature(){			
	    new forgotPasswordPage(driver).clickforgotpwdlnktxt();	
     }

	
}
