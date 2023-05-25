package com.HRM.Testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.seleniumBase;
import pageobjects.adminPage;
import pageobjects.homePage;
import pageobjects.loginPage;
import utils.customlistners;

@Listeners(customlistners.class)
public class AdminPageTests extends seleniumBase{
	
	@Test
	public void searchSystemUsersinAdminMenu() throws Exception{
		homePage hp = new loginPage(driver).login();
		adminPage ap =hp.clickAdminMenu().searchSystemUsers(username);		
		Assert.assertEquals(ap.txtusername.getText(),username);		
     }

}
