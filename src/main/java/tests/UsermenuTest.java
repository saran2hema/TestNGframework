package tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import constants.WaitConstants;
import listeners.TestListeners;
import pages.LoginPage;
import pages.UsermenuPage;
import utils.CommonUtils;
import utils.DataUtils;

@Listeners(TestListeners.class)
public class UsermenuTest extends BaseTest {
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
	
	//@Test(enabled=false)
	//@Test(groups="usermenu")
	public void TC05_Usermenu() throws IOException {
		test = BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();

		//Create object of page LoginPage
		UsermenuPage up=new UsermenuPage(driver);

		BaseTest.test=BaseTest.extent.createTest("VerifyLoginwithcorrectCredentials1");

		//launch the SFDC app in browser
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		//Enter valid username
		Assert.assertTrue(up.enterUsername(DataUtils.readLoginTestData("valid.username")), "Issue in entering Username");

		//Enter valid password
		Assert.assertTrue(up.enterPassword(DataUtils.readLoginTestData("valid.password")), "Issue in entering password");
		//Click Log-In button

		Assert.assertTrue(up.click(up.loginButton),"Issue in clicking Login button");

		//click usermenu
		Assert.assertTrue(up.selectUsermenu(), "Issue in clicking usermenu dropdown");
		//Verify usermenu dropdown options
		Assert.assertTrue(up.verifyUserMenu(), "Issue in verifying usermenu dropdown menu");

		CommonUtils.captureScreenShot(driver);
	}

	@Test
	//@Test(enabled=false)
	public void TC07_MySettings() throws IOException, InterruptedException {
		test = BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();

		//Create object of page LoginPage
		UsermenuPage up=new UsermenuPage(driver);

		BaseTest.test=BaseTest.extent.createTest("VerifyLoginwithcorrectCredentials1");

		//launch the SFDC app in browser
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		//Enter valid username
		Assert.assertTrue(up.enterUsername(DataUtils.readLoginTestData("valid.username")), "Issue in entering Username");

		//Enter valid password
		Assert.assertTrue(up.enterPassword(DataUtils.readLoginTestData("valid.password")), "Issue in entering password");
		//Click Log-In button

		Assert.assertTrue(up.click(up.loginButton),"Issue in clicking Login button");
		//click usermenu
		Assert.assertTrue(up.selectUsermenu(), "Issue in clicking usermenu dropdown");
		//click Mysettings
		Assert.assertTrue(up.click(up.mysettings),"Issue in Selecting Mysettings button");
		//click personal link
		Assert.assertTrue(up.verifyPersonal(),"Issue in verifying personal link");
		//click Display & Layput link
		Assert.assertTrue(up.verifyDisplayLayout(),"Issue in verifying Display and Layout link");
		//Verify email setting link
		Assert.assertTrue(up.verifyEmailLink(DataUtils.readLoginTestData("valid.sendername"),DataUtils.readLoginTestData("valid.username"), driver),"Issue in verifying Display and Layout link");
		//verify Calendar & Remainders
		Assert.assertTrue(up.verifyCalendar(driver), "Issue in Calendar&Reminders link");
	}
	
	//@Test(dependsOnGroups="usermenu")
	public void TC08_DeveloperConsole() throws IOException {
		test = BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();

		//Create object of page UserMenuPage
		UsermenuPage up=new UsermenuPage(driver);

		BaseTest.test=BaseTest.extent.createTest("VerifyLoginwithcorrectCredentials1");

		//launch the SFDC app in browser
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		//Enter valid username
		Assert.assertTrue(up.enterUsername(DataUtils.readLoginTestData("valid.username")), "Issue in entering Username");
		//Enter valid password
		Assert.assertTrue(up.enterPassword(DataUtils.readLoginTestData("valid.password")), "Issue in entering password");
		//Click Log-In button
		Assert.assertTrue(up.click(up.loginButton),"Issue in clicking Login button");
		//click usermenu
		Assert.assertTrue(up.selectUsermenu(), "Issue in clicking usermenu dropdown");
		//select Developer Console
		Assert.assertTrue(up.verifyDeveloperConsole(driver, DataUtils.readLoginTestData("title.developerConsole")), "Fail: Issue in verifying Developer Console");

	}
	
	//@Test
	public void TC09_Logout() throws IOException, InterruptedException {
		test = BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();

		//Create object of page UserMenuPage
		UsermenuPage up=new UsermenuPage(driver);

		BaseTest.test=BaseTest.extent.createTest("VerifyLoginwithcorrectCredentials1");

		//launch the SFDC app in browser
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		//Enter valid username
		Assert.assertTrue(up.enterUsername(DataUtils.readLoginTestData("valid.username")), "Issue in entering Username");
		//Enter valid password
		Assert.assertTrue(up.enterPassword(DataUtils.readLoginTestData("valid.password")), "Issue in entering password");
		//Click Log-In button
		Assert.assertTrue(up.click(up.loginButton),"Issue in clicking Login button");
		//click usermenu
		Assert.assertTrue(up.selectUsermenu(), "Issue in clicking usermenu dropdown");
		//click logout and verify
		Assert.assertTrue(up.verifyLogout(driver), "TC09_Logout-Fail Issue in Logout"); 
	}


}
