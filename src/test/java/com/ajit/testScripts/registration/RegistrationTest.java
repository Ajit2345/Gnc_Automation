package com.ajit.testScripts.registration;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ajit.pageObject.account.Account;
import com.ajit.pageObject.home.Home;
import com.ajit.pageObject.login.Login;
import com.ajit.pageObject.register.Registration;
import com.ajit.testBase.BaseTest;

public class RegistrationTest extends BaseTest{
	Registration registration;
	Home home;
	Login login;
	Account account;
	
	
	@DataProvider(name="testData")
	public Object[][] testData(){
		String[][] data = getExcelData("data1.xlsx", "RegistrationData");
		return data;
	}
	
	@BeforeClass
	public void beforeClass(){//DataSource.OR.getProperty("url")
		getApplicationURL(getData("url"));
		home = new Home(driver);
		registration = home.navigateToRegistration();
	}
	
	@Test(dataProvider="testData")
	public void registrationTest(String firstName, String lastName, String email, String confirmEmail, String password, String confirmPassword, String country, String address1, String city, String state, String zip_code, String runMode){
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("Run mode for this set of data is marked N");			
		}
		
		account = registration.registrationToAnAccount(firstName, lastName, email, confirmEmail, password, confirmPassword, country, address1, city, state, zip_code);
		login = account.clickOnLogoutButton();
	}


}
