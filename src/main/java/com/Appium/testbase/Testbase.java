package com.Appium.testbase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Testbase {

	public static AppiumDriver<MobileElement> driver;
	//public static AndroidDriver<MobileElement> driver;

	public static void launchapp(String apptype) throws MalformedURLException {
		if (apptype.equals("native")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("platformName", "Android");
			cap.setCapability("deviceName", "HTC Desire 626 dual sim");
			cap.setCapability("appPackage", "com.android.calculator2");
			cap.setCapability("appActivity", "com.android.calculator2.Calculator");
			// cap.setCapability("appPackage", "in.amazon.mShop.android.shopping");
			// cap.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
			URL url = new URL("http://0.0.0.0:4723/wd/hub");
			driver = new AndroidDriver<MobileElement>(url, cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		else if (apptype.equals("chrome")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("platformName", "Android");
			cap.setCapability("deviceName", "HTC Desire 626 dual sim");
			cap.setCapability("browserName", "Chrome");
			URL url = new URL("http://0.0.0.0:4723/wd/hub");
			driver = new AndroidDriver<MobileElement>(url, cap);
			driver.get("http://www.google.com");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if (apptype.equals("hybrid")) {

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
	}

	public static void verticalSwipe() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width / 2;
		int starty = (int) (height * 0.80);
		int endy = (int) (height * 0.20);
		driver.swipe(x, starty, x, endy, 500);

	}

}
