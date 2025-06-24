package com.HRM.TCs;

import org.testng.annotations.Test;

import com.Orange.pages.HRM_CommonPage;
import com.Orange.pages.HRM_LoginPage;

import base.Generic;

public class TC_AllTestCases extends Generic {
	
//	WebDriver driver;
	
	@Test
	public void validateAPage() throws Exception {
		Generic.extentLogger= Generic.extentReport.createTest("Validate A Page");
		HRM_LoginPage loginPage = new HRM_LoginPage(driver);
//		HRM_LoginPage loginPage = new HRM_LoginPage(getDriver());
		loginPage.loginOrangeHRMPage("Admin", "admin123");
		HRM_CommonPage commonPage = new HRM_CommonPage(driver);
		commonPage.getUserName();
		commonPage.validateClientImage1();
		commonPage.minimizeTheMenuSection();
		commonPage.searchAPage("Time");
		commonPage.goToTheGivenPage("Time");
	}

}
