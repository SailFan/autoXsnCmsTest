package org.xsn.autotest.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xsn.autotest.common.Util;
import org.xsn.autotest.page.HomePage_2;
import org.xsn.autotest.page.LoginPage;

public class TestHome {
	LoginPage page;
	WebDriver brower;
	@BeforeMethod
	public void beforeMethod(){} {
		brower = Util.openBrower("CHROME", null);
		page = new LoginPage(brower);
		page.loginToXsn("admin", "123456");
	}
	
	
	@Test
	public void test1() {
		HomePage_2 page_2 = new HomePage_2();
		WebElement element = page_2.getNavigation();
	}
	@AfterMethod
	public void afterMethod() {
//		brower.quit();
	}
}
