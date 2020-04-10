package com.CH.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.CH.qa.base.TestBase;
import com.CH.qa.pages.ConfirmPage;
import com.CH.qa.pages.TellUsYourSelfPage;

public class ConfirmTest extends TestBase{
	
	TellUsYourSelfPage tellUsYourSelfPage;
	ConfirmPage confirmPage;
	
	public ConfirmTest() throws IOException, InterruptedException{
		super();
		
	}
	
	@BeforeTest (alwaysRun = true)
	public void setUp() throws IOException, InterruptedException {
		TestBase.init();
		tellUsYourSelfPage = new TellUsYourSelfPage();
		tellUsYourSelfPage.insertData();
		confirmPage = new ConfirmPage();
		confirmPage= tellUsYourSelfPage.clickSubmitButton();
	}
	
	@Test (priority = 1, groups = {"HappyPath"})
	public void validatePageTitle() {
		
		String actualPageTitle = confirmPage.pageTitle();
		Assert.assertEquals(actualPageTitle, prop.getProperty("Page_Title"));
	}
	
	@Test (priority = 2, groups = {"HappyPath"})
	public void validateHeaderAndValues() throws InterruptedException {
		Thread.sleep(10000);
		confirmPage.validateHeaderAndValues();
		confirmPage.validateValues();
	}
	
	@Test (priority = 3, groups = {"HappyPath"})
	public void checkAndClickContinueButton() {
		confirmPage.btnContinue();
	}
	
	@AfterTest(alwaysRun = true)
	public void TearDown() {
		driver.quit();
	}
}
