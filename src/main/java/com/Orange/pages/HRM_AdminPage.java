package com.Orange.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Generic;

public class HRM_AdminPage extends Generic {
	
	  WebDriver driver;
	Generic generic = new Generic();
	
	public HRM_AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void adminPage(String page,String myMenu,String name) throws InterruptedException {
		openGivenMenuFromMainMenu(page);
		clickOnUserManagementMenufromTopMenuBar(myMenu);
		searchByUserName(name);
	}
	
	public  void openGivenMenuFromMainMenu(String myPage) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> allMenu = driver.findElements(By.xpath("//ul//li[@class='oxd-main-menu-item-wrapper']"));
		clickAnElementFromListOfElement(allMenu,myPage);
	}
	public void clickOnUserManagementMenufromTopMenuBar(String myMenu) throws InterruptedException {
		List<WebElement> allTopMenu = driver.findElements(By.xpath("//nav[@aria-label='Topbar Menu']//ul//li"));
		WebElement myElement = null;
		for (WebElement eachtTopMenu : allTopMenu) {
			if (eachtTopMenu.getText().equalsIgnoreCase(myMenu)) {
				myElement = eachtTopMenu;
				eachtTopMenu.click();
				break;
			}
		}
		WebElement mySubElement = myElement.findElement(By.xpath("//a[text()='Users']"));
		Thread.sleep(2000);
		mySubElement.click();
	}
	

	
	
	@FindBy(xpath = "//div[@class='oxd-input-group__label-wrapper']//following-sibling::div/input")
	WebElement userName;
	@FindBy(xpath = " //button[text()=' Search ']")
	WebElement button_search;
	

	public  void searchByUserName(String name) {
		generic.sendTextToAnElement(userName, name);
		generic.clickAnElement(button_search);
	}

}
