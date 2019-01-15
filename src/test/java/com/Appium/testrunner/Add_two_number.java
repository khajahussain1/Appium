package com.Appium.testrunner;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "./feature/Add_two_numbers.feature" }, glue = {
		"classpath:com/Appium/stepdefination" }, plugin = { "pretty",
				"com.cucumber.listener.ExtentCucumberFormatter:src/main/java/extent_reports/Extentreport.html",
				"html:target/cucumber-html-reports", "json:target/cucumber-json-reports/cucumber.json",
				"junit:target/cucumber-junit-reports/cucumber.xml" }, strict = true, dryRun = false, monochrome = true, 
				snippets = SnippetType.CAMELCASE)

public class Add_two_number extends AbstractTestNGCucumberTests {
	static String  testcase;
	

	@BeforeClass
	public  void beforeclass()
	{
		testcase=this.getClass().getSimpleName();
	}
	@AfterClass
	public static void setup() throws IOException {
		
		File fi = new File("target/extent-config.xml");
		Reporter.loadXMLConfig(fi);
		// Reporter.setSystemInfo("user", System.getProperty("user.name"));
		// Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		// Reporter.setSystemInfo("os", "Mac OSX");
		// Reporter.setTestRunnerOutput("Sample test runner output message");
		// Reporter.addScreenCaptureFromPath(screenshotPath);
		//Reporter.addScreenCaptureFromPath(imagePath, testcase);
	}

}