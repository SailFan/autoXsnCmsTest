package org.xsn.autotest.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.xsn.autotest.common.Util;

public class Test {
	ChromeDriver brower;

	@BeforeMethod
	public void setUp() {
		brower = Util.openBrower("chrome");
		/*
		 * System.setProperty("webdriver.chrome.driver", Path.getDir("chrome")); brower
		 * = new ChromeDriver(); brower.get("http://test.admin.vocy.cn");
		 * brower.manage().window().maximize();
		 */
	}

	@org.testng.annotations.Test
	public void test1() throws InterruptedException {
		brower.get("http://test.admin.vocy.cn");
		brower.findElement(By.cssSelector(
				"div.el-form-item:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)"))
				.sendKeys("admin");
		brower.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("123456");
		brower.findElement(By.cssSelector("button.el-button--primary:nth-child(1)")).click();
		new WebDriverWait(brower, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[1]/section/header/div/div[1]/div[2]/ul/li[1]/a")));
		brower.findElement(By.partialLinkText("修改密码")).click();

		brower.manage().wait(1000);

		brower.findElement(By.cssSelector(".header-right > li:nth-child(1) > a:nth-child(1)")).click();
	}

}
