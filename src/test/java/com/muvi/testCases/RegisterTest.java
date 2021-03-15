package com.muvi.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.muvi.base.TestBase;
import com.muvi.pages.ManageContent;
import com.muvi.pages.RegisterPage;


public class RegisterTest extends TestBase{

	RegisterPage register;

	ManageContent manage;

	public RegisterTest()
	{
		super();

	}

	@BeforeMethod
	public void setup()
	{
		initialize();
		register = new RegisterPage();

	}
	
	
	@Test
	public void contentManageTest() throws InterruptedException
	{
		String title=register.registerButton();
		System.out.println("Title of the page is" +title);
		
		manage=register.contentManagePage(prop.getProperty("Phone"),
				prop.getProperty("Password"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
	//	driver.quit();
	}
}

