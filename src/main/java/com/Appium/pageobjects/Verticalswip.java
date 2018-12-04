package com.Appium.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Appium.testbase.Testbase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Verticalswip 
{
	public AppiumDriver<MobileElement> driver;
	
	Testbase testbase = new Testbase();
	public Verticalswip(AppiumDriver<MobileElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Views")
	//@AndroidFindBy(accessibility="Views")
	public WebElement views;
	
	@FindBy(id="Tabs")
	//@AndroidFindBy(accessibility="Tabs")
	public WebElement tabs;
	
	@FindBy(id="1. Content By Id")
	//@AndroidFindBy(accessibility="1. Content By Id")
	public WebElement content;
	
		
	public void setviews()
	{
		
		boolean flag = false;
		views.click();
		//driver.findElementByAccessibilityId("Views").click();
		for (int i = 0; i <= 20; i++) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				tabs.click();
				//driver.findElementByAccessibilityId("Tabs").click();
				break;
			} catch (Exception e) {
				Testbase.verticalSwipe();
				//verticalSwipe();
			}
		}
		flag=content.isDisplayed();
		//flag = driver.findElementByAccessibilityId("1. Content By Id").isDisplayed();
		if (flag) {
			System.out.println("Passed");
			System.out.println(flag);
		} else {
			System.out.println("Failed");
		}
	}
	
	
	

}
