package com.ajit.pageObject.register;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ajit.helper.waitHelper.WaitHelper;
import com.ajit.pageObject.account.Account;
import com.ajit.pageObject.login.Login;
import com.ajit.testBase.DataSource;

public class Registration {
	private WebDriver driver;
	private WaitHelper waitHelper;
	private static Logger log = Logger.getLogger(Registration.class);
	Select select;
	
	@FindBy(xpath=".//*[@id='dwfrm_profile_customer_firstname']")
	WebElement firstName;
	
	@FindBy(xpath=".//*[@id='dwfrm_profile_customer_lastname']")
	WebElement lastName;
	
	@FindBy(xpath=".//*[@id='dwfrm_profile_customer_email']")
	WebElement email;
	
	@FindBy(xpath=".//*[@id='dwfrm_profile_customer_emailconfirm']")
	WebElement confirmEmail;
	
	@FindBy(xpath=".//*[@id='dwfrm_profile_login_password']")
	WebElement password;
	
	@FindBy(xpath=".//*[@id='dwfrm_profile_login_passwordconfirm']")
	WebElement confirmPassword;
	
	@FindBy(xpath=".//*[@id='dwfrm_profile_address_country']")
	WebElement country;
	
	@FindBy(xpath=".//*[@id='dwfrm_profile_address_address1']")
	WebElement address1;	
	
	@FindBy(xpath=".//*[@id='dwfrm_profile_address_city']")
	WebElement city;
	
	@FindBy(xpath=".//*[@id='dwfrm_profile_address_states_state']")
	WebElement state;
	
	@FindBy(xpath=".//*[@id='dwfrm_profile_address_postal']")
	WebElement zip_code;
	
	@FindBy(xpath=".//*[@id='account-submit-main']")
	WebElement applyButton;	
	
	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}
	
	public void setEmail(String email) {
		this.email.sendKeys(email);
	}
	
	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail.sendKeys(confirmEmail);
	}
	
	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword.sendKeys(confirmPassword);
	}
	
	//select
	public void setCountry(String country) {
		select = new Select(this.country);
		select.selectByVisibleText(country);
	}
	
	public void setAddress1(String address1) {
		this.address1.sendKeys(address1);
	}	
	
	public void setCity(String city) {
		this.city.sendKeys(city);
	}
//select	
	public void setState(String state) {
		select = new Select(this.state);
		select.selectByVisibleText(state);
	}
	
	public void setZip_code(String zip_code) {
		this.zip_code.sendKeys(zip_code);
	}


	public Registration(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(firstName, DataSource.getExplicitWait());
	}
	
	
	public Account registrationToAnAccount(String firstName, String lastName, String email, String confirmEmail, 
			String password, String confirmPassword, String country, String address1, String city,
			String state,String zip_code){
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setConfirmEmail(confirmEmail);
		setPassword(password);
		setConfirmPassword(confirmPassword);
		setCountry(country);
		setAddress1(address1);
		setCity(city);
		setState(state);
		setZip_code(zip_code);		
		applyButton.click();		
		return new Account(driver);		
	}

}
