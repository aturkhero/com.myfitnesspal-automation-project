package com.myfitnesspal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myfitnesspal.utilities.Driver;

public class MyHomePage {
	
	
	public MyHomePage() {
		PageFactory.initElements(Driver.getDriver(), this);	
	}
	
	@FindBy(id="ember1719")
	public WebElement UploadPhotoLink;
	
	
	@FindBy(xpath="//*[@id='main']/h2")
	public WebElement TitleYourPhotos;
	
	@FindBy(name="Filedata")
	public WebElement chooseFileButton;

	@FindBy(name="commit")
	public WebElement uploadButton;
	
	@FindBy(xpath="//div[@id='flash']/p")
	public WebElement errorMessage;
	
	@FindBy(xpath="//*[@id='profile']/div[2]/h3")
	public WebElement addMessage;
	
	@FindBy(id="big_image_box")
	public WebElement imageBox;
	
	@FindBy(partialLinkText="Delete")
	public WebElement deleteBox;
	
	@FindBy(id="ember1871")
	public WebElement newsFeedTextBox;
	
	@FindBy(xpath="//button[.='Share']")
	public WebElement shareButton;
	
	
	
	
}
