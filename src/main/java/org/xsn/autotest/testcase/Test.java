package org.xsn.autotest.testcase;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	@org.testng.annotations.Test
	public void test() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ikan\\Desktop\\driver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://test.admin.vocy.cn");
		driver.findElementByXPath("/html/body/div/form/div[1]/div/div/input").sendKeys("java");
		System.out.println("shiyong getText"+driver.findElementByXPath("/html/body/div/form/div[1]/div/div/input").getText());
		System.out.println(driver.findElementByXPath("/html/body/div/form/div[1]/div/div/input").getAttribute("value").length());
	}
}
