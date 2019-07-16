package org.xsn.autotest.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class Test {
	ChromeDriver brower;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ikan\\Desktop\\driver\\chrome75\\chromedriver.exe");
		brower = new ChromeDriver();
		brower.get("http://test.admin.vocy.cn");
		brower.manage().window().maximize();
	}
	
	@org.testng.annotations.Test
	public void test1() throws InterruptedException {
		brower.get("http://test.admin.vocy.cn");
		brower.findElement(By.cssSelector("div.el-form-item:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")).sendKeys("admin");
		brower.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("123456");
		brower.findElement(By.cssSelector("button.el-button--primary:nth-child(1)")).click();
		
		
		brower.manage().wait(1000);
		
		
		brower.findElement(By.cssSelector(".header-right > li:nth-child(1) > a:nth-child(1)")).click();
	}
	
	
}
