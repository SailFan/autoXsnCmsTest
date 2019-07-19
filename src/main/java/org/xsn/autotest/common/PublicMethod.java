package org.xsn.autotest.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PublicMethod {
	public static WebDriver webDriver;
	
	/**
	 * 
	 * 待优化
	 * @return
	 */
//	public static WebDriver getDriver() {
//		if (webDriver == null) {
//			WebDriver webDriver ;
//			System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
//			webDriver = new FirefoxDriver();
//		}
//		 return webDriver;
//	}
	
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
	
	public static void snapImage() {
		String string = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot scrShot   = (TakesScreenshot)webDriver;
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(SrcFile, new File(System.getProperty("user.dir")+"//image//"+string+".png"));
			System.out.println(new File(System.getProperty("user.dir")+"//image//"+string+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
