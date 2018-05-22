package com.ajit.pageObject.account;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajit.helper.waitHelper.WaitHelper;
import com.ajit.pageObject.login.Login;
import com.ajit.testBase.DataSource;

public class Account {
	WebDriver driver;
	WaitHelper waitHelper;
	private static Logger log = Logger.getLogger(Login.class);
	
	@FindBy(xpath=".//*[@id='primary']/ul/li[1]/div/h4")
	WebElement profile;
	@FindBy(xpath=".//*[@id='wrapper']/div[2]/ul/li[1]/div/a/span")
	WebElement userLogged;
	@FindBy(xpath=".//*[@id='wrapper']/div[2]/ul/li[1]/div/div/div[1]/div[2]/a[1]")
	WebElement account;
	@FindBy(xpath=".//*[@id='wrapper']/div[2]/ul/li[1]/div/div/div[1]/div[2]/a[2]")
	WebElement myGNCRewards;
	@FindBy(xpath=".//*[@id='wrapper']/div[2]/ul/li[1]/div/div/div[1]/div[2]/a[3]")
	WebElement myList;
	@FindBy(xpath=".//*[@id='wrapper']/div[2]/ul/li[1]/div/div/div[1]/div[2]/a[4]")
	WebElement purchaseHistory;
	@FindBy(xpath=".//*[@id='wrapper']/div[2]/ul/li[1]/div/div/div[1]/div[2]/a[5]")
	WebElement logout;
	
	public Account(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(profile, DataSource.getExplicitWait());
	}
	
	public void clickOnLoggedUserButton(){
		userLogged.click();
	}
	
	public Login clickOnLogoutButton(){
		clickOnLoggedUserButton();
		logout.click();
		return new Login(driver);
	}

	

}
