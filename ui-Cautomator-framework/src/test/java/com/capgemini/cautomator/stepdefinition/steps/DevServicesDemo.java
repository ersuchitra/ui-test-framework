package com.capgemini.cautomator.stepdefinition.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.capgemini.cautomator.runner.TestEnvironment;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;


public class DevServicesDemo {
	private WebDriver driver = TestEnvironment.driver;
	
		  
	@Given("^user is in homepage$") public void user_is_in_homepage() throws
	  Throwable { 
		Assert.assertEquals("https://swtestweb.azurewebsites.net/home/default", driver.getCurrentUrl());
		Assert.assertEquals("Development Services Portal", driver.getTitle());
		
	  }
	 
    @When("^user navigates to Loginpage$")
    public void user_navigates_to_Loginpage() {
    	driver.findElement(By.linkText("Sign in")).click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //throw new PendingException();
        
    }
    
    @When("^user enters the credential$")
    public void user_enters_the_credential() {
        driver.findElement(By.id("logonIdentifier")).sendKeys("suchitra.mohanty@capgemini.com");
        driver.findElement(By.id("password")).sendKeys("Dec@2019");
        driver.findElement(By.id("next")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //throw new PendingException();
    }

    @Then("^user able to login successfully$")
    public void user_able_to_login_successfully()  {
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actualURL ="https://swtestweb.azurewebsites.net/dashboard/home";
    	String expURL=driver.getCurrentUrl();
    	Assert.assertEquals(actualURL, expURL);
    	
		/*
		 * if(actualURL.equalsIgnoreCase(expURL)) {
		 * System.out.println("User Able to Login Successfully, And User is in Homepage"
		 * ); } else { System.out.println("User Not Able to Login"); }
		 */
    	
        //throw new PendingException();
    }

    @Then("^user not able to login successfully$")
    public void user_not_able_to_login_successfully()  {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    
    
    
}