package com.Orange.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.Generic;

public class HRM_PIPPage {

	WebDriver driver;
	Generic generic = new Generic();

	public HRM_PIPPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='oxd-sidepanel-body']//ul[@class='oxd-main-menu']//li//span") 
	List<WebElement> allMenus;
	
	@FindBy(tagName ="h6")
	WebElement text_PageHeading;
	
	@FindBy(xpath = "//div[@class='orangehrm-header-container']//button[@type='button']")
	WebElement add_A_Employee_Button;
	
	@FindBy(name ="firstName")
	WebElement firstName;
	
	@FindBy(name ="middleName")
	WebElement middleName;
	
	@FindBy(name ="lastName")
	WebElement lastName;
	
	@FindBy(xpath="//input[@xpath='1']")
	WebElement employeeNameInput;
	
	@FindBy(xpath ="//button[@type='submit']")
	WebElement search_Button;
	
	@FindBy (xpath="//a[@class='oxd-topbar-body-nav-tab-item']")
	List<WebElement> topBarMenus;
	
	@FindBy (xpath ="//div[@class='oxd-form-actions']//button[@type='submit']")
	WebElement saveButton;

	public void findAllSideMenuElementsAndClickOnSpecificElement(String pageName) throws Exception {
		for(WebElement eachMenu : allMenus) {
			if(eachMenu.getText().equalsIgnoreCase(pageName)) {
				eachMenu.click();
				Thread.sleep(2000);
				Generic.extentLogger = Generic.extentReport.createTest(pageName);
				Generic.extentLogger.pass(pageName +"Page loaded successfully", 
						MediaEntityBuilder.createScreenCaptureFromPath(Generic.captureScreenshot()).build());
				
			}
		}
//		Assert.assertEquals(text_PageHeading.getText(), pageName);	
		}
	
	public void addButton() {
		add_A_Employee_Button.click();
	}
	
	public  String add_Employee(String firstNamee, String middleNamee, String lastNamee) throws Exception {
		firstName.sendKeys(firstNamee);
		middleName.sendKeys(middleNamee);
		lastName.sendKeys(lastNamee);
		Thread.sleep(2000);
		Generic.extentLogger= Generic.extentReport.createTest("Employee basic details");
		Generic.extentLogger.pass("Add Employee page loaded successfully", 
				MediaEntityBuilder.createScreenCaptureFromPath(Generic.captureScreenshot()).build());
		saveButton.click();
		return firstNamee;
		
	}
	
	public void clickOnTopBarMenu(String topBar) {
		for(WebElement menu : topBarMenus) {
			if(menu.getText().equalsIgnoreCase(topBar)) {
				menu.click();
			}
		}
	}
	
	public void employeeSearching(String emplloyeeName) throws Exception {
		employeeNameInput.sendKeys(emplloyeeName);
		Thread.sleep(2000);
		search_Button.click();
		Generic.extentLogger= Generic.extentReport.createTest("Searching Newly added Employee");
		Generic.extentLogger.pass("Added New Employee is searched", 
				MediaEntityBuilder.createScreenCaptureFromPath(Generic.captureScreenshot()).build());
		
	}
	
	
}



