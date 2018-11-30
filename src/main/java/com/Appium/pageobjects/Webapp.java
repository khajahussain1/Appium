package com.Appium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Webapp {
	
	public AppiumDriver<MobileElement> driver;
	
	public Webapp(AppiumDriver<MobileElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@AndroidFindBy(tagName="q")
	public WebElement txetbox;
	
	public void text_box(String appium)
	{
		driver.findElementByName("q").sendKeys("appium");
	}

}
