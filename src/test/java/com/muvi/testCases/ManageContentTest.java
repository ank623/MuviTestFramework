package com.muvi.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.muvi.base.TestBase;
import com.muvi.pages.ManageContent;
import com.muvi.pages.RegisterPage;
import com.muvi.pages.VerifyContent;

public class ManageContentTest extends TestBase{

	RegisterPage register;
	ManageContent manage;

	VerifyContent content;
	
	public ManageContentTest()
	{
		super();

	}

	@BeforeMethod
	public void setup() throws InterruptedException 
	{
		initialize();
		register = new RegisterPage();
		manage =register.contentManagePage(prop.getProperty("Phone"),prop.getProperty("Password"));
	}

	@Test
	public void addContentTest() 
	{
	content= manage.addContent(prop.getProperty("ContentName"), prop.getProperty("ContentCategory"));
	}


	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

