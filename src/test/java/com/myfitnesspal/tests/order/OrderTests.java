package com.myfitnesspal.tests.order;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.myfitnesspal.pages.LoginPage;

import com.myfitnesspal.tests.TestBase;
import com.myfitnesspal.utilities.ConfigurationReader;

public class OrderTests extends TestBase {

	String userId = ConfigurationReader.getProperty("username");
	String password = ConfigurationReader.getProperty("password");

	@Test(groups = { "smoke" }, description = "Verify labels and tab links are displayed", priority = 1)
	public void titleVerication() {
		LoginPage loginPage = new LoginPage();

		assertEquals(driver.getTitle(), "Free Calorie Counter, Diet & Exercise Journal | MyFitnessPal.com",
				"LoginPage is not displayed. Application is down.");
		loginPage.login(userId, password);

	}

}