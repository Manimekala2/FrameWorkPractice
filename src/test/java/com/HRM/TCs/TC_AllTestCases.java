package com.HRM.TCs;

import org.testng.annotations.Test;

import base.Generic;
import com.Orange.pages.HRM_CommonPage;
import com.Orange.pages.HRM_LoginPage;
import com.Orange.pages.HRM_PIPPage;

public class TC_AllTestCases extends Generic {
	
	@Test (enabled = false)
	public void validateAPage() throws Exception {
		HRM_LoginPage loginPage = new HRM_LoginPage(driver);
		loginPage.loginOrangeHRMPage("Admin", "admin123");
		HRM_CommonPage commonPage = new HRM_CommonPage(driver);
		commonPage.getUserName();
		commonPage.validateClientImage1();
		commonPage.minimizeTheMenuSection();
		commonPage.searchAPage("Time");
		commonPage.goToTheGivenPage("Time");
	}
	
	@Test
	public void addANewEmployee()throws Exception{
		HRM_LoginPage loginPage = new HRM_LoginPage(driver);
		loginPage.loginOrangeHRMPage("Admin", "admin123");
		HRM_PIPPage pipPage = new HRM_PIPPage(driver);
		pipPage.findAllSideMenuElementsAndClickOnSpecificElement("PIP");
		pipPage.addButton();
		pipPage.add_Employee("AAAA", "BBBB", "CCCC");
		pipPage.clickOnTopBarMenu("Employee List");
		pipPage.employeeSearching("AAAA");
	}

}
