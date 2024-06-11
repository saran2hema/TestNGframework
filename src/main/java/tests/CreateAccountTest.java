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
import pages.UsermenuPage;
import utils.DataUtils;

public class CreateAccountTest extends UsermenuTest {
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
	
	
	//@Test
	public void TC10_CreateanAccount() throws IOException, InterruptedException {
		test = BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();

		//Create object of page LoginPage
		CreateAccountPage cap=new CreateAccountPage(driver);

		CreateAccountTest.test=CreateAccountTest.extent.createTest("CreateAccount1");

		//launch the SFDC app in browser
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		//Enter valid username
		Assert.assertTrue(cap.enterUsername(DataUtils.readLoginTestData("valid.username")), "Issue in entering Username");
		//Enter valid password
		Assert.assertTrue(cap.enterPassword(DataUtils.readLoginTestData("valid.password")), "Issue in entering password");
		//Click Log-In button
		Assert.assertTrue(cap.click(cap.loginButton),"Issue in clicking Login button");
		//Click Account Tab
		Assert.assertTrue(cap.selectTab(driver,DataUtils.readAccountsTestData("valid.tabName")), "Issue in clicking Account tab");
		//verify Account page
		//Assert.assertTrue(cap.verifyAccountPage(driver, DataUtils.readAccountsTestData("valid.title"), DataUtils.readAccountsTestData("valid.username")), null);
		//verify New button
		Assert.assertTrue(cap.verifynewAccount(driver, DataUtils.readAccountsTestData("valid.accountName")), "TC10:Fail -->Create account");
		//Thread.sleep(5000);
	}
	
	//@Test
	public void TC11_CreateaNewView() throws IOException, InterruptedException {
		test = BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();

		//Create object of page LoginPage
		CreateAccountPage cap=new CreateAccountPage(driver);

		CreateAccountTest.test=CreateAccountTest.extent.createTest("CreateNewView");

		//launch the SFDC app in browser
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		//Enter valid username
		Assert.assertTrue(cap.enterUsername(DataUtils.readLoginTestData("valid.username")), "Issue in entering Username");
		//Enter valid password
		Assert.assertTrue(cap.enterPassword(DataUtils.readLoginTestData("valid.password")), "Issue in entering password");
		//Click Log-In button
		Assert.assertTrue(cap.click(cap.loginButton),"Issue in clicking Login button");
		//Click Account Tab
		Assert.assertTrue(cap.selectTab(driver,DataUtils.readAccountsTestData("valid.tabName")), "Issue in clicking Account tab");
		//verify Account page
		//Assert.assertTrue(cap.verifyAccountPage(driver, DataUtils.readAccountsTestData("valid.title"), DataUtils.readAccountsTestData("valid.username")), "Issue in verifying account page");
		//Verify Create NEw view
		Assert.assertTrue(cap.verifyCreateNewView(driver, DataUtils.readAccountsTestData("viewName"),  DataUtils.readAccountsTestData("uniqueViewName")),"TC11 Createnewview--> Fail");
	
	}
	//@Test
	public void TC12_EditView() throws IOException, InterruptedException {
		test = BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();

		//Create object of page LoginPage
		CreateAccountPage cap=new CreateAccountPage(driver);

		CreateAccountTest.test=CreateAccountTest.extent.createTest("Edit view");

		//launch the SFDC app in browser
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		//Enter valid username
		Assert.assertTrue(cap.enterUsername(DataUtils.readLoginTestData("valid.username")), "Issue in entering Username");
		//Enter valid password
		Assert.assertTrue(cap.enterPassword(DataUtils.readLoginTestData("valid.password")), "Issue in entering password");
		//Click Log-In button
		Assert.assertTrue(cap.click(cap.loginButton),"Issue in clicking Login button");
		//Click Account Tab
		Assert.assertTrue(cap.selectTab(driver,DataUtils.readAccountsTestData("valid.tabName")), "Issue in clicking Account tab");
		//verify Account page
		Assert.assertTrue(cap.verifyAccountPage(driver, DataUtils.readAccountsTestData("valid.title"), DataUtils.readAccountsTestData("valid.username")), "Issue in verifying account page");
		//verify Edit view
		Assert.assertTrue(cap.verifyEditview(driver, "TestNGView"), "TC12--> Fail Edit view");
	}
	
	//@Test
	public void TC13_MergeAccounts() throws IOException, InterruptedException {
		test = BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();

		//Create object of page LoginPage
		CreateAccountPage cap=new CreateAccountPage(driver);

		CreateAccountTest.test=CreateAccountTest.extent.createTest("Merge Account");

		//launch the SFDC app in browser
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		//Enter valid username
		Assert.assertTrue(cap.enterUsername(DataUtils.readLoginTestData("valid.username")), "Issue in entering Username");
		//Enter valid password
		Assert.assertTrue(cap.enterPassword(DataUtils.readLoginTestData("valid.password")), "Issue in entering password");
		//Click Log-In button
		Assert.assertTrue(cap.click(cap.loginButton),"Issue in clicking Login button");
		//Click Account Tab
		Assert.assertTrue(cap.selectTab(driver,DataUtils.readAccountsTestData("valid.tabName")), "Issue in clicking Account tab");
		//verify Account page
		Assert.assertTrue(cap.verifyAccountPage(driver, DataUtils.readAccountsTestData("valid.title"), DataUtils.readAccountsTestData("valid.username")), "Issue in verifying account page");
		//Merge accounts
		Assert.assertTrue(cap.verifyMergeAccounts(driver, DataUtils.readLoginTestData("merge.accountName")),"TC13 Merge Accounts Fail");
	}
	
	@Test
	public void TC14_Report() throws IOException, InterruptedException {
		test = BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();

		//Create object of page LoginPage
		CreateAccountPage cap=new CreateAccountPage(driver);

		CreateAccountTest.test=CreateAccountTest.extent.createTest("Merge Account");

		//launch the SFDC app in browser
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		//Enter valid username
		Assert.assertTrue(cap.enterUsername(DataUtils.readLoginTestData("valid.username")), "Issue in entering Username");
		//Enter valid password
		Assert.assertTrue(cap.enterPassword(DataUtils.readLoginTestData("valid.password")), "Issue in entering password");
		//Click Log-In button
		Assert.assertTrue(cap.click(cap.loginButton),"Issue in clicking Login button");
		//Click Account Tab
		Assert.assertTrue(cap.selectTab(driver,DataUtils.readAccountsTestData("valid.tabName")), "Issue in clicking Account tab");
		//verify Account page
		Assert.assertTrue(cap.verifyAccountPage(driver, DataUtils.readAccountsTestData("valid.title"), DataUtils.readAccountsTestData("valid.username")), "Issue in verifying account page");
		//Verify Report
		Assert.assertTrue(cap.verifyReport(driver, DataUtils.readAccountsTestData("report.name")),"TC14 Report Fail");
	}

}
