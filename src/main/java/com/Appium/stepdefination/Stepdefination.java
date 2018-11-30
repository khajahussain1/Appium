package com.Appium.stepdefination;

import org.openqa.selenium.By;

import com.Appium.pageobjects.Add_two_numbers;
import com.Appium.pageobjects.Webapp;
import com.Appium.testbase.Testbase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Stepdefination {

	public AppiumDriver<MobileElement> driver;

	Add_two_numbers twonumbers;
	Webapp webapp=new Webapp(Testbase.driver);

	@Given("^Launch the application in mobile \"([^\"]*)\"$")
	public void launch_the_application_in_mobile(String apptype) throws Throwable {
		Testbase.launchapp(apptype);
	}

	@Then("^Click on number seven$")
	public void click_on_number_seven() throws Throwable {
		twonumbers = new Add_two_numbers(Testbase.driver);
		
		twonumbers.setnumberseven();
	}

	@Then("^click on plus button$")
	public void click_on_plus_button() throws Throwable {
		twonumbers.plus_button();
	}

	@Then("^click on number two$")
	public void click_on_number_two() throws Throwable {
		twonumbers.setnumber();
	}

	@Then("^Click on equal button$")
	public void click_on_equal_button() throws Throwable {
		twonumbers.equal_button();
	}

	@Then("^Pass the value as \"([^\"]*)\"$")
	public void pass_the_value_as(String appium) throws Throwable 
	{
		webapp.text_box(appium);
	}

}
