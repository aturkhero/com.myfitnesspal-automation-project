package com.myfitnesspal.tests.login;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;


import com.myfitnesspal.pages.LoginPage;
import com.myfitnesspal.tests.TestBase;
import com.myfitnesspal.utilities.ConfigurationReader;

public class LoginTests extends TestBase {

	@Test()
	public void positiveloginTest() {

		extentLogger = report.createTest("Positive login test");
		// info() --> to print a message
		extentLogger.info("entering user credetials");

		driver.findElement(By.xpath("//li/a[.='Log In']")).click();
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

		extentLogger.info("click log in");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();

		assertTrue(new AllOrdersPage().logoutLink.isDisplayed());
		extentLogger.info("Verifying log out link");
		// pass --> message that tells us what passed
		extentLogger.pass("Verifies log out link displayed");

	}
	@Test()
	public void positiveloginTest2() {

		extentLogger = report.createTest("Positive login test");
		// info() --> to print a message
		extentLogger.info("entering user credetials");

		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Testr");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

		extentLogger.info("click log in");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();

		assertTrue(new AllOrdersPage().logoutLink.isDisplayed());
		extentLogger.info("Verifying log out link");
		// pass --> message that tells us what passed
		extentLogger.pass("Verifies log out link displayed");

	}

	@Test(priority = 2, groups = { "smoke" })
	public void positiveLoginUsingPOM() {
		LoginPage loginPage = new LoginPage();
		loginPage.userName.sendKeys(ConfigurationReader.getProperty("username"));
		loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
		loginPage.loginButton.click();

	}

	@Test(priority = 1, groups = { "smoke" })
	public void invalidUsernameTest() {
		extentLogger = report.createTest("Positive Login test 2");
		
		LoginPage loginPage = new LoginPage();
		loginPage.userName.sendKeys("invalid");
		loginPage.password.sendKeys("test");
		loginPage.loginButton.click();
		
		throw new SkipException("This test is work in progress");
		
	//	String errMsg = loginPage.invalidUserNameErrMsg.getText();

	//	assertEquals(errMsg, "Invalid Login or Password.");
	}

}
