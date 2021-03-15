package com.muvi.util;


import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.muvi.base.TestBase;

public class TestUtil extends TestBase
{
	

	
	public static void Wait()
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		Boolean link;
	link = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[contains(text(),'Manage M')]"), "Manage Metadata"));
	}
}

