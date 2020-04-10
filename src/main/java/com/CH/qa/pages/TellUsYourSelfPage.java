package com.CH.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.CH.qa.base.TestBase;

public class TellUsYourSelfPage extends TestBase {
	
	public TellUsYourSelfPage() throws IOException, InterruptedException {		
		PageFactory.initElements(driver, this);
	}

	//Values to be inserted into different fields. 
	public String address1 = "121 Metric Blvd";
	public String address2 = "Apt # 625";
	public String city = "Austin";
	public String State = "TX";
	public int zipCode = 78758;
	public Long mobile = 5748999996L;
	public String email = "test@gmail.com";
	public int dobDayV = 27;
	public int dobMonthV = 03;
	public int dobYearV = 1989;
	
	//Collection of all web elements
	@FindBy(xpath="//div[@class='sc-fzXfMC eGGPEB']")
	WebElement logo;

	@FindBy(xpath ="//h1[contains(text(),'Tell us about yourself')]")
	WebElement pageHeader;

	@FindBy(xpath="//p[@class='sc-AykKG bMdqdJ']")
	WebElement noteText;

	@FindBy(xpath="//h3[contains(text(),'Address')]")
	WebElement addressHeader;

	@FindBy(xpath="//input[@name='address1']")
	WebElement address1Text;

	@FindBy(xpath="//input[@name='address2']")
	WebElement address2Text;

	@FindBy(xpath="//input[@name='city']")
	WebElement addressCity;

	@FindBy(xpath="//select[@name='state']")
	WebElement addressState;

	@FindBy(xpath="//input[@name='zipCode']")
	WebElement addressZipCode;

	@FindBy(xpath="//h3[contains(text(), 'Contact')]")
	WebElement contactHeader;

	@FindBy(xpath="//input[@name='phone']")
	WebElement contactPhone;

	@FindBy(xpath="//input[@name='email']")
	WebElement contactEmail;

	@FindBy(xpath="//h3[contains(text(), 'Date of birth')]")
	WebElement dobHeader;

	@FindBy(xpath="//input[@name='dobMonth']")
	WebElement dobMonth;

	@FindBy(xpath="//input[@name='dobDay']")
	WebElement dobDay;

	@FindBy(xpath="//input[@name='dobYear']")
	WebElement dobYear;

	@FindBy(xpath="//button[contains(text(), 'Submit')]")
	WebElement btnSubmit;

	public String pageTitle() {
		String strTitle = driver.getTitle();
		return strTitle;
	}

	//To confirm if logo is being displayed
	public boolean companyLogo() {
		boolean companylogoDisplayed = logo.isDisplayed();
		return companylogoDisplayed;
	}
	
	//To validate page title
	public String validatePageHeader() {
		String actualPageHeader = pageHeader.getText();
		return actualPageHeader;
	}

	public String validateNoteText() {
		String actualNoteText = noteText.getText().toString();
		return actualNoteText;
	}

	//Method to insert data into different fields
	public void insertData() {
		address1Text.sendKeys(address1);
		address2Text.sendKeys(address2);
		addressCity.sendKeys(city);
		Select select = new Select(addressState);
		select.selectByValue(State);
		addressZipCode.sendKeys(Integer.toString(zipCode));
		contactPhone.sendKeys(Long.toString(mobile));
		contactEmail.sendKeys(email);
		dobMonth.sendKeys(Integer.toString(dobMonthV));
		dobDay.sendKeys(Integer.toString(dobDayV));
		dobYear.sendKeys(Integer.toString(dobYearV));
	}
	
	public String validateContactHeaderText() {
		String contactHeaderText = contactHeader.getText().toString();
		return contactHeaderText;
	}
	
	public String validateDOBHeaderText() {
		String DOBHeaderText = dobHeader.getText().toString();
		return DOBHeaderText;
	}

	public ConfirmPage clickSubmitButton() throws IOException, InterruptedException {
		btnSubmit.click();
		return new ConfirmPage();
	}
	
	
	//Validating error message for empty fields
	public void validateErrorMessages() throws InterruptedException {
		Thread.sleep(15000);
		btnSubmit.click();
		validateErrorMessage(address1Text, prop.getProperty("Address1_error_message"));
		validateErrorMessage(addressCity, prop.getProperty("City_error_message"));
		validateErrorMessage(addressState, prop.getProperty("State_error_message"));
		validateErrorMessage(addressZipCode, prop.getProperty("zipcode_error_message"));
		validateErrorMessage(contactEmail, prop.getProperty("email_error_message"));
		validateErrorMessage(contactPhone, prop.getProperty("mobile_error_message"));
		validateErrorMessageDOBM(dobYear, prop.getProperty("dob_error_message"));
		validateErrorMessageDOBM(dobDay, prop.getProperty("dob_error_message"));
		validateErrorMessageDOBM(dobMonth, prop.getProperty("dob_error_message"));
		
	}
	
	
	private void validateErrorMessage(WebElement element, String expectedErrorMessage) {
		btnSubmit.click();
		WebElement ele = element.findElement(By.xpath("following-sibling::span"));
		Assert.assertEquals(ele.getText(), expectedErrorMessage);
	}
	private void validateErrorMessageDOBM(WebElement element, String expectedErrorMessage) {
		btnSubmit.click();
		WebElement ele = element.findElement(By.xpath("parent::div/following-sibling::span"));
		Assert.assertEquals(ele.getText(), expectedErrorMessage);
	}
}
