package com.Appium.stepdefination;

import com.Appium.pageobjects.Add_two_numbers;
import com.Appium.pageobjects.Verticalswip;
import com.Appium.pageobjects.Webapp;
import com.Appium.testbase.Testbase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Stepdefination {

	public AppiumDriver<MobileElement> driver;

	Add_two_numbers twonumbers;
	Webapp webapp = new Webapp(Testbase.driver);
	Verticalswip verswip;

	@Given("^Launch the application in mobile \"([^\"]*)\"$")
	public void launch_the_application_in_mobile(String apptype) throws Throwable {
		Testbase.launchapp(apptype);
	}

	@Then("^Click on number seven$")
	public void click_on_number_seven() {
		twonumbers = new Add_two_numbers(Testbase.driver);

		twonumbers.setnumberseven();
	}

	@Then("^click on plus button$")
	public void click_on_plus_button()  {
		twonumbers.plus_button();
	}

	@Then("^click on number two$")
	public void click_on_number_two()  {
		twonumbers.setnumber();
	}

	@Then("^Click on equal button$")
	public void click_on_equal_button()  {
		twonumbers.equal_button();
	}

	@Then("^Pass the value as \"([^\"]*)\"$")
	public void pass_the_value_as(String appium) throws InterruptedException {
		webapp.text_box(appium);
		//driver.findElementByName("q").sendKeys("appium");
		Thread.sleep(2000);
	}

	@Then("^clickTab$")
	public void clicktab() {
		verswip = new Verticalswip(Testbase.driver);
		verswip.setviews();
	}

}
