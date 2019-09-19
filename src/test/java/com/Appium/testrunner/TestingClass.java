package com.Appium.testrunner;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.testinium.deviceinformation.DeviceInfo;
import com.testinium.deviceinformation.DeviceInfoImpl;
import com.testinium.deviceinformation.device.DeviceType;
import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import com.testinium.deviceinformation.model.Device;

public class TestingClass {
	
	@Test
	public void testCode() throws IOException, DeviceNotFoundException
	{
		DeviceInfo deviceInfo = new DeviceInfoImpl(DeviceType.ALL);
		 
		Device device = deviceInfo.getFirstAndroidDevice();
		 
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PLATFORM, device.getDeviceProductName());
		capabilities.setCapability("platformName", device.getDeviceProductName());
		capabilities.setCapability(CapabilityType.VERSION, device.getProductVersion());
		capabilities.setCapability("deviceName", device.getModelNumber());
		capabilities.setCapability("udid", device.getUniqueDeviceID());
		capabilities.setCapability("app", "#Your App File#");
		 
		
	}

}
