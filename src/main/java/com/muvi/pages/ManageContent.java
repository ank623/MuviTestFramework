package com.muvi.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.muvi.base.TestBase;

public class ManageContent extends TestBase{

	@FindBy(xpath="//em[@class='icon-film left-icon']")
	WebElement manageContent;
	
	@FindBy(xpath="//ul/li/a[@href='/cmscontent/managecontent']")
	WebElement contentLibrary;
	
	@FindBy(xpath="//button[text()='Add Content']")
	WebElement addContentBtn;
	
	@FindBy(id="mname")
	WebElement contentInput;
	
	@FindBy(id="save-btn")
	WebElement submitBtn;
	
	@FindBy(id="content_category_value")
	WebElement contentCategory;
	
	public ManageContent()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void actionOperation()
	{
		Actions action = new Actions(driver);
		action.moveToElement(manageContent).build().perform();
		contentLibrary.click();
	}
	
	public VerifyContent addContent(String contentName, String category)
	{
		actionOperation();
		addContentBtn.click();
		contentInput.sendKeys(contentName);
		Select s = new Select(contentCategory);
		s.selectByVisibleText(category);
		submitBtn.click();
		actionOperation();
		return new VerifyContent();
	}
}