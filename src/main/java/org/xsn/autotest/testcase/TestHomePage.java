package org.xsn.autotest.testcase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.xsn.autotest.common.Util;
import org.xsn.autotest.page.HomePage;
import org.xsn.autotest.page.HomePage_2;
import org.xsn.autotest.page.LoginPage;

@Listeners({ org.xsn.autotest.common.listeners.OpenNavListener.class })
public class TestHomePage {
	private final static Logger logger = Logger.getLogger(TestHomePage.class);
	private WebDriver brower;
	private LoginPage loginPage;
	private HomePage homePage;
	HomePage_2 page_2;

	@BeforeClass(groups = { "check", "open.*" })
	public void setUp() {
		brower = Util.openBrower("chrome", null);
		loginPage = new LoginPage(brower);
		homePage = new HomePage(brower);
		page_2 = new HomePage_2();
		loginPage.loginToXsn("admin", "123456");
	}

	@AfterClass(groups = { "check", "open.*" })
	public void afterClass() {
//		brower.close();
	}

	@BeforeMethod(groups = { "correct" })
	public void beforeMethod() {
		logger.debug("zhixingle");
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
	@Ignore
	public void testOpenModifyPageSuccess() {
		homePage.myDDwait(10).until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("修改密码")));
		homePage.clickModifyButton();
		homePage.myDDwait(10).until(ExpectedConditions.titleIs("修改密码"));
		Assert.assertEquals("修改密码", homePage.currentPageTitle());
		Reporter.log("测试打开修改密码页面");
	}

	@Test(groups = { "correct" })
	@Ignore
	public void testLoginout() {
		homePage.myDDwait(10).until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("退出")));
		homePage.clickLogoutButton();
		homePage.myDDwait(10).until(ExpectedConditions.visibilityOf(homePage.confireLoginButton));
		homePage.confireLogout();
		homePage.myDDwait(10).until(ExpectedConditions.urlContains("http://test.admin.vocy.cn/#/home"));
		Assert.assertEquals(homePage.currentPageUrl(), "http://test.admin.vocy.cn/#/home");
		Reporter.log("测试退出按键");
	}

	@Test(groups = { "open_first_level_nav" })
	void testOPenAll() throws InterruptedException {
		List<WebElement> nav = page_2.getFirstStageNav();
		for (WebElement webElement : nav) {
			Thread.sleep(3);
			webElement.click();
		}
	}

	// 待审核列表页面
	@Test(groups = { "open_list_to_be_audited" }, dependsOnMethods = { "testOPenAll" })
	public void testClicktoBeAuditedList() {
		WebElement toBeAudited = page_2.getToAuditList();
		toBeAudited.click();
		Assert.assertEquals("运营后台内容审核列表", page_2.currentPageTitle());
		Reporter.log("内容审核列表测试通过");
	}

	// 内容列表
	@Test(groups = { "open_content_list" }, dependsOnMethods = { "testOPenAll" })
	public void testClickSecondLevelcontentList() {
		WebElement element = page_2.getContentList();
		element.click();
		Assert.assertEquals("运营后台内容管理列表", page_2.currentPageTitle());
		Reporter.log("运营后台内容管理列表测试通过");
	}

	// 内容推荐
	@Test(groups = { "open_content_recommendation" }, dependsOnMethods = { "testOPenAll" })
	public void testClickSecondLevelcontentListContentRecommendation() {
		WebElement webElement = page_2.getContentRecommendation();
		webElement.click();
		Assert.assertEquals("运营后台内容推荐列表", page_2.currentPageTitle());
		Reporter.log("运营后台内容推荐列表测试通过");
	}

	// 轮播图推荐
	@Test(groups = { "open_recommendation_of_rotary_planting_map" }, dependsOnMethods = { "testOPenAll" })
	public void testClickSecondLevelRecommendationOfRotaryPlantingMap() {
		WebElement slideShow = page_2.getSlideShow();
		slideShow.click();
		Assert.assertEquals("运营后台轮播图推荐列表", page_2.currentPageTitle());
	}

	// 热文章推荐
	@Test(groups = { "open_hot_article_recommendation" }, dependsOnMethods = { "testOPenAll" })
	public void testClickSecondLevelHotArticleRecommendation() {
		WebElement artcle = page_2.getHotArtcle();
		artcle.click();
		Assert.assertEquals("运营后台热文推荐列表", page_2.currentPageTitle());
	}

	// 热话题推荐

	@Test(groups = { "open_hot_topic_recommendation" }, dependsOnMethods = { "testOPenAll" })
	public void testClickSecondLevelHotTopicRecommendation() {
		WebElement topic = page_2.getHotTopic();
		topic.click();
		Assert.assertEquals("运营后台热话题推荐列表", page_2.currentPageTitle());
	}

	// 热校圈推荐
	@Test(groups = { "open_recommendation_of_hot_calibration_circle" }, dependsOnMethods = "testOPenAll")
	public void testClickSecondLevelRecommendationOfHotCalibrationCircle() {
		page_2.getHotSchool().click();
		Assert.assertEquals("运营后台名校圈推荐列表", page_2.currentPageTitle());
	}

	// 名师工作室推荐
	@Test(groups = { "open_teaching_studio" }, dependsOnMethods = "testOPenAll")
	public void testClickSecondLevelTeachingStudio() {
		page_2.getMasterStudio().click();
		Assert.assertEquals("运营后台名师工作室推荐列表", page_2.currentPageTitle());
	}

	// 推荐小记者
	@Test(groups = { "open_recommendation_by_Little_journalist" }, dependsOnMethods = "testOPenAll")
	public void testClickSecondLevelRecommendationByLittleJournalist() {
		page_2.getYoungReporter().click();
		Assert.assertEquals("运营后台小记者推荐列表", page_2.currentPageTitle());
	}

	// 待审核新建学校列表
	@Test(groups = { "open_new_schools_to_be_audited" }, dependsOnMethods = "testOPenAll")
	public void testClickSecondLevelNewSchoolsToBeAudited() {
		page_2.getSchoolToBeAudited().click();
		Assert.assertEquals("待审核学校列表", page_2.currentPageTitle());
	}

	// 学校列表
	@Test(groups = { "open_schools_List" }, dependsOnMethods = "testOPenAll")
	public void testClickSecondLevelSchoolsList() {
		page_2.getSchoolList().click();
		Assert.assertEquals("运营后台学校管理列表", page_2.currentPageTitle());
	}

	// 名师工作室列表
	@Test(groups = { "open_list_of_famous_teachers_studios" }, dependsOnMethods = "testOPenAll")
	public void testClickSecondLevelListOfFamousTeachersStudios() {
		page_2.getMasterStudioList().click();
		Assert.assertEquals(page_2.currentPageTitle(), "运营后台名师管理列表");
	}

	// 话题列表
	@Test(groups = { "open_topic_list" }, dependsOnMethods = "testOPenAll")
	public void testClickSecondLevelTopicList() {
		page_2.getTopicList().click();
		Assert.assertEquals(page_2.currentPageTitle(), "运营后台话题管理列表");
	}

	// 专题列表
	@Test(groups = { "open_list_of_topics" }, dependsOnMethods = "testOPenAll")
	public void testClickSecondLevelListOfTopics() {
		page_2.getSpecialList().click();
		Assert.assertEquals(page_2.currentPageTitle(), "运营后台内容管理列表");
	}

	// 小程序
	@Test(groups = { "open_small_procedures" }, dependsOnMethods = "testOPenAll")
	public void testClickSecondLevelSmallProcedures() {
		page_2.getMiniProgram().click();
		Assert.assertEquals(page_2.currentPageTitle(), "小程序专题列表");
	}

	// 站点管理
	@Test(groups = { "open_site_management" }, dependsOnMethods = "testOPenAll")
	public void testClickSecondLevelSiteManagement() {
		page_2.getSiteManage().click();
		Assert.assertEquals(page_2.currentPageTitle(), "运营后台用户管理列表");

	}

	// 内容频道管理
	@Test(groups = { "open_content_channel_management" }, dependsOnMethods = "testOPenAll")
	public void testClickSecondLevelContentChannelManagement() {
		page_2.getContentOfTheChannelManage().click();
		Assert.assertEquals(page_2.currentPageTitle(), "运营后台内容频道列表");

	}

	// 系统内容分类管理
	@Test(groups = { "open_system_content_classification_management" }, dependsOnMethods = "testOPenAll")
	public void testClickSecondLevelSystemContentClassificationManagement() {
		page_2.getSystemContentClassification().click();
		Assert.assertEquals(page_2.currentPageTitle(), "运营后台内容分类配置");
	}

	// 角色管理
	@Test(groups = { "open_role_management" }, dependsOnMethods = "testOPenAll")
	public void testClickSecondLevelRole_Management() {
		page_2.getRoleManage().click();
		Assert.assertEquals(page_2.currentPageTitle(), "角色管理列表");
	}

	// 用户管理
	@Test(groups = { "open_user_management" }, dependsOnMethods = "testOPenAll")
	public void testClickSecondLevelUserManagement() {
		page_2.getUserManage().click();
		Assert.assertEquals(page_2.currentPageTitle(), "运营后台用户管理列表");
	}

}
