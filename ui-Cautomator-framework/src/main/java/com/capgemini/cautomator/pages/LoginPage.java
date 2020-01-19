package com.capgemini.cautomator.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;

@FindBy(name="uid")
WebElement user99GuruName;

@FindBy(name="pwd")
WebElement pwd99GuruName;

LoginPage(WebDriver driverFromPreviousClass){
		//Set driver passed from caller class
		this.driver = driverFromPreviousClass;
		//initialize all webelements in this class
		PageFactory.initElements(driverFromPreviousClass, this);
	}

public void setUsername(String usr) {
	
}
public void setPassword(String pwd) {
	
}

public HomePage login() {
	
	return new HomePage(driver);
	
}

}
