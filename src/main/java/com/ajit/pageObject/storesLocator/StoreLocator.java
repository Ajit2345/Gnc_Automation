package com.ajit.pageObject.storesLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajit.helper.waitHelper.WaitHelper;
import com.ajit.testBase.DataSource;

public class StoreLocator {
	WebDriver driver;
	WaitHelper waitHelper;
	@FindBy(xpath=".//*[@id='pl-proximityInput']")
	WebElement searchField;
	@FindBy(xpath=".//*[@id='pl-searchForm']/div/form/input")
	WebElement searchButton;
	
	public StoreLocator(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(searchField, DataSource.getExplicitWait());
	}
	
	public void locateStores(String location){
		searchField.sendKeys(location);
		searchButton.click();		
	}
	

}
