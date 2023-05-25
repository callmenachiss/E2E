package com.HRM.Testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.seleniumBase;
import pageobjects.loginPage;
import pageobjects.resetPasswordPage;
import utils.customlistners;

@Listeners(customlistners.class)
public class LoginPageTests extends seleniumBase{
	
	
	@Test
	public void verifyLoginFeature(){
		loginPage lp=new loginPage(driver);
		Assert.assertEquals(lp.usernamelbl.getText(),"Username");		
		Assert.assertEquals(lp.passwordlbl.getText(),"Password");
		lp.enterUsername(username).enterPassword(password).clickLoginbtn();	
    }
	
	@Test
	public void verifyForgotPasswordlnkFeature(){
		resetPasswordPage rp= new loginPage(driver).clickforgotpwdlnktxt();	    
	    rp.resetPassword(username);
	    Assert.assertEquals(rp.resetPwdMsglbl.getText(),"Reset Password link sent successfully");
     }

	
}
