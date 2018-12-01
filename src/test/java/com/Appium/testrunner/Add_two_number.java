package com.Appium.testrunner;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "feature", glue = { "classpath:com/Appium/stepdefination" }, plugin = { "pretty",
		"com.cucumber.listener.ExtentCucumberFormatter:src/main/java/extent_reports/Extentreport.html",
		"html:target/cucumber-html-reports", "json:target/cucumber-json-reports/cucumber.json",
		"junit:target/cucumber-junit-reports/cucumber.xml" }, strict = true, dryRun = false, monochrome = true, 
		snippets = SnippetType.CAMELCASE, tags = "@Regresion")

public class Add_two_number extends AbstractTestNGCucumberTests {
	// features= {"./feature/Add_two_numbers.feature"}
	@AfterClass
	public static void setup() throws IOException {
		File fi = new File("target/extent-config.xml");
		Reporter.loadXMLConfig(fi);
		// Reporter.setSystemInfo("user", System.getProperty("user.name"));
		// Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		// Reporter.setSystemInfo("os", "Mac OSX");
		// Reporter.setTestRunnerOutput("Sample test runner output message");
	}

}