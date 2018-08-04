package com.myfitnesspal.tests;

import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.myfitnesspal.pages.LoginPage;
import com.myfitnesspal.pages.MyHomePage;
import com.myfitnesspal.utilities.ConfigurationReader;

public class MyHomePageTests extends TestBase{
	
	
	MyHomePage myhome = new MyHomePage();
	LoginPage login= new LoginPage();
	
	
	
	@Test
	public void SPA1099(){
		//go to homepage
		driver.get(ConfigurationReader.getProperty("url"));
		
		driver.findElement(By.partialLinkText("Log In")).click();
		
		//login
		login.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
		
		myhome.UploadPhotoLink.click();
		
		
		//verify first title
		assertEquals(myhome.TitleYourPhotos.getText(), "Your Photos");
		
		//verify second title
		assertEquals(myhome.addMessage.getText(), "Add A New Photo*");
		
		myhome.chooseFileButton.sendKeys("");
		
		myhome.uploadButton.click();
		
		//verify error message
		assertEquals(myhome.errorMessage.getText(), "No Photo Provided");
		
		
	}
	
	
	@Test
	public void SPA1100() {
		
				//go to homepage
				driver.get(ConfigurationReader.getProperty("url"));
				
				driver.findElement(By.partialLinkText("Log In")).click();
				
				//login
				login.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
				
				myhome.UploadPhotoLink.click();
				
				
				//verify the title
				assertEquals(myhome.TitleYourPhotos.getText(), "Your Photos");
				
				//verify second title
				assertEquals(myhome.addMessage.getText(), "Add A New Photo*");
				
				myhome.chooseFileButton.sendKeys(System.getProperty("user.dir")+"/src/test/spoon.jpg");
				
				myhome.uploadButton.click();
				
				//check if it is uploaded or not
				assertTrue(myhome.deleteBox.isDisplayed());
				
				//clear the test
				myhome.deleteBox.click();
		
	}
	
	
	//Testing News Feed functionality
	@Test
	public void SPA1112() {
		
		
		String message="Hello SDET150K";
		
		//go to homepage
		driver.get(ConfigurationReader.getProperty("url"));
		
		driver.findElement(By.partialLinkText("Log In")).click();
		
		//login
		login.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
		
		//post the message
		myhome.newsFeedTextBox.sendKeys(message);
		
		myhome.shareButton.click();
		
		//check if message posted or not
		assertTrue(driver.findElement(By.xpath("//*[.='"+message+"']")).isDisplayed());
		
		
		
		
	}
	
	
	
	
	

}
