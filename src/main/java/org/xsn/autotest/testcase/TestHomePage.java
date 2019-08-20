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
@Listeners({org.xsn.autotest.common.listeners.OpenNavListener.class})
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

	@AfterClass(groups = { "check", "open_page" })
	public void afterClass() {
		brower.close();
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
		homePage.myDDwait(10).until(ExpectedConditions.urlContains("http://test.admin.vocy.cn/#/home"));
		Assert.assertEquals(homePage.currentPageUrl(), "http://test.admin.vocy.cn/#/home");
		Reporter.log("测试退出按键");
	}

//	@Test(dependsOnMethods = "testOpenNavigation", groups = {"check"})
//	@Ignore
//	public void testCloseNavigation() {
//		logger.debug("全部关闭左侧导航栏");
//		brower.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		List<WebElement> list = page_2.getNavigation();
//		for (WebElement webElement : list) {
//			webElement.click();
//		}
//		WebElement element = brower.findElement(page_2.dSHWZLi);
//		Reporter.log("测试关闭左侧导航");
//	}
	
	//打開全部以及菜单
	@Test(groups = {"open_first_stage_nav"})
	void openFirstStageNav() {
		List<WebElement> list= page_2.getFirstStageNav();
		for (WebElement webElement : list) {
			webElement.click();
		}
	}
	
	

	// 待审核列表页面
	@Test(groups = {"open_list_to_be_audited" })
	public void testClickSecondLevelListtoBeAudited() {
//		page_2.toAuditList;
		new WebDriverWait(brower, 10).until(ExpectedConditions.titleContains("内容审核列表"));
		Assert.assertEquals("运营后台内容审核列表", brower.getTitle());
		Reporter.log("打开待审核文章列表页面");
	}
	/***	
	// 内容列表
	@Test(groups = {"open_content_list" })
	public void testClickSecondLevelcontentList() {
		logger.debug("打开内容列表测试用例开始执行");
		}
		Reporter.log("测试内容管理列表打开");
	}

	// 内容推荐
	@Test(groups = {"open_content_recommendation" })
	public void testClickSecondLevelcontentListContentRecommendation() {
		List<WebElement> elements = brower.findElements(page_2.secondLevel);
		for (int i = 0; i < elements.size(); i++) {
			if (i == 2) {
				elements.get(i).click();
			}
		}
	}

	// 轮播图推荐
	@Test(groups = {"open_recommendation_of_rotary_planting_map" })
	public void testClickSecondLevelRecommendationOfRotaryPlantingMap() {
		List<WebElement> elements = brower.findElements(page_2.secondLevel);
		for (int i = 0; i < elements.size(); i++) {
			if (i == 3) {
				elements.get(i).click();
			}
		}
	}

	// 热文章推荐
	@Test(groups = {"open_hot_article_recommendation" })
	public void testClickSecondLevelHotArticleRecommendation() {
		List<WebElement> elements = brower.findElements(page_2.secondLevel);
		for (int i = 0; i < elements.size(); i++) {
			if (i == 4) {
				elements.get(i).click();
			}
		}
	}

	// 热话题推荐
	@Test(groups = {"open_hot_topic_recommendation" })
	public void testClickSecondLevelHotTopicRecommendation() {
		List<WebElement> elements = brower.findElements(page_2.secondLevel);
		for (int i = 0; i < elements.size(); i++) {
			if (i == 5) {
				elements.get(i).click();
			}
		}
	}

	// 热校圈推荐
	@Test(groups = {"open_recommendation_of_hot_calibration_circle" })
	public void testClickSecondLevelRecommendationOfHotCalibrationCircle() {
		List<WebElement> elements = brower.findElements(page_2.secondLevel);
		for (int i = 0; i < elements.size(); i++) {
			if (i == 6) {
				elements.get(i).click();
			}
		}
	}

	// 名师工作室推荐
	@Test(groups = {"open_teaching_studio" })
	public void testClickSecondLevelTeachingStudio() {
		List<WebElement> elements = brower.findElements(page_2.secondLevel);
		for (int i = 0; i < elements.size(); i++) {
			if (i == 7) {
				elements.get(i).click();
			}
		}
	}

	// 推荐小记者
	@Test(groups = {"open_recommendation_by_Little_journalist" })
	public void testClickSecondLevelRecommendationByLittleJournalist() {
		List<WebElement> elements = brower.findElements(page_2.secondLevel);
		for (int i = 0; i < elements.size(); i++) {
			if (i == 8) {
				elements.get(i).click();
			}
		}
	}

	// 待审核新建学校列表
	@Test(groups = {"open_new_schools_to_be_audited" })
	public void testClickSecondLevelNewSchoolsToBeAudited() {
		List<WebElement> elements = brower.findElements(page_2.secondLevel);
		for (int i = 0; i < elements.size(); i++) {
			if (i == 9) {
				elements.get(i).click();
			}
		}
	}

	// 学校列表
	@Test(groups = {"open_schools_List" })
	public void testClickSecondLevelSchoolsList() {
		List<WebElement> elements = brower.findElements(page_2.secondLevel);
		for (int i = 0; i < elements.size(); i++) {
			if (i == 10) {
				elements.get(i).click();
			}
		}
	}

	// 名师工作室列表
	@Test(groups = {"open_list_of_famous_teachers_studios" })
	public void testClickSecondLevelListOfFamousTeachersStudios() {
		List<WebElement> elements = brower.findElements(page_2.secondLevel);
		for (int i = 0; i < elements.size(); i++) {
			if (i == 11) {
				elements.get(i).click();
			}
		}
	}

	// 话题列表
	@Test(groups = {"open_topic_list" })
	public void testClickSecondLevelTopicList() {
		List<WebElement> elements = brower.findElements(page_2.secondLevel);
		for (int i = 0; i < elements.size(); i++) {
			if (i == 12) {
				elements.get(i).click();
			}
		}
	}

	// 专题列表
	@Test(groups = {"open_list_of_topics" })
	public void testClickSecondLevelListOfTopics() {
		List<WebElement> elements = brower.findElements(page_2.secondLevel);
		for (int i = 0; i < elements.size(); i++) {
			if (i == 13) {
				elements.get(i).click();
			}
		}
	}

	// 小程序
	@Test(groups = {"open_small_procedures" })
	public void testClickSecondLevelSmallProcedures() {
		List<WebElement> elements = brower.findElements(page_2.secondLevel);
		for (int i = 0; i < elements.size(); i++) {
			if (i == 14) {
				elements.get(i).click();
			}
		}
	}

	// 站点管理
	@Test(groups = {"open_site_management" })
	public void testClickSecondLevelSiteManagement() {
		List<WebElement> elements = brower.findElements(page_2.secondLevel);
		for (int i = 0; i < elements.size(); i++) {
			if (i == 15) {
				elements.get(i).click();
			}
		}
	}

	// 内容频道管理
	@Test(groups = {"open_content_channel_management" })
	public void testClickSecondLevelContentChannelManagement() {
		List<WebElement> elements = brower.findElements(page_2.secondLevel);
		for (int i = 0; i < elements.size(); i++) {
			if (i == 16) {
				elements.get(i).click();
			}
		}
	}

	// 系统内容分类管理
	@Test(groups = {"open_system_content_classification_management" })
	public void testClickSecondLevelSystemContentClassificationManagement() {
		List<WebElement> elements = brower.findElements(page_2.secondLevel);
		for (int i = 0; i < elements.size(); i++) {
			if (i == 17) {
				elements.get(i).click();
			}
		}
	}

	// 角色管理
	@Test(groups = {"open_role_management" })
	public void testClickSecondLevelRole_Management() {
		List<WebElement> elements = brower.findElements(page_2.secondLevel);
		for (int i = 0; i < elements.size(); i++) {
			if (i == 18) {
				elements.get(i).click();
			}
		}
	}

	// 用户管理
	@Test(groups = {"open_user_management" })
	public void testClickSecondLevelUserManagement() {
		List<WebElement> elements = brower.findElements(page_2.secondLevel);
		for (int i = 0; i < elements.size(); i++) {
			if (i == 19) {
				elements.get(i).click();
			}
		}
	}
	*/

}
