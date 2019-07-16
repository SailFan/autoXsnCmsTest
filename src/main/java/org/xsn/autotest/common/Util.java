package org.xsn.autotest.common;

import org.openqa.selenium.chrome.ChromeDriver;

public class Util {
	
	public static ChromeDriver openBrower() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ikan\\Desktop\\driver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver brower = new ChromeDriver();
		brower.get("http://test.admin.vocy.cn");
		brower.manage().window().maximize();
		return brower;
	}
}
