package com.ajit.pageObject.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajit.helper.waitHelper.WaitHelper;
import com.ajit.pageObject.account.Account;

import com.ajit.testBase.DataSource;

public class Login {
	
	private WebDriver driver;
	private WaitHelper waitHelper;
	private static Logger log = Logger.getLogger(Login.class);
	
	@FindBy(xpath=".//*[@id='dwfrm_login_username']")
	WebElement userName;
	
	@FindBy(xpath=".//*[@id='dwfrm_login_password']")
	WebElement password;
	
	@FindBy(xpath=".//*[@id='dwfrm_login']/fieldset/div[3]/button")
	WebElement loginButton;
	
	public Login(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(userName, DataSource.getExplicitWait());
	}
	
	public void setUserName(String userName){
		log.info("entering "+ userName);
		this.userName.sendKeys(userName);
	}
	
	public void setPassword(String password){
		this.password.sendKeys(password);
	}
	
	public Account loginToApplication(String userName, String password){
		setUserName(userName);
		setPassword(password);
		loginButton.click();		
		return new Account(driver);		
	}
	
	

}
