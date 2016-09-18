package com.snapdeal.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLibraryS {
	public void waitForPageLoad() {
		DriverS.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void waitforElementXpathPrasent(String wbXpath) {
		WebDriverWait waitXP = new WebDriverWait(DriverS.driver, 20);
		waitXP.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath(wbXpath)));
	}

	public void waitForElementIdToBePresent(String id) {
		WebDriverWait waitID = new WebDriverWait(DriverS.driver, 20);
		waitID.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
	}

	public void waitForElementClassNameToBePresent(String name) {
		WebDriverWait waitID = new WebDriverWait(DriverS.driver, 20);
		waitID.until(ExpectedConditions.presenceOfElementLocated(By
				.className(name)));
	}

	boolean flag = false;

	public boolean verifyText(WebElement wb, String expectedText) {
		if (wb.getText().equals(expectedText)) {
			flag = true;
			System.out.println(expectedText + "is verified");
			return flag;
		} else {
			System.out.println(expectedText + " page is not verfied");

		}
		return flag;

	}
}
