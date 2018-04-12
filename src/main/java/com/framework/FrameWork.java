package com.framework;

import org.openqa.selenium.WebDriver;

public class FrameWork {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		FrameWork.driver = driver;
	}

}
