package com.muvi.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.muvi.base.TestBase;

public class VerifyContent extends TestBase{

	@FindBy(xpath="(//div[@class='caption'])[1]")
	WebElement createdContent;
	
	public VerifyContent()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContentDisplayed()
	{
		return createdContent.isDisplayed();
	}
}
