package com.capgemini.cautomator.runner;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class TestEnvironment {
	public static WebDriver driver;

	@Before
    public void setup(Scenario scenario) {
    	System.setProperty("webdriver.chrome.driver","binary/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        
        System.out.println("------------------------------");
        System.out.println("Starting - " + scenario.getName());
        System.out.println("------------------------------");
    }
	
 	@Before
	public void openBrowser() {
 		//driver.get("http://www.flipkart.com");
 		driver.get("https://swtestweb.azurewebsites.net/home/default");
 		
	 }
	
	@After
    public void teardown(Scenario scenario) {
    	driver.close();
        System.out.println("------------------------------");
        System.out.println("Finished - " + scenario.getName() + ". Result = " + scenario.getStatus());
        System.out.println("------------------------------");
   }
    

	
}
