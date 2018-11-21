/**
 * 
 */
package com.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Tutorial12 {

	AppiumDriver<MobileElement> driver;
	String path;

	@BeforeMethod
	public void setup() throws MalformedURLException {
		System.out.println("Session is creating");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "Nexus 9");
		cap.setCapability("app", System.getProperty("user.dir") + "/app/ApiDemos.apk");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(url, cap);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Session is created");
	}

	@Test
	public void clickTab() {
		boolean flag = false;
		driver.findElementByAccessibilityId("Views").click();
		for (int i = 0; i <= 20; i++) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				driver.findElementByAccessibilityId("Tabs").click();
				break;
			} catch (Exception e) {
				verticalSwipe();
			}
		}
		flag = driver.findElementByAccessibilityId("1. Content By Id").isDisplayed();
		if (flag) {
			System.out.println("Passed");
			System.out.println(flag);
		} else {
			System.out.println("Failed");
		}
	}

	public void verticalSwipe() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width / 2;
		int starty = (int) (height * 0.80);
		int endy = (int) (height * 0.20);
		driver.swipe(x, starty, x, endy, 500);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	/*
	 * public static void main(String[] args) { Tutorial12 obj = new Tutorial12();
	 * obj.setup(); obj.clickTab();
	 * 
	 * }
	 */
}
