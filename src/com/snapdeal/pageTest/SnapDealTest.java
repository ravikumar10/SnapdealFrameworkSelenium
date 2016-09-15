package com.snapdeal.pageTest;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.snapdeal.genericLib.DriverS;
import com.snapdeal.genericLib.ExcelLibraryS;
import com.snapdeal.genericLib.IConstant;
import com.snapdeal.genericLib.WebDriverCommonLibraryS;


public class SnapDealTest {
	 ExcelLibraryS eLib;
	 WebDriverCommonLibraryS wLib;
	 WebDriver driver;
	 IConstant cons;
	 Action act;
	 
	@BeforeClass
	public void configBeforeClass(){
	  eLib = new ExcelLibraryS();
	   wLib = new WebDriverCommonLibraryS();
	  driver = DriverS.getDriver();
	  act=new Action(driver);

	}
	@BeforeTest
	public void openSnapdeal(){
		driver.get(cons.url);
		
	}
	
	@Test
	public void SelectFilters(){
		clickComputeAndGaming
		
	}

}
