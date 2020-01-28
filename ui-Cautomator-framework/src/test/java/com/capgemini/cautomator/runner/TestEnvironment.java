package com.capgemini.cautomator.runner;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.capgemini.cautomator.utilities.PropFileReader;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class TestEnvironment {
	String propFile="config/properties/global.properties";
	PropFileReader propFileReader=new PropFileReader(propFile);
	public static WebDriver driver;


	@Before
    public void setup(Scenario scenario) {
		System.setProperty("webdriver.chrome.driver",propFileReader.getDriverPath());
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
		driver.get(propFileReader.getApplicationUrl());
 		
	 }
	
	@After
    public void teardown(Scenario scenario) {
		if (scenario.isFailed()) {
			 String screenshotName = scenario.getName().replaceAll(" ", "_");
			 try {
			 File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			 File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
			 Files.copy(sourcePath, destinationPath);   
			 Reporter.addScreenCaptureFromPath(destinationPath.toString());
			 } catch (IOException e) {
			 } 
			 }
	
    	driver.close();
        System.out.println("------------------------------");
        System.out.println("Finished - " + scenario.getName() + ". Result = " + scenario.getStatus());
        System.out.println("------------------------------");
   }
    

	
}
