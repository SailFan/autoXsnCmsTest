package org.xsn.autotest.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xsn.autotest.common.Util;
import org.xsn.autotest.page.HomePage;
import org.xsn.autotest.page.LoginPage;

public class TestHomePage {
	private WebDriver brower;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ikan\\Desktop\\driver\\chromedriver_win32\\chromedriver.exe");
		brower = new ChromeDriver();
		brower.get("http://test.admin.vocy.cn");
		brower.manage().window().maximize();
		loginPage = new LoginPage(brower);
		homePage = new HomePage(brower);
	}
	
	
	@Test
	public void testOpenModifyPageSuccess() {
		
		loginPage.loginToXsn("admin", "123456");
		homePage.clickModifyButton();
		homePage.myDDwait(10).until(ExpectedConditions.titleIs("修改密码"));
		Assert.assertEquals("修改密码", homePage.currentPageTitle());
	}
	
	
	
	
} 
