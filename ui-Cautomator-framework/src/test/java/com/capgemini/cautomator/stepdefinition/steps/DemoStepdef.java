package com.capgemini.cautomator.stepdefinition.steps;

import org.openqa.selenium.WebDriver;

import com.capgemini.cautomator.runner.TestEnvironment;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;;


public class DemoStepdef {
	private WebDriver driver = TestEnvironment.driver;
		  
	@Given("^user is in homepage$") public void user_is_in_homepage() throws
	  Throwable { 
		Assert.assertEquals("https://www.flipkart.com/", driver.getCurrentUrl());
		Assert.assertEquals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!", driver.getTitle());
		
	  }
	 
    @When("^user navigates to Loginpage$")
    public void user_navigates_to_Loginpage() throws Throwable {
    	// Write code here that turns the phrase above into concrete actions
        throw new PendingException();
        
    }
    
    @When("^user enters the credential$")
    public void user_enters_the_credential() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^user able to login successfully$")
    public void user_able_to_login_successfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^user not able to login successfully$")
    public void user_not_able_to_login_successfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    
    
    
}