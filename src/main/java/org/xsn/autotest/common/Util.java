package org.xsn.autotest.common;

import org.openqa.selenium.chrome.ChromeDriver;

public class Util {

	public static ChromeDriver openBrower(String brow) {
		System.setProperty("webdriver.chrome.driver",Path.getDir(brow));
		ChromeDriver brower = new ChromeDriver();
		brower.get("http://test.admin.vocy.cn");
		brower.manage().window().maximize();
		return brower;
	}
}
