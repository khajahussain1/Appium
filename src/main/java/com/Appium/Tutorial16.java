/**
 * 
 */
package com.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author CHIRAG
 *
 */
public class Tutorial16 {

	AppiumDriver<MobileElement> driver;

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		System.out.println("Session is creating");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "HTC Desire 626 dual sim");
		cap.setCapability("app", System.getProperty("user.dir") + "/app/ApiDemos.apk");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(url, cap);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Session is created");
	}

	@Test
	public void getWebViewText() {
		System.out.println("First Current Context : " + driver.getContext());
		driver.findElementByAccessibilityId("Views").click();
		for (int i = 0; i <= 20; i++) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				driver.findElementByAccessibilityId("WebView").click();
				break;
			} catch (Exception e) {
				verticalSwipe();
			}
		}
		// Using this method we switch to web view
		switchContext("WEBVIEW");
		// String webViewText = driver.findElementByXPath("//a[text()='Hello World! -
		// 1']").getText();

		String webViewText = driver.findElementByXPath("//android.webkit.WebView[@index='0']").getText();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		System.out.println(webViewText);
		System.out.println("welcome to hyd");

	}

	/**
	 * This method for switch view
	 * 
	 * @param context
	 * @author CHIRAG
	 */

	public void switchContext(String context) {
		System.out.println("Before Switching : " + driver.getContext());
		Set<String> con = driver.getContextHandles();
		for (String c : con) {
			System.out.println("Available Context : " + c);
			if (c.contains(context)) {
				driver.context(c);
				break;
			}
		}
		System.out.println("After Switching : " + driver.getContext());
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
	public void tearDown() {
		driver.quit();
	}

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		Tutorial16 obj = new Tutorial16();
		obj.setUp();
		obj.getWebViewText();
		obj.tearDown();
	}*/

}
