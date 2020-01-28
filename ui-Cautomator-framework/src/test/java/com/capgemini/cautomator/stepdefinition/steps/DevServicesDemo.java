package com.capgemini.cautomator.stepdefinition.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.capgemini.cautomator.runner.TestEnvironment;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;


public class DevServicesDemo {
	private WebDriver driver = TestEnvironment.driver;
	
		  
	@Given("^user in signin page$") public void user_in_signin_page() throws
	  Throwable { 
		//Assert.assertEquals("https://edqy-test.login.em2.oraclecloud.com", driver.getCurrentUrl());
		Assert.assertEquals("Sign In", driver.getTitle());
		
	  }
	 
    @When("^user in Loginpage$")
    public void user_in_Loginpage() {
    	String signInPage = driver.findElement(By.id("btnActive")).getText();
    	System.out.println(signInPage);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	String expText = "Sign In";
    	Assert.assertEquals(signInPage, expText);
    }
        
   
    
    @When("^user enters the credential$")
    public void user_enters_the_credential() {
        driver.findElement(By.id("userid")).sendKeys("MOHANTSU");
        driver.findElement(By.id("password")).sendKeys("Monday20DK");
        driver.findElement(By.id("btnActive")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //throw new PendingException();
    }

    @Then("^user able to login successfully$")
    public void user_able_to_login_successfully()  {
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actualTitle ="Welcome1";
    	String expTitle=driver.getTitle();
    	Assert.assertEquals(actualTitle, expTitle);
    	
		/*
		 * if(actualURL.equalsIgnoreCase(expURL)) {
		 * System.out.println("User Able to Login Successfully, And User is in Homepage"
		 * ); } else { System.out.println("User Not Able to Login"); }
		 */
    	
        //throw new PendingException();
    }

    @Then("^user not able to login successfully$")
    public void user_not_able_to_login_successfully()  {
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	String actualMsg = "You have a new home page!";
    	String expMsg = driver.findElement(By.id("pt1:commandLink1")).getText();
    	Assert.assertEquals(actualMsg, expMsg);
    }

    
    
    
}