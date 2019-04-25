
package com.Appium.stepdefination;
 
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Appium.testbase.Testbase;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
 
public class Hooks {
	
	AppiumDriver<MobileElement> driver;
	
	
	
	@Before
	public void beforeScenario(Scenario scenario) throws MalformedURLException 
	{
		System.out.println(scenario.getName());
		//Testbase.launchapp(apptype);
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				File sourcePath = ((TakesScreenshot)Testbase.driver).getScreenshotAs(OutputType.FILE);
				
				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
				
				Files.copy(sourcePath, destinationPath);   
 
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			} 
		}
	}
	
	
	
 
}