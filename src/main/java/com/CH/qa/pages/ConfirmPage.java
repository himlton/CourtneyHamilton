package com.CH.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.CH.qa.base.TestBase;

public class ConfirmPage extends TestBase{
	
	TellUsYourSelfPage tellUsYourSelfPage;
	
	public ConfirmPage() throws IOException, InterruptedException {
		super();
		PageFactory.initElements(driver, this);
		tellUsYourSelfPage = new TellUsYourSelfPage();
	}
	
	
	//Collection of all web elements
	@FindBy(xpath="//h1[contains(text(),'Everything look good')]")
	WebElement pageHeader;

	@FindBy(xpath="//p[contains(text(), 'Please double check your information. We use this for verification purposes.')]")
	WebElement noteText;
	
	@FindBy(xpath="//h4[contains(text(), 'Address 1')]")
	WebElement address1Header;
	
	@FindBy(xpath="//h4[contains(text(), 'Address 1')]/parent::div")
	WebElement address1Value;
	
	@FindBy(xpath="//h4[contains(text(), 'Address 2')]")
	WebElement address2Header;
	
	@FindBy(xpath="//h4[contains(text(), 'Address 2')]/parent::div")
	WebElement address2Value;
			
	@FindBy(xpath="//h4[contains(text(), 'City')]")
	WebElement addressCityHeader;
	
	@FindBy(xpath="//h4[contains(text(), 'City')]/parent::div")
	WebElement addressCityValue;
	
	@FindBy(xpath="//h4[contains(text(), 'State')]")
	WebElement addressStateHeader;
	
	@FindBy(xpath="//h4[contains(text(), 'State')]/parent::div")
	WebElement addressStateValue;
	
	@FindBy(xpath="//h4[contains(text(), 'Zip Code')]")
	WebElement addressZipCodeHeader;
	
	@FindBy(xpath="//h4[contains(text(), 'Zip Code')]/parent::div")
	WebElement addressZipCodeValue;
	
	@FindBy(xpath="//h4[contains(text(), 'Phone')]")
	WebElement contactPhoneHeader;
	
	@FindBy(xpath="//h4[contains(text(), 'Phone')]/parent::div")
	WebElement contactPhoneValue;
	
	@FindBy(xpath="//h4[contains(text(), 'Email')]")
	WebElement contactEmailHeader;
	
	@FindBy(xpath="//h4[contains(text(), 'Email')]/parent::div")
	WebElement contactEmailValue;
	
	@FindBy(xpath="//h4[contains(text(), 'Month')]")
	WebElement dobMonthHeader;
	
	@FindBy(xpath="//h4[contains(text(), 'Month')]/parent::div")
	WebElement dobMonthValue;
	
	@FindBy(xpath="//h4[contains(text(), 'Day')]")
	WebElement dobDayHeader;

	@FindBy(xpath="//h4[contains(text(), 'Day')]/parent::div")
	WebElement dobDayValue;
	
	@FindBy(xpath="//h4[contains(text(), 'Year')]")
	WebElement dobYearHeader;
	
	@FindBy(xpath="//h4[contains(text(), 'Year')]/parent::div")
	WebElement dobYearValue;
	
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	WebElement btnContinue;	
	
	
	//Validate the page title
	public String pageTitle() {
		String actualPageTitle = driver.getTitle();
		return actualPageTitle;
	}
	
	
	//Validate all headers on this page
	public void validateHeaderAndValues(){
		validateHeader(pageHeader, prop.getProperty("Confirm_Page_Header"));
		validateHeader(noteText, prop.getProperty("Note_Confirm"));
		validateHeader(address1Header, prop.getProperty("Address1_InternalText"));
		validateHeader(address2Header, prop.getProperty("Address2_InternalText"));
		validateHeader(addressCityHeader, prop.getProperty("City_InternalText"));
		validateHeader(addressStateHeader, prop.getProperty("State_InternalText"));
		validateHeader(addressZipCodeHeader, prop.getProperty("ZipCode_InternalText"));
		validateHeader(contactPhoneHeader, prop.getProperty("Phone_InternalText"));
		validateHeader(contactEmailHeader, prop.getProperty("Email_InternalText"));
		validateHeader(dobDayHeader, prop.getProperty("DobDay_InternalText"));
		validateHeader(dobMonthHeader, prop.getProperty("DobMonth_InternalText"));
		validateHeader(dobYearHeader, prop.getProperty("DobYear_InternalText"));		
	}
	
	//Method to compare actual Vs expected strings
	
	private void validateHeader(WebElement element, String expectedText) {
		Assert.assertEquals(element.getAttribute("innerText").trim(), expectedText);
	}
	
	
	//Validate values for each component
	public void validateValues(){
		validateValue(address1Value,"ADDRESS 1\n"+tellUsYourSelfPage.address1 );
		validateValue(address2Value, "ADDRESS 2\n"+ tellUsYourSelfPage.address2);
		validateValue(addressCityValue, "CITY\n"+tellUsYourSelfPage.city);
		validateValue(addressStateValue, "STATE\n"+tellUsYourSelfPage.State);
		validateValue(addressZipCodeValue, "ZIP CODE\n"+tellUsYourSelfPage.zipCode);
		validateValue(contactPhoneValue, "PHONE\n"+tellUsYourSelfPage.mobile);
		validateValue(contactEmailValue, "EMAIL\n"+tellUsYourSelfPage.email);
		validateValue(dobDayValue, "DOB DAY\n"+tellUsYourSelfPage.dobDayV);
		validateValue(dobMonthValue, "DOB MONTH\n"+tellUsYourSelfPage.dobMonthV);
		validateValue(dobYearValue, "DOB YEAR\n"+tellUsYourSelfPage.dobYearV);		
	}
	
	//Compare actual Vs expected values
	private void validateValue(WebElement element, String expectedText) {
		Assert.assertEquals(element.getAttribute("innerText").trim(), expectedText);
	}
	
	
	//To compare actual Vs Expected button texts and to navigate on the next page
	public SuccessPage btnContinue() {
		Assert.assertEquals(btnContinue.getAttribute("innerText").trim(), prop.getProperty("Button_Text"));
		btnContinue.click();
		return new SuccessPage();
	}
	
}
