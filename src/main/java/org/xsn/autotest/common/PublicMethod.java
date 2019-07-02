package org.xsn.autotest.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
//	悄悄的等待
	public void myQQWait(long time) {
		webDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
//	大胆的等待
	public WebDriverWait myDDwait(long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
		return wait;
	}
}
