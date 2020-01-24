package com.capgemini.cautomator.runner;

import java.io.File;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features/",
glue= {"com.capgemini.cautomator.stepdefinition","com.capgemini.cautomator.runner"},
tags= {"@devserviceslogin"},
plugin= { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }
)

public class CapgeminiRunner {
	@AfterClass
	 public static void writeExtentReport() {
	  Reporter.loadXMLConfig(new File("config/extent-config.xml"));
	  Reporter.setSystemInfo("user", System.getProperty("user.name"));
      Reporter.setSystemInfo("os", "Windows");
     }
}
