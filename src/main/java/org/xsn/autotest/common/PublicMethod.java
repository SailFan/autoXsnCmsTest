package org.xsn.autotest.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.SimpleFormatter;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import bsh.This;

public class PublicMethod {
	public WebDriver webDriver;
	
	
	public String currentPageTitle() {
		return webDriver.getTitle();
	}
	public void quitBrower() {
		webDriver.quit();
	}
	
	public void maxWindows() {
		webDriver.manage().window().maximize();
	}
	
	public void closeBrower() {
		webDriver.close();
	}
	
	public String currentPageUrl() {
		return webDriver.getCurrentUrl();
	}
	
	
//	悄悄的等待
	public void myQQWait(long time) {
		webDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
//	大胆的等待
	public WebDriverWait myDDwait(long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
		return wait;
	}
	
	public void refreshPage() {
		webDriver.navigate().refresh();
	}
	
	public void snapImage() {
		Date date = new Date();
//		https://www.guru99.com/testng-execute-multiple-test-suites.html
		String string = new SimpleDateFormat("yyyyMMddhhmmss").format(date);
	}
}
