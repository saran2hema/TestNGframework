package tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constants.WaitConstants;
import pages.CreateAccountPage;
import pages.CreateOptyPage;
import utils.DataUtils;

public class CreateOptyTest extends LoginTest{
	@BeforeMethod
	public void preConditions(Method name) {

		System.out.println("Preconditions: Launch chrome browser with headless=false");
		BaseTest.setDriver("chrome", false);

	}
	@AfterMethod
	public void postConditions() {
		System.out.println("Postconditions: Close the chrome browser");
		//driver.quit();
		BaseTest.getDriver().close();

	}
	@AfterTest
	public void afterTest() {
		BaseTest.getDriver().quit();
	}

	@Test
	public void TC15_OpportunityDropDown() throws IOException, InterruptedException {
		test = BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();

		//Create object of page LoginPage
		CreateOptyPage cop=new CreateOptyPage(driver);

		CreateOptyTest.test=CreateOptyTest.extent.createTest("CreateOpportunity");

		//launch the SFDC app in browser
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		//Login to SFDC application
		Assert.assertTrue(cop.logintoSFDC(DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password"), driver),"Issue in logintoSFDC()");
		//Click Opportunities tab
		Assert.assertTrue(cop.verifyOptyPage(driver,DataUtils.readOptyTestData("opty.title")), "Opportunities page is not displayed");
		//Verify options in Opportunities Dropdown
		Assert.assertTrue(cop.verifyOptyDropdown(driver),"TC15_OpportunityDropDown--> Fail");
		

	}	

}
