package com.CH.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.CH.qa.base.TestBase;

public class SuccessPage extends TestBase{
			
	public SuccessPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Collection of all web elements
	@FindBy(xpath = "//h1[contains(text(),'Success!')]")
	WebElement successMessage;
	
	@FindBy(xpath = "//p[contains(text(),'You have successfully verified your information.')]")
	WebElement pageHeader;
	
	@FindBy(xpath = "//button[contains(text(),'Start over')]")
	WebElement successBtn;
	
	//Compare page title
	public void validatePageTitle() {
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, prop.getProperty("Page_Title").toString());
	}
	
	//Validate messages
	public void validateMessages() {
		validateTexts(successMessage, prop.getProperty("success_pageHeader").toString());
		validateTexts(pageHeader, prop.getProperty("success_confirmMessage").toString());
		validateTexts(successBtn, prop.getProperty("succes_btntext").toString());
	}
	
	//compare actual Vs expected messages
	public void validateTexts(WebElement element, String message) {
	    Assert.assertEquals(element.getAttribute("innerText").toString(), message);
	}
	
	//Application to navigate back to "Tell us yourself" page
	public void clickButton() {
		successBtn.click();
	}
	

}
