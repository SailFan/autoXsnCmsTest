package org.xsn.autotest.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xsn.autotest.common.Util;
import org.xsn.autotest.page.HomePage;
import org.xsn.autotest.page.LoginPage;
import org.xsn.autotest.page.ModifyPasswordPage;

public class TestModify {
	
	ChromeDriver brower;
	ModifyPasswordPage modifyPasswordPage;
	LoginPage liginpage;
	HomePage homePage;
	@BeforeClass
	public void setUp() {
		brower = Util.openBrower("chrome");
		modifyPasswordPage = new ModifyPasswordPage(brower);
		liginpage = new LoginPage(brower);
		homePage = new HomePage(brower);
	}

	@Test(groups = { "tp" })
	public void testModifySuccess() {
		liginpage.loginToXsn("admin", "123456");
		new WebDriverWait(brower, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[1]/section/header/div/div[1]/div[2]/ul/li[1]/a")));
		homePage.clickModifyButton();
		modifyPasswordPage.modifyPassword("123456", "1234567", "1234567");
		Assert.assertEquals(modifyPasswordPage.currentPageUrl(), "http://test.admin.vocy.cn/#/modifypwd?active=first", "修改密码返回登录首页");
	}
}
