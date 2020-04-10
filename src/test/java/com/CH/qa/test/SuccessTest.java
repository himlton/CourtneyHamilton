package com.CH.qa.test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.CH.qa.base.TestBase;
import com.CH.qa.pages.ConfirmPage;
import com.CH.qa.pages.SuccessPage;
import com.CH.qa.pages.TellUsYourSelfPage;

public class SuccessTest extends TestBase {
	
	TellUsYourSelfPage testUsYourSelfPage;
	ConfirmPage confirmPage;
	SuccessPage successPage;
	
	public SuccessTest() {
		super();
	}
	
	@BeforeTest (alwaysRun = true)
	public void setInit() throws IOException, InterruptedException {
		TestBase.init();
		testUsYourSelfPage = new TellUsYourSelfPage();
		confirmPage = new ConfirmPage();
		successPage = new SuccessPage();
		testUsYourSelfPage.insertData();
		testUsYourSelfPage.clickSubmitButton();
		successPage = confirmPage.btnContinue();
	}
	
	@Test (groups = "HappyPath")
	public void checkSuccessPage() {
		successPage.validatePageTitle();
		successPage.validateMessages();
		successPage.clickButton();
	}
	
	@AfterTest (alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
