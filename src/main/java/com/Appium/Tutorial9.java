package com.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Tutorial9 {
	
	
	private AppiumDriver<MobileElement> driver;
	
	@BeforeMethod
	public void setUp() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "HTC Desire 626 dual sim");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
//		cap.setCapability("appPackage", "in.amazon.mShop.android.shopping");
//		cap.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		URL url= new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	
	
	@Test
	public void addTwoNumber()
	{
		driver.findElementById("com.android.calculator2:id/digit7").click();
		driver.findElementByAccessibilityId("plus").click();
		driver.findElementByXPath("//*[@text='2']").click();
		//driver.findElementByXPath("//android.widget.GridLayout[@resource-id='com.android.calculator2:id/pad_numeric']//android.widget.Button[@index='11']").click();
		driver.findElementByXPath("//android.widget.Button[@resource-id='com.android.calculator2:id/equal']").click();
		
		//driver.findElementByXPath("//*[@text='=']").click();
		driver.findElementByXPath("//android.widget.Button[@resource-id='com.android.calculator2:id/equal']");
		
		String text = driver.findElementByXPath("//android.widget.EditText[@text='9']").getText();
		if(text.equals("9"))
		{
			System.out.println("Passed");
		}else
		{
			System.out.println("Failed"); 
		}
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	/*public static void main(String[] args) throws MalformedURLException {
		Tutorial9 obj = new Tutorial9();
		obj.setUp();
		obj.addTwoNumber();
		obj.tearDown();

	}*/

}
