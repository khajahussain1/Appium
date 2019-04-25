package com.Appium.utility;

import com.Appium.pageobjects.Add_two_numbers;
import com.Appium.pageobjects.Webapp;
import com.Appium.testrunner.Verticalswip;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjectManager {

	private AppiumDriver<MobileElement> driver;
	private Add_two_numbers twonumbers;
	private Webapp webapp;
	private Verticalswip verticalswip;

	public PageObjectManager(AppiumDriver<MobileElement> driver) {

		this.driver = driver;

	}

	public Add_two_numbers gettwonumbers() {

		return (twonumbers == null) ? twonumbers = new Add_two_numbers(driver) : twonumbers;

	}

	public Webapp getwebapp() {

		return (webapp == null) ? webapp = new Webapp(driver) : webapp;

	}

//	public Verticalswip getverticalswip() {
//
//		return (verticalswip == null) ? verticalswip = new Verticalswip(driver) : verticalswip;
//
//	}

	
}