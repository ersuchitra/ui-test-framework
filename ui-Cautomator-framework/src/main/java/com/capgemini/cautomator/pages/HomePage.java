package com.capgemini.cautomator.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	@FindBy(name="uid")
    WebElement user99GuruName;
	
	
	HomePage(WebDriver driverFromPreviousClass){
		//Set driver passed from caller class
		this.driver = driverFromPreviousClass;
		//initialize all webelements in this class
		PageFactory.initElements(driverFromPreviousClass, this);
	}
	
	
	
}
