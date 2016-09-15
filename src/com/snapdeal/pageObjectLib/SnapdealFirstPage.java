package com.snapdeal.pageObjectLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.snapdeal.genericLib.DriverS;
import com.snapdeal.genericLib.WebDriverCommonLibraryS;

public class SnapdealFirstPage extends WebDriverCommonLibraryS{
	Actions act=new Actions(DriverS.driver);

	@FindBy (xpath="//span[text()='Computers & Gaming']")
	WebElement clickComputeAndGaming;
	
	public WebElement clickOnComputers(){
		return clickComputeAndGaming;
	}
	
	@FindBy (xpath= "//span[@class='headingText' and text()='Storage']")
	WebElement clickOnStorage;
	
	public WebElement storage(){
		return clickOnStorage;
	}
	
	@FindBy (xpath= "//h1[@class='category-name']")
	WebElement StoragHeadinge;
	
	public String getTextStoragHeading(){
		return StoragHeadinge.getText();
	}
	
	@FindBy (xpath="//a/text()[normalize-space() ='16 GB']/ancestor::label[starts-with(@for,'Capacity_s-16')]")
	WebElement s16GBCheckBox;
	
	public WebElement s16GBCheckBox(){
		return s16GBCheckBox;
	}
	
	@FindBy (xpath="//a/text()[normalize-space() ='2 GB']/ancestor::label[starts-with(@for,'Capacity_s-2')]")
	WebElement s2GBCheckBox;
	
	public WebElement s2GBCheckBox(){
		return s2GBCheckBox;
	}
	
	@FindBy (xpath="//a[@class='filter-name hashAdded' and text()[normalize-space() ='16 GB']]")
	WebElement filter16Select;
	
	public String filter16Selected(){
		return filter16Select.getText();
	}
	
	@FindBy (xpath="//a[@class='filter-name hashAdded' and text()[normalize-space() ='2 GB']]")
	WebElement filter2Select;
	
	public String filter2Selected(){
		return filter2Select.getText();
	}
	
	@FindBy (xpath="//div[@class=' clr-btn-Advfilters ']/button")
	WebElement clearFilterBtn;
	
	public WebElement clearFilterBtnClick(){
		return clearFilterBtn;
	}
	
	@FindBy (xpath="//a[@class='filter-name hashAdded' and text()[normalize-space() ='16 GB']]/ancestor::label[starts-with(@for,'Capacity_s-16')")
	WebElement validateClearFilter16;
	
	public WebElement clearFilter16GB(){
		return validateClearFilter16;
	}
	
	@FindBy (xpath="//a[@class='filter-name hashAdded' and text()[normalize-space() ='2 GB']]/ancestor::label[starts-with(@for,'Capacity_s-16')")
	WebElement validateClearFilter2;
	
	public WebElement clearFilter2GB(){
		return validateClearFilter2;
	}
	
	
}



//String expectedValue="abof Support\n"+
//"Read our frequently asked questions for quick answers to your queries";
//normalize-space(//h1[@class='category-name' and text()='Storage'])