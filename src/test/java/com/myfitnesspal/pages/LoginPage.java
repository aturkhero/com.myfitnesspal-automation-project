package com.myfitnesspal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myfitnesspal.utilities.Driver;

public class LoginPage {
	
	public LoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);	
	}
	
	
	@FindBy(partialLinkText="Log In")
	public WebElement logIn; 
	
	@FindBy(name = "username")
	public WebElement userName;

	@FindBy(name = "password")
	public WebElement password;

	@FindBy(xpath = "//input[@class='expand-width']")
	public WebElement loginButton;

	@FindBy(partialLinkText = "Log Out")
	public WebElement logout;

	public void login(String uid, String pwd) {
		userName.sendKeys(uid);
		password.sendKeys(pwd);
		loginButton.click();
	}

}
