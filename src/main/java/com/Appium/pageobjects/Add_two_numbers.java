package com.Appium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Add_two_numbers {

	AppiumDriver<MobileElement> driver;

	public Add_two_numbers(AppiumDriver<MobileElement> driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @AndroidFindBy(id= "com.android.calculator2:id/digit7")
	@AndroidFindBy(xpath = "//*[@text='7']")
	public WebElement numberseven_button;

	@AndroidFindBy(accessibility = "plus")
	public WebElement plusbutton;

	@AndroidFindBy(xpath = "//*[@text='2']")
	public WebElement numbertwo_button;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.calculator2:id/equal']")
	public WebElement equal_button;

	public void setnumberseven() {
		numberseven_button.click();
	}

	public void plus_button() {
		plusbutton.click();
	}

	public void setnumber() {
		numbertwo_button.click();
	}

	public void equal_button() {
		equal_button.click();
	}
}
