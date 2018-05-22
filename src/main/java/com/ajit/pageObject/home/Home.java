package com.ajit.pageObject.home;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajit.helper.logger.LoggerHelper;
import com.ajit.helper.waitHelper.WaitHelper;
import com.ajit.pageObject.login.Login;
import com.ajit.pageObject.register.Registration;
import com.ajit.testBase.DataSource;

public class Home {
	WebDriver driver;
	Login loginpage;
	WaitHelper waitHelper;
	private static Logger log = LoggerHelper.getLogger(Home.class);
	//.//*[@id='wrapper']/div[2]/ul/li[1]/div/a/span
	@FindBy(xpath=".//*[@id='wrapper']/div[2]/ul/li[1]/div/a/span")
	WebElement myAccount;
	@FindBy(xpath=".//*[@id='wrapper']/div[2]/ul/li[1]/div/div/div/div/a[1]")
	WebElement login;
	@FindBy(xpath=".//*[@id='wrapper']/div[2]/ul/li[1]/div/div/div/div/a[2]")
	WebElement register;
	@FindBy(xpath=".//*[@id='wrapper']/div[2]/ul/li[1]/div/div/div/div/a[3]")
	WebElement myGNCReward;
	@FindBy(xpath=".//*[@id='wrapper']/div[2]/ul/li[1]/div/div/div/div/a[4]")
	WebElement purchaseOrder;
	

	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(myAccount, DataSource.getExplicitWait());
	}
	public Login navigateToLogin(){
		myAccount.click();
		waitHelper.waitForElement(login, DataSource.getExplicitWait());
		login.click();
		return new Login(driver);
	}
	
	public Registration navigateToRegistration(){
		myAccount.click();
//		waitHelper.waitForElement(login, DataSource.getExplicitWait());
		register.click();
		return new Registration(driver);
	}

}
