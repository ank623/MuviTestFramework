package com.muvi.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.muvi.base.TestBase;
import com.muvi.pages.ManageContent;
import com.muvi.pages.RegisterPage;
import com.muvi.pages.VerifyContent;

public class VerifyContentTest extends TestBase{
	
	RegisterPage register;
	ManageContent manage;

	VerifyContent content;
	
	public VerifyContentTest()
	{
		super();

	}

	@BeforeMethod
	public void setup() throws InterruptedException 
	{
		initialize();
		register = new RegisterPage();
		manage =register.contentManagePage(prop.getProperty("Phone"),prop.getProperty("Password"));
		content =  manage.addContent(prop.getProperty("ContentName"), prop.getProperty("ContentCategory"));
	}
	
	@Test
	public void contentTest()
	{
		Boolean b = content.verifyContentDisplayed();
		Assert.assertTrue(b, "Content is available");
	}

	
}
