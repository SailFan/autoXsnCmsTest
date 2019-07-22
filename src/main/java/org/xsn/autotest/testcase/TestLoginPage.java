package org.xsn.autotest.testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.xsn.autotest.common.Util;
import org.xsn.autotest.page.LoginPage;

public class TestLoginPage {
	private static final Logger logger = Logger.getLogger(TestLoginPage.class);
	WebDriver brower;

	@BeforeMethod(groups = { "correct", "check"})
	public void setUp() throws Exception {
		brower = Util.openBrower("chrome", null);
		logger.debug("浏览器初始化完成");
	}

	@Test(groups = { "correct"})
	public void testLoginSuccess() throws InterruptedException {
		logger.debug("testLoginSuccess method start");
		LoginPage page = new LoginPage(brower);
		page.loginToXsn("admin", "123456");
		page.myDDwait(10).until(ExpectedConditions.titleIs("欢迎页"));
		Assert.assertEquals("欢迎页", page.currentPageTitle());
		logger.debug("testLoginSuccess method end");
		Reporter.log("登录测试用例运行通过");
	}

	@Test(groups = { "check" })
	public void testLoginEmptyUsernameAndPassward() {
		logger.debug("testLoginEmptyUsernameAndPassward method start");
		LoginPage page = new LoginPage(brower);
		page.loginToXsn("", "");
		Assert.assertEquals("请输入账号", page.getUserNameTips());
		Assert.assertEquals("请输入密码", page.getPassWordTips());
		page.closeBrower();
		logger.debug("testLoginEmptyUsernameAndPassward method end");
		Reporter.log("用户名和密码都为空测试用例运行通过");
	}

	@Test(groups = { "check" })
	public void testErrorPassword() {
		logger.debug("testErrorPassword method start");
		LoginPage page = new LoginPage(brower);
		page.loginToXsn("admin", "dfafdsa");
		page.myDDwait(10).until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".el-message.el-message--error p")));
		Assert.assertEquals("登录密码验证失败", page.getAlertMessage());
		page.closeBrower();
		logger.debug("testErrorPassword method end");
		Reporter.log("错误密码测试用例运行通过");
	}

	@Test(groups = { "check" })
	public void testUserNameNonExistent() {
		logger.debug("testUserNameNonExistent method start");
		LoginPage page = new LoginPage(brower);
		page.loginToXsn("admin1", "123456");
		page.myDDwait(10).until(ExpectedConditions.visibilityOf(page.alertMessage));
		Assert.assertEquals("该账户不存在", page.getAlertMessage());
		page.closeBrower();
		logger.debug("testUserNameNonExistent method end");
		Reporter.log("用户名为空密码正确测试用例运行通过");
	}

	@Test(groups = { "check" })
	public void testCheckUpper() {
		logger.debug("testCheckUpper method start");
		LoginPage page = new LoginPage(brower);
		page.loginToXsn("Admin", "123456");
//		page.myDDwait(10).until(ExpectedConditions.titleIs("欢迎页"));
//		Assert.assertEquals("欢迎页", page.currentPageTitle());
		page.myDDwait(10).until(ExpectedConditions.visibilityOf(page.alertMessage));
		Assert.assertEquals("该账户不存在", page.getAlertMessage());
		page.closeBrower();
		logger.debug("testCheckUpper method end");
		Reporter.log("登录时用户名和密码区分大小写");
	}

//	验证最大用户名输入
	@Test(groups = { "check"})
	public void testCheckMaxUserNameInput() {
		logger.debug("testCheckMaxUserNameInput method start");
		String userName = "0123456789001234567890";
		LoginPage page = new LoginPage(brower);
		page.loginToXsn(userName, "");
		Assert.assertEquals(page.getUserNameValue().length(), 15);
		page.closeBrower();
		logger.debug("testCheckMaxUserNameInput method end");
	}

//	验证最小密码输入
	@Test(groups = { "check"})
	public void testCheckMaxPasswordInput() {
		logger.debug("testCheckMaxPasswordInput method start");
		String passWord = "0123456789012345765746";
		LoginPage page = new LoginPage(brower);
		page.loginToXsn("admin", passWord);
		String passWordValue = page.getPassWordValue();
		Assert.assertEquals(15, passWordValue.length());
		page.closeBrower();
		logger.debug("testCheckMaxPasswordInput method end");
	}
}