package com.CH.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.CH.qa.base.TestBase;
import com.CH.qa.pages.TellUsYourSelfPage;

public class TellUsYourSelfTest extends TestBase {

	TellUsYourSelfPage 	tellUsYourSelfPage;
	
	public TellUsYourSelfTest() {
		super();
	}

	@BeforeTest (alwaysRun = true)
	public void setUp() throws IOException, InterruptedException {
		init();
		tellUsYourSelfPage = new TellUsYourSelfPage();
	}

	@Test (priority=1, groups={"HappyPath"} )
	public void getTitle() throws IOException {
		String actualPageTitle = tellUsYourSelfPage.pageTitle();
		Assert.assertEquals(actualPageTitle, prop.getProperty("Page_Title"));
		takeScreenShot("TellUsYourSelfTest_Title");
	}
	
	@Test (priority=2, groups={"HappyPath"})
	public void companyLogo() throws IOException {
		Assert.assertEquals(tellUsYourSelfPage.companyLogo(), true);
		takeScreenShot("TellUsYourSelfTest_CompanyLogo");
	}
	
	
	@Test (priority=3, groups={"HappyPath"})
	public void pageHeader() throws IOException {
		String actualPageHeader = tellUsYourSelfPage.validatePageHeader();
		Assert.assertEquals(actualPageHeader, prop.getProperty("Section_Header"));
		takeScreenShot("TellUsYourSelfTest_validatePageHeader");
	}
	
	@Test (priority=4, groups={"HappyPath"})
	public void noteText() throws IOException {
		String actualNoteText = tellUsYourSelfPage.validateNoteText();
		Assert.assertEquals(actualNoteText, prop.getProperty("Note_Insert"));
		takeScreenShot("TellUsYourSelfTest_noteText");
	}
	
	@Test (priority=5, groups={"HappyPath"})
	public void contactHeader() throws IOException {
		String actualContactHeaderText = tellUsYourSelfPage.validateContactHeaderText();
		Assert.assertEquals(actualContactHeaderText, prop.getProperty("Contact_Text"));
		takeScreenShot("TellUsYourSelfTest_validateHeader");
	}
	
	@Test (priority=6, groups={"HappyPath"})
	public void dobHeader() throws IOException {
		String actualDOBHeaderText = tellUsYourSelfPage.validateDOBHeaderText();
		Assert.assertEquals(actualDOBHeaderText, prop.getProperty("DOB_Text"));
		takeScreenShot("TellUsYourSelfTest_dobHeader");
	}
	
	@Test (priority = 7, groups={"HappyPath"})
	public void insertData() throws IOException, InterruptedException {
		tellUsYourSelfPage.insertData();
		tellUsYourSelfPage.clickSubmitButton();
		takeScreenShot("TellUsYourSelfTest_validateInsertData");
		
	}
	
	@Test (priority = 8, groups={"NegativeScenario"} )
	public void validateErrorMessage() throws IOException, InterruptedException {
		tellUsYourSelfPage.validateErrorMessages();
		takeScreenShot("TellUsYourSelfTest_ErrorMessages");
	}

	@AfterTest (alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
