package org.xsn.autotest.testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.xsn.autotest.common.Util;
import org.xsn.autotest.page.HomePage;
import org.xsn.autotest.page.LoginPage;
import org.xsn.autotest.page.ModifyPasswordPage;

public class TestModify {
	private final static Logger logger = Logger.getLogger(TestModify.class);
	WebDriver brower;
	ModifyPasswordPage modifyPasswordPage;
	LoginPage loginpage;
	HomePage homePage;

	@BeforeClass(groups = { "correct", "check" })
	public void setUp() {
		brower = Util.openBrower("Chrome", null);
		modifyPasswordPage = new ModifyPasswordPage(brower);
		loginpage = new LoginPage(brower);
		homePage = new HomePage(brower);
		loginpage.loginToXsn("wen", "123456");
		homePage.myDDwait(10).until(ExpectedConditions.visibilityOf(homePage.modifyPasswordButton));
		homePage.clickModifyButton();
		modifyPasswordPage.refreshPage();
	}
	
	@org.testng.annotations.AfterClass
	public void AfterClass() {
		modifyPasswordPage.quitBrower();
	}

	/*
	 * @BeforeMethod(groups = { "correct", "check" }) public void beforeMethod() {
	 * brower = Util.openBrower("Chrome", null); modifyPasswordPage = new
	 * ModifyPasswordPage(brower); loginpage = new LoginPage(brower); homePage = new
	 * HomePage(brower); loginpage.loginToXsn("wen", "1234567");
	 * homePage.myDDwait(10).until(ExpectedConditions.visibilityOf(homePage.
	 * modifyPasswordButton)); homePage.clickModifyButton(); }
	 */
	/*
	 * @BeforeMethod public void beforeMethod() { modifyPasswordPage.refreshPage();
	 * 
	 * }
	 */

	@Test(groups = { "correct" })
	public void testModifySuccess() throws InterruptedException {
		logger.debug("testModifySuccess method start");
		modifyPasswordPage.myDDwait(10).until(ExpectedConditions.visibilityOf(modifyPasswordPage.confirmButton));
		modifyPasswordPage.modifyPassword("1234567", "123456", "123456");
		modifyPasswordPage.clickConfireModifyButton();
		Assert.assertEquals(modifyPasswordPage.currentPageUrl(), "http://test.admin.vocy.cn/#/modifypwd",
				"修改密码返回登录首页成成功");
		logger.debug("testModifySuccess method end");
		Reporter.log("修改密碼成功");
	}

	@Test(groups = { "check" })
	public void testModifyPasswordEmtpy() {
		logger.debug("testModifyPasswordEmtpy method start");
		modifyPasswordPage.refreshPage();
		modifyPasswordPage.modifyPassword("123456", "", "");
		modifyPasswordPage.clickConfireModifyButton();
		modifyPasswordPage.myDDwait(10).until(ExpectedConditions.visibilityOf(modifyPasswordPage.newPasswordFirstTips));
		modifyPasswordPage.myDDwait(10)
				.until(ExpectedConditions.visibilityOf(modifyPasswordPage.newPasswordSecondTips));
		Assert.assertEquals("请输入新密码", modifyPasswordPage.getNewPasswordFirstTips(), "请输入新密码");
		Assert.assertEquals("请确认新密码", modifyPasswordPage.getNewPasswordSecondTips(), "请确认新密码");
		logger.debug("testModifyPasswordEmtpy method end");
		Reporter.log("测试能否改成空密码");
	}

	@Test(groups = { "check" })
	public void testResetButton() {
		logger.debug("testResetButton method start");
		modifyPasswordPage.refreshPage();
		modifyPasswordPage.modifyPassword("123456", "12121", "asdf");
		modifyPasswordPage.clickConfireModifyButton();
		modifyPasswordPage.resetInput();
		Assert.assertEquals("wen", modifyPasswordPage.getUsernameInputValue(), "断言回写名字是否为wen");
		Assert.assertEquals("", modifyPasswordPage.getOldPasswordInputValue(), "断言旧密码是否被重置");
		Assert.assertEquals("", modifyPasswordPage.getPasswordNewInput1Value(), "断言第一次输入新密码是否被重置");
		Assert.assertEquals("", modifyPasswordPage.getPsswordNewInput2Value(), "断言第二次输入的密码是否被重置");
		logger.debug("testResetButton method end");
		Reporter.log("测试重置按键");
	}

	@Test(groups = { "check" })
	public void testOnlyFirstNewPassword() {
		logger.debug("testOnlyFirstNewPassword method start");
		modifyPasswordPage.refreshPage();
		modifyPasswordPage.modifyPassword("123456", "12121", "");
		modifyPasswordPage.clickConfireModifyButton();
		Assert.assertEquals("wen", modifyPasswordPage.getUsernameInputValue(), "断言回写名字是否为wen");
		Assert.assertEquals("请确认新密码", modifyPasswordPage.getNewPasswordSecondTips(), "请确认新密码");
		logger.debug("testOnlyFirstNewPassword method end");
		Reporter.log("测试只输入一次密码是否可以修改密码");
	}

	@Test(groups = { "check" })
	public void testOnlySecondNewPassword() {
		logger.debug("testOnlySecondNewPassword method start");
		modifyPasswordPage.refreshPage();
		modifyPasswordPage.modifyPassword("123456", "", "1234567");
		modifyPasswordPage.clickConfireModifyButton();
		modifyPasswordPage.myDDwait(10).until(ExpectedConditions.visibilityOf(modifyPasswordPage.newPasswordFirstTips));
		modifyPasswordPage.myDDwait(10)
				.until(ExpectedConditions.visibilityOf(modifyPasswordPage.newPasswordSecondTips));
		Assert.assertEquals("请输入新密码", modifyPasswordPage.getNewPasswordFirstTips(), "请输入新密码");
		Assert.assertEquals("两次输入密码不一致!", modifyPasswordPage.getNewPasswordSecondTips(), "两次输入密码不一致!");
		logger.debug("testOnlySecondNewPassword method end");
		Reporter.log("测试只输入第二次密码");
	}

	@Test(groups = { "check" })
	public void testAtypismNewPassword() {
		logger.debug("testAtypismNewPassword method start");
		modifyPasswordPage.refreshPage();
		modifyPasswordPage.modifyPassword("123456", "1234567", "abcdfe");
		modifyPasswordPage.clickConfireModifyButton();
		modifyPasswordPage.myDDwait(10)
				.until(ExpectedConditions.visibilityOf(modifyPasswordPage.newPasswordSecondTips));
		Assert.assertEquals("两次输入密码不一致!", modifyPasswordPage.getNewPasswordSecondTips(), "两次输入密码不一致!");
		logger.debug("testAtypismNewPassword method end");
		Reporter.log("测试两次的密码输入不一致");
	}

	@Test(groups = { "check" })
	public void testErrorOldPassword() {
		logger.debug("testErrorOldPassword method start");
		modifyPasswordPage.refreshPage();
		modifyPasswordPage.modifyPassword("123456789", "1234567890", "1234567890");
		modifyPasswordPage.clickConfireModifyButton();
		modifyPasswordPage.myDDwait(10).until(ExpectedConditions.visibilityOf(modifyPasswordPage.alertMessage));
		Assert.assertEquals("旧密码验证错误", modifyPasswordPage.getAlertMessage(), "旧密码验证错误");
		logger.debug("testErrorOldPassword method end");
		Reporter.log("测试旧密码输入错误");
	}
}
