package com.muvi.pages;

import java.util.HashSet;

import java.util.Set;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.muvi.base.TestBase;
import com.muvi.util.TestUtil;

public class RegisterPage extends TestBase{

	@FindBy(xpath="//a[@role='button']")
	WebElement freeTrialBtn;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="companyname")
	WebElement companyName;
	
	@FindBy(name="phone")
	WebElement phoneNumber;
	
	@FindBy(id="email")
	WebElement emailId;
	
	@FindBy(id="inputPassword")
	WebElement Password;
	
	@FindBy(id="subdomain")
	WebElement Domain;
	                                                        
	@FindBy(id="nextbtn")
	WebElement nextBtn;
	
	@FindBy(id="nextbtn")
	WebElement nextbtn2;
	
	@FindBy(xpath="//a[@href='https://cms.muvi.com/cmscontent/managecontent' and text()='Next ']")
	WebElement manageMetadata;
	
	@FindBy(xpath="//a[@href='https://cms.muvi.com/template' and text()='Next ']")
	WebElement contentLibrary;
	
	@FindBy(xpath="//a[@href='https://cms.muvi.com/monetization/settings' and text()='Next ']")
	WebElement manageTemplate;
	
	@FindBy(xpath="//a[@class='quick_button' and text()='Ok, Got It ']")
	WebElement settings;
	
	public RegisterPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//navigating to registration page
	public String registerButton()
	{
		freeTrialBtn.click();
		return driver.getTitle();
	}
	
 
	
	//Entering details and submitting
	public ManageContent contentManagePage(String phone, String password) throws InterruptedException
	{
		String fName=randomIdentifier();
		name.sendKeys(fName);
		companyName.sendKeys(fName);
		phoneNumber.sendKeys(phone);
		emailId.sendKeys(fName+"@"+fName+".com");
		Password.sendKeys(password);
		Domain.clear();
		Domain.sendKeys(fName+".www.muvi.com");
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("document.querySelector('label.custom-control-label',':before').click();");
		
		js.executeScript("window.scrollBy(0,200)");

		nextBtn.click();

		Thread.sleep(10000);
		driver.navigate().refresh();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,200)");
		nextbtn2.click();
		
		TestUtil.Wait();
		manageMetadata.click();
		Thread.sleep(5000);
		contentLibrary.click();
		Thread.sleep(5000);
		manageTemplate.click();
		Thread.sleep(5000);
		settings.click();
		
		return new ManageContent();
	    }
	
		final static String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

		final static java.util.Random rand = new java.util.Random();

		// consider using a Map<String,Boolean> to say whether the identifier is being used or not 
		final static Set<String> identifiers = new HashSet<String>();

		public static String randomIdentifier() {
			StringBuilder builder = new StringBuilder();
			while(builder.toString().length() == 0) {
				int length = rand.nextInt(5)+5;
				for(int i = 0; i < length; i++) {
					builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
				}
				if(identifiers.contains(builder.toString())) {
					builder = new StringBuilder();
				}
			}
			return builder.toString();
		}
	
}
