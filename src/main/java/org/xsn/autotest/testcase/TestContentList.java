package org.xsn.autotest.testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xsn.autotest.common.Util;
import org.xsn.autotest.page.ContentListPage;
import org.xsn.autotest.page.HomePage_2;
import org.xsn.autotest.page.LoginPage;

public class TestContentList {
	private final static Logger logger = Logger.getLogger(TestContentList.class);
	HomePage_2 page2  = new HomePage_2();
	ContentListPage contentList = new ContentListPage();
	private LoginPage loginPage;
	WebDriver brower;
	
	@Test(groups = {"check"})
	public void testClickAddArtcle() {
		contentList.clickAddArtcle();
		Assert.assertEquals(contentList.currentPageTitle(), "运营后台增加编辑文章");
		Reporter.log("打开新增文章页面测试通过");
	}


	@BeforeClass(groups = {"check"})
	public void beforeClass() {
		
	}
	
	@BeforeTest(groups = {"check"})
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
