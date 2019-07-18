package org.xsn.autotest.testcase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xsn.autotest.common.Util;
import org.xsn.autotest.page.HomePage;
import org.xsn.autotest.page.LoginPage;
import org.xsn.autotest.page.ModifyPasswordPage;

public class TestModify {
	ChromeDriver brower;
	ModifyPasswordPage modifyPasswordPage;
	LoginPage loginpage;
	HomePage homePage;

	@BeforeTest(alwaysRun = true)
	public void setUp() {
		brower = Util.openBrower("chrome");
		modifyPasswordPage = new ModifyPasswordPage(brower);
		loginpage = new LoginPage(brower);
		homePage = new HomePage(brower);
	}
	
	@BeforeClass(alwaysRun = true)
	void setUpClass(){
		loginpage.loginToXsn("wen", "123456");
		homePage.myDDwait(10).until(ExpectedConditions.visibilityOf(homePage.modifyPasswordButton));
		homePage.clickModifyButton();
	}

	@Test(groups = { "correct" })
	public void testModifySuccess() {
		modifyPasswordPage.modifyPassword("123456", "1234567", "1234567");
		Assert.assertEquals(modifyPasswordPage.currentPageUrl(), "http://test.admin.vocy.cn/#/modifypwd?active=first",
				"修改密码返回登录首页成成功");
	}
	
	
	@Test(groups = {"check"})
	public void testModifyPasswordEmtpy() {
		
//		homePage.myDDwait(10).until(ExpectedConditions.visibilityOf(homePage.modifyPasswordButton));
//		homePage.clickModifyButton();
		modifyPasswordPage.modifyPassword("1234567", "", "");
		modifyPasswordPage.myDDwait(10).until(ExpectedConditions.visibilityOf(modifyPasswordPage.newPasswordFirstTips));
		modifyPasswordPage.myDDwait(10).until(ExpectedConditions.visibilityOf(modifyPasswordPage.newPasswordSecondTips));
		Assert.assertEquals("请输入新密码", modifyPasswordPage.getNewPasswordFirstTips(), "请输入新密码");
		Assert.assertEquals("请确认新密码", modifyPasswordPage.getNewPasswordSecondTips(), "请确认新密码");
	}
	
	@Test(groups = {"check"})
	public void testResetButton() {
		modifyPasswordPage.setPasswordOldInput("123456");
		modifyPasswordPage.setNewPasswordFirst("12121");
		modifyPasswordPage.setNewPasswordSecond("asdf");
		modifyPasswordPage.resetInput();
		Assert.assertEquals("wen", modifyPasswordPage.getUsernameInputValue(), "断言回写名字是否为wen");
		Assert.assertEquals("", modifyPasswordPage.getOldPasswordInputValue(), "断言旧密码是否被重置");
		Assert.assertEquals("", modifyPasswordPage.getPasswordNewInput1Value(), "断言第一次输入新密码是否被重置");
		Assert.assertEquals("", modifyPasswordPage.getPsswordNewInput2Value(), "断言第二次输入的密码是否被重置");
	}
	
	@Test(groups = {"check"})
	public void testOnlyFirstNewPassword() {
		modifyPasswordPage.setPasswordOldInput("123456");
		modifyPasswordPage.setNewPasswordFirst("12121");
		Assert.assertEquals("wen", modifyPasswordPage.getUsernameInputValue(), "断言回写名字是否为wen");
		Assert.assertEquals("请确认新密码", modifyPasswordPage.getNewPasswordSecondTips(), "请确认新密码");
	}
	
	@Test(groups = {"check"})
	public void testOnlySecondNewPassword() {
		modifyPasswordPage.setPasswordOldInput("123456");
		modifyPasswordPage.setNewPasswordSecond("1234567");
		modifyPasswordPage.myDDwait(10).until(ExpectedConditions.visibilityOf(modifyPasswordPage.newPasswordFirstTips));
		modifyPasswordPage.myDDwait(10).until(ExpectedConditions.visibilityOf(modifyPasswordPage.newPasswordSecondTips));
		Assert.assertEquals("请输入新密码", modifyPasswordPage.getNewPasswordFirstTips(), "请输入新密码");
		Assert.assertEquals("两次输入密码不一致!", modifyPasswordPage.getNewPasswordSecondTips(), "两次输入密码不一致!");
	}
	
	@Test(groups = {"check"})
	public void testAtypismNewPassword() {
		modifyPasswordPage.setPasswordOldInput("123456");
		modifyPasswordPage.setNewPasswordSecond("1234567");
		modifyPasswordPage.setNewPasswordSecond("abcdfe");
		modifyPasswordPage.myDDwait(10).until(ExpectedConditions.visibilityOf(modifyPasswordPage.newPasswordSecondTips));
		Assert.assertEquals("两次输入密码不一致!", modifyPasswordPage.getNewPasswordSecondTips(), "两次输入密码不一致!");
	}
	
	@Test(groups = {"check"})
	public void testErrorOldPassword() {
		modifyPasswordPage.setPasswordOldInput("123456789");
		modifyPasswordPage.setNewPasswordSecond("1234567890");
		modifyPasswordPage.setNewPasswordFirst("1234567890");
//		等待alert弹窗出现， 断言旧密码验证错误
//		modifyPasswordPage.myDDwait(10).until(ExpectedConditions.visibilityOf(modifyPasswordPage.newPasswordSecondTips));
		Assert.assertEquals("旧密码验证错误", modifyPasswordPage.getNewPasswordSecondTips(), "旧密码验证错误");
	}
}
