package org.xsn.autotest.testcase;

import org.openqa.selenium.By;
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
		brower = Util.openBrower("chrome");
		loginPage = new LoginPage(brower);
		homePage = new HomePage(brower);
	}

	@Test
	public void testOpenModifyPageSuccess() {
		loginPage.loginToXsn("admin", "123456");
		homePage.myDDwait(10).until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("修改密码")));
		homePage.clickModifyButton();
		homePage.myDDwait(10).until(ExpectedConditions.titleIs("修改密码"));
		Assert.assertEquals("修改密码", homePage.currentPageTitle());
	}

}
