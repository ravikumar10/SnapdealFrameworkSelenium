package com.snapdeal.pageObjectLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.snapdeal.genericLib.DriverS;
import com.snapdeal.genericLib.IConstant;

public class SnapdealFirstPage {
	public void openUrl() {
		DriverS.driver.get(IConstant.url);
	}

	@FindBy(xpath = "//span[text()='Computers & Gaming']")
	WebElement clickComputeAndGaming;

	Actions act = new Actions(DriverS.driver);

	public void clickOnComputers() {
		act.moveToElement((clickComputeAndGaming)).perform();

	}

	@FindBy(xpath = "//span[@class='headingText' and text()='Storage']")
	WebElement clickOnStorage;

	public WebElement storage() {
		return clickOnStorage;
	}

	@FindBy(xpath = "//h1[@class='category-name']")
	WebElement StoragHeadinge;

	public String getTextStoragHeading() {
		return StoragHeadinge.getText();
	}

	@FindBy(xpath = "//a/text()[normalize-space() ='16 GB']/ancestor::label[starts-with(@for,'Capacity_s-16')]")
	WebElement s16GBCheckBox;

	public WebElement s16GBCheckBox() {
		return s16GBCheckBox;
	}

	@FindBy(xpath = "//a/text()[normalize-space() ='2 GB']/ancestor::label[starts-with(@for,'Capacity_s-2')]")
	WebElement s2GBCheckBox;

	public WebElement s2GBCheckBox() {
		return s2GBCheckBox;
	}

	@FindBy(xpath = "//a[@class='filter-name hashAdded' and text()[normalize-space() ='16 GB']]")
	WebElement filter16Select;

	public String filter16Selected() {
		return filter16Select.getText();
	}

	@FindBy(xpath = "//a[@class='filter-name hashAdded' and text()[normalize-space() ='2 GB']]")
	WebElement filter2Select;

	public String filter2Selected() {
		return filter2Select.getText();
	}

	@FindBy(xpath = "//div[@class=' clr-btn-Advfilters ']/button")
	WebElement clearFilterBtn;

	public WebElement clearFilterBtnClick() {
		return clearFilterBtn;
	}

	// 16 GB Unchecked xpath validation

	@FindBy(xpath = "//a[@class='filter-name hashAdded' and text()[normalize-space() ='16 GB']]/ancestor::label[starts-with(@for,'Capacity_s-16')]")
	WebElement uncheck16GB;

	public Boolean deselect16GB() {
		try {
		    Thread.sleep(1000);
		} catch (InterruptedException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		Boolean bool16 = uncheck16GB.isSelected();
		return bool16;
	}

	// 2 GB Unchecked xpath validation

	@FindBy(xpath = "//a[@class='filter-name hashAdded' and text()[normalize-space() ='2 GB']]/ancestor::label[starts-with(@for,'Capacity_s-2')]")
	WebElement uncheck2GB;

	public boolean deselect2GB() {
		try {
		    Thread.sleep(1000);
		} catch (InterruptedException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		Boolean bool2 = uncheck2GB.isSelected();
		return bool2;
	}

}
