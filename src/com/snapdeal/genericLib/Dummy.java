package com.snapdeal.genericLib;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Dummy {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		String expected = ".*";
		// 1. Open Snapdeal
		driver.get("https://www.snapdeal.com/");
		Actions act = new Actions(driver);

		// 2 Navigate To Computers and Game
		WebElement web = driver.findElement(By
				.xpath("//span[text()='Computers & Gaming']"));
		act.moveToElement((web)).perform();

		// 3. Click on storage
		driver.findElement(
				By.xpath("//span[@class='headingText' and text()='Storage']"))
				.click();
		Thread.sleep(2000);

		// 4. Validate Storage heading
		String actual = driver.findElement(
				By.xpath("//h1[@class='category-name']")).getText();

		System.out.println("Actual value is:" + actual);
		Assert.assertEquals(actual.indexOf("Storage"), 0, "Text Not found ");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,350)", "");
		// 5. Select filters
		// 16 GB
		WebElement web1 = driver
				.findElement(By
						.xpath("//a/text()[normalize-space() ='16 GB']/ancestor::label[starts-with(@for,'Capacity_s-16')]"));
		web1.click();
		Thread.sleep(2000);

		jse.executeScript("window.scrollBy(0,450)", "");

		// 2 GB
		WebElement web2 = driver
				.findElement(By
						.xpath("//a/text()[normalize-space() ='2 GB']/ancestor::label[starts-with(@for,'Capacity_s-2')]"));
		web2.click();
		Thread.sleep(2000);

		// 6. validate Selected filters

		String text16GB = driver
				.findElement(
						By.xpath("//a[@class='filter-name hashAdded' and text()[normalize-space() ='16 GB']]"))
				.getText();

		Assert.assertEquals(text16GB, "16 GB", "Not found");

		String text2GB = driver
				.findElement(
						By.xpath("//a[@class='filter-name hashAdded' and text()[normalize-space() ='2 GB']]"))
				.getText();
		Assert.assertEquals(text2GB, "2 GB", "Not found");
		Thread.sleep(2000);

		// 8. Clear all the filters
		driver.findElement(
				By.xpath("//div[@class=' clr-btn-Advfilters ']/button"))
				.click();
		Thread.sleep(4000);

		// 9. Validate filters are cleared

		WebElement webCheck16 = driver
				.findElement(By
						.xpath("//a[@class='filter-name hashAdded' and text()[normalize-space() ='16 GB']]/ancestor::label[starts-with(@for,'Capacity_s-16')]"));
		Boolean bool1 = webCheck16.isSelected();
		System.out.println("16 GB:" + bool1);

		WebElement webCheck2 = driver
				.findElement(By
						.xpath("//a[@class='filter-name hashAdded' and text()[normalize-space() ='2 GB']]/ancestor::label[starts-with(@for,'Capacity_s-2')]"));
		Boolean bool2 = webCheck2.isSelected();
		System.out.println("2 GB:" + bool2);

		Assert.assertFalse(bool1, "16%20Gb is selected");
		Assert.assertFalse(bool2, "2%20Gb is selected");

		// 10. Close snapdeal application
		Thread.sleep(4000);
		driver.quit();

	}

}
