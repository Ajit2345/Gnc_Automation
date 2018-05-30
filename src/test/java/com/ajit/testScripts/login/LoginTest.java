package com.ajit.testScripts.login;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ajit.helper.logger.LoggerHelper;
import com.ajit.pageObject.account.Account;
import com.ajit.pageObject.home.Home;
import com.ajit.pageObject.login.Login;
import com.ajit.testBase.BaseTest;
import com.ajit.testBase.DataSource;

public class LoginTest extends BaseTest{
//	private static Logger log = LoggerHelper.getLogger(LoginTest.class);
	
	Login login;
	Home home;
	Account account;
	
	@DataProvider(name="testData")
	public Object[][] testData(){
		String[][] data = getExcelData("data.xlsx", "TestData");
		return data;
	}
	
	@BeforeClass
	public void beforeClass(){//DataSource.OR.getProperty("url")
		getApplicationURL(getData("url"));
//		getApplicationURL("http://www.gnc.com");
		home = new Home(driver);
		
		login = home.navigateToLogin();
	}
	
	
	
	
	
	@Test(dataProvider="testData")
	public void loginTest(String userName, String password, String runMode){
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("Run mode for this set of data is marked N");			
		}
		
		account = login.loginToApplication(userName, password);
		login = account.clickOnLogoutButton();
	}
	

}
