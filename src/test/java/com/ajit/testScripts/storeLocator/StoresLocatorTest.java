package com.ajit.testScripts.storeLocator;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ajit.pageObject.home.Home;
import com.ajit.pageObject.storesLocator.StoreLocator;
import com.ajit.testBase.BaseTest;

public class StoresLocatorTest extends BaseTest{
	
	Home home;
	StoreLocator storeLocator;
//	String location = getData("storeLocation");
	
	
	@BeforeClass
	public void beforeClass(){//DataSource.OR.getProperty("url")
		getApplicationURL(getData("url"));
		home = new Home(driver);
		storeLocator = home.navigateToStoresLocator();
	}
	
	
	
	
	@Test
	public void storesLocatorTest(){
		
		storeLocator.locateStores(getData("storeLocation"));
		
	}
	
	

}
