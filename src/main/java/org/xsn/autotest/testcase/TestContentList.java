package org.xsn.autotest.testcase;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xsn.autotest.common.Util;
import org.xsn.autotest.page.HomePage_2;
import org.xsn.autotest.page.LoginPage;

public class TestContentList {
	private final static Logger logger = Logger.getLogger(TestContentList.class);
	HomePage_2 page2  = new HomePage_2();
	private LoginPage loginPage;
	WebDriver brower;
	@Test(groups = {"check"})
	public void f() {
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass(groups = {"check"})
	public void beforeClass() {
	}
	
	@BeforeTest
	public void beforeTest() {
		brower = Util.openBrower("chrome", null);
		loginPage = new LoginPage(brower);
		loginPage.loginToXsn("admin", "123456");
		page2.openFirstNav();
		page2.getContentList().click();
	}

	@AfterClass
	public void afterClass() {
		brower.close();
	}
	
	@AfterTest
	public void afterTest() {
		
	}
	
}
