package com.snapdeal.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverS {
	public static WebDriver driver;

	public static WebDriver getDriver() {
		if (IConstant.browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (IConstant.browser.equals("chrome")) {
			System.setProperty("WebDriver.chrome.driver",
					"C:\\Users\\Bob\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}

}
