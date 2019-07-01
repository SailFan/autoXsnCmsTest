package org.xsn.autotest.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLoginPage {
	ChromeDriver brower;
	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ikan\\Desktop\\driver\\chromedriver_win32\\chromedriver.exe");
		brower = new ChromeDriver();
		brower.get("http://test.admin.vocy.cn");
		brower.manage().window().maximize();
	}
//	@Test
//	public void testTestng() {
//		LoginPage page = new LoginPage(brower);
////		System.out.println(page.currentPageTitle());
//		page.loginToXsn("admin", "123456");
//		System.out.println(page.currentPageTitle());
//	}
	@Test
	public void test1() throws InterruptedException {
		brower.get("http://test.admin.vocy.cn");
		brower.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(brower.getTitle());
		brower.findElementByCssSelector("[type='text']").sendKeys("admin");;
		brower.findElementByCssSelector("[type='password']").sendKeys("123456");;
		brower.findElementByCssSelector("button:nth-of-type(1)").click();
		System.out.println(brower.getTitle());
	}
	
}
