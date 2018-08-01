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
LoginPage loginPage= new LoginPage();
	
	@Test()
	public void positiveloginTest() {

		extentLogger = report.createTest("Positive login test");
		// info() --> to print a message
		extentLogger.info("entering user credetials");

		driver.findElement(By.xpath("//li/a[.='Log In']")).click();
		loginPage.userName.sendKeys("rob123QW@gmail.com");
		loginPage.password.sendKeys("1qazxsw2");

		loginPage.loginButton.click();
		
		extentLogger.info("click log in");
		//driver.findElement(By.xpath("//input[@class='submit']")).click();

		assertTrue(new LoginPage().logout.isDisplayed());
		extentLogger.info("Verifying log out link");
		// pass --> message that tells us what passed
		extentLogger.pass("Verifies log out link displayed");

	}

}
