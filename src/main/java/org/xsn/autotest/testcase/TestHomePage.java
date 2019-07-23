package org.xsn.autotest.testcase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.xsn.autotest.common.Util;
import org.xsn.autotest.page.HomePage;
import org.xsn.autotest.page.HomePage_2;
import org.xsn.autotest.page.LoginPage;

public class TestHomePage {
	private final static Logger logger = Logger.getLogger(TestHomePage.class);
	private WebDriver brower;
	private LoginPage loginPage;
	private HomePage homePage;
	HomePage_2 page_2;

	@BeforeClass(groups = { "check" })
	public void setUp() {
		brower = Util.openBrower("chrome", null);
		loginPage = new LoginPage(brower);
		homePage = new HomePage(brower);
		page_2 = new HomePage_2();
		loginPage.loginToXsn("admin", "123456");
	}

	@AfterClass(groups = { "check" })
	public void afterClass() {
//		brower.close();
	}

	@BeforeMethod(groups = { "correct" })
	public void beforeMethod() {
		brower = Util.openBrower("chrome", null);
		loginPage = new LoginPage(brower);
		homePage = new HomePage(brower);
		loginPage.loginToXsn("admin", "123456");
	}

	@AfterMethod(groups = { "correct" })
	public void afterMethod() {
		brower.close();
	}

	@Test(groups = { "correct" })
	public void testOpenModifyPageSuccess() {
		homePage.myDDwait(10).until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("修改密码")));
		homePage.clickModifyButton();
		homePage.myDDwait(10).until(ExpectedConditions.titleIs("修改密码"));
		Assert.assertEquals("修改密码", homePage.currentPageTitle());
		Reporter.log("测试打开修改密码页面");
	}

	@Test(groups = { "correct" })
	public void testLoginout() {
		homePage.myDDwait(10).until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("退出")));
		homePage.clickLogoutButton();
		homePage.myDDwait(10).until(ExpectedConditions.visibilityOf(homePage.confireLoginButton));
		homePage.confireLogout();
		Assert.assertEquals(homePage.currentPageUrl(), "http://test.admin.vocy.cn/#/login");
		Reporter.log("测试退出按键");
	}

	@Test(groups = { "check" })
	public void testOpenNavigation() {
		logger.debug("打开左侧导航栏");
		brower.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> list = page_2.getNavigation();
		for (WebElement webElement : list) {
			webElement.click();
		}
		Reporter.log("测试打开左侧导航");
	}
	
	
	@Test(dependsOnMethods = "testOpenNavigation", groups = {"check"})
	@Ignore
	public void testCloseNavigation() {
		logger.debug("全部关闭左侧导航栏");
		brower.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> list = page_2.getNavigation();
		for (WebElement webElement : list) {
			webElement.click();
		}
//		WebElement element = brower.findElement(page_2.dSHWZLi);
		Reporter.log("测试关闭左侧导航");
	}
	
	

}
