package org.xsn.autotest.common;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Util {

	public static WebDriver openBrower(String brow, String env) {
		WebDriver brower = null;

		if (env == null) {
			env = "testAdmin";
		}
		if (brow.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", getDir(brow));
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(Boolean.TRUE);
			brower = new ChromeDriver();
		} else if (brow.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.firefox.marionette", getDir(brow));
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(Boolean.TRUE);
			brower = new FirefoxDriver(options);
		}
		brower.get(getUrl(env));
		brower.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		brower.manage().window().maximize();
		return brower;
	}

	static String getDir(String arg) {
		String rootPath = System.getProperty("user.dir");
		String driverBasePath = rootPath + "\\src\\main\\java\\org\\xsn\\autotest\\driver\\";
		String brower = null;
		switch (arg) {
		case "Chrome":
			brower = "chromedriver.exe";
			break;
		case "Firefox":
			brower = "geckodriver.exe";
			break;
		default:
			brower = "chromedriver.exe";
			break;
		}
		String driverPath = driverBasePath + brower;
		return driverPath;
	}

	public static void main(String[] args) {
	}

	private static String getUrl(String url) {
		ResourceBundle bundle = ResourceBundle.getBundle("addr.res");
		String testurl = bundle.getString(url);
		return testurl;
	}

}
