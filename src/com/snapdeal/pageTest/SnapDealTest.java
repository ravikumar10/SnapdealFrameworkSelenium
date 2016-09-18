package com.snapdeal.pageTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.snapdeal.genericLib.DriverS;
import com.snapdeal.genericLib.ExcelLibraryS;
import com.snapdeal.genericLib.IConstant;
import com.snapdeal.genericLib.WebDriverCommonLibraryS;
import com.snapdeal.pageObjectLib.SnapdealFirstPage;

public class SnapDealTest {
	ExcelLibraryS eLib;
	WebDriverCommonLibraryS wLib;
	WebDriver driver;
	IConstant cons;
	SnapdealFirstPage fp;

	@BeforeTest
	public void openSnapdeal() {
		eLib = new ExcelLibraryS();
		wLib = new WebDriverCommonLibraryS();
		driver = DriverS.getDriver();
		driver.manage().window().maximize();
		wLib.waitForPageLoad();

		fp = PageFactory.initElements(driver, SnapdealFirstPage.class);

	}

	@Test
	public void SelectFilters() {
		fp.openUrl();

		wLib.waitForPageLoad();
		fp.clickOnComputers();
		fp.storage().click();
		wLib.waitForPageLoad();

		Assert.assertEquals(fp.getTextStoragHeading().indexOf("Storage"), 0,
				"Text Not found ");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,350)", "");

		fp.s16GBCheckBox().click();

		jse.executeScript("window.scrollBy(0,350)", "");

		fp.s2GBCheckBox().click();

		Assert.assertEquals(fp.filter16Selected(), "16 GB", "Not found");

		Assert.assertEquals(fp.filter2Selected(), "2 GB", "Not found");
			
		fp.clearFilterBtnClick().click();
		wLib.waitForPageLoad();
		
		Assert.assertFalse(fp.deselect2GB(), "2 Gb Deselected");

		Assert.assertFalse(fp.deselect16GB(), "16 Gb Deselected");

		driver.quit();

	}

}
