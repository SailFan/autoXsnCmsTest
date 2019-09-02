package org.xsn.autotest.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xsn.autotest.common.Util;
import org.xsn.autotest.page.ContentListPage;
import org.xsn.autotest.page.HomePage_2;
import org.xsn.autotest.page.LoginPage;
import org.xsn.autotest.page.content.AddArticle;

public class TestAddArticle {
	
	HomePage_2 page2  = new HomePage_2();
	ContentListPage contentList = new ContentListPage();
	private LoginPage loginPage;
	WebDriver brower;
	AddArticle addArticle;

	@BeforeClass(groups = {"check"})
	public void beforeClass() {
		brower = Util.openBrower("chrome", null);
		addArticle = new AddArticle(brower);
		loginPage = new LoginPage(brower);
		loginPage.loginToXsn("admin", "123456");
		page2.openFirstNav();
		page2.getContentList().click();
		contentList.clickAddArtcle();
	} 
	
	
//	@Test(groups = {"check"})
//	public void test() {
//		addArticle.setSite();
//		addArticle.myDDwait(10).until(ExpectedConditions.visibilityOf(addArticle.siteHome));
//		addArticle.setSiteHome();
//		Assert.assertEquals(addArticle.currentPageTitle(), "运营后台增加编辑文章");
//		System.out.println(addArticle.siteHome+"siteHome");
//	}
	
	@Test(groups = {"check"})
	public void test1() {
		addArticle.setContentType();
		addArticle.getContentOptions("公益");
	}
	
	
	@AfterClass
	public void afterClass() {
		
	} 
}
