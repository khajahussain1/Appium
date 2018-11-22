package com.Appium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Khaja 
{
	WebDriver driver;
	
	@BeforeMethod
	public void beforemethod()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/libs/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
	}
	
	@Test
	public void test1()
	{
		System.out.println("welcome to hyd");
	}

}
