package org.xsn.autotest.page;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.xsn.autotest.common.PublicMethod;

public class HomePage_2 extends PublicMethod {
	private final static Logger logger = Logger.getLogger(HomePage_2.class);
	WebDriver brower = null;
//	退出按键
	public By loginOut = By.partialLinkText("退出");
//	当前用户
	public By currentUser = By.cssSelector(".header-right li:nth-of-type(4)");
//	修改密码按键
	public By modifyPasswordButton = By.partialLinkText("修改密码");
//	二级菜单
	public By navSecond = By.cssSelector("li[tabindex=\"-1\"]");
//一级菜单
	By navFirst = By.xpath("//aside/ul/li");
	// 待审核列表
	By toAuditList = By.xpath("//aside/ul/li[1]/ul/li/ul/li[1]");
	// 内容列表
	By contentList = By.xpath("//aside/ul/li[1]/ul/li/ul/li[2]");
	// 内容推荐
	By contentRecommendation = By.xpath("//aside/ul/li[2]/ul/li/ul/li[1]");
	// 轮播图管理
	By slideShow = By.xpath("//aside/ul/li[2]/ul/li/ul/li[2]");
	// 热文章推荐
	By hotArtcle = By.xpath("//aside/ul/li[2]/ul/li/ul/li[3]");
	// 热话题推荐
	By hotTopic = By.xpath("//aside/ul/li[2]/ul/li/ul/li[4]");
	// 热校区推荐
	By hotSchool = By.xpath("//aside/ul/li[2]/ul/li/ul/li[5]");
	// 名师工作室
	By masterStudio = By.xpath("//aside/ul/li[2]/ul/li/ul/li[6]");
//	小记者推荐
	By youngReporter = By.xpath("//aside/ul/li[3]/ul/li/ul/li[1]");
//	待审核新建学校列表
	By SchoolToBeAudited = By.xpath("//aside/ul/li[3]/ul/li/ul/li[1]");
//	学校列表
	By schoolList = By.xpath("//aside/ul/li[3]/ul/li/ul/li[2]");
//	公众号列表
	By officialAccounts = By.xpath("//aside/ul/li[3]/ul/li/ul/li[3]");
//	名师工作室
	By masterStudioList = By.xpath("//aside/ul/li[4]/ul/li/ul/li");
//	话题列表
	By topicList = By.xpath("//aside/ul/li[5]/ul/li/ul/li");
//	专题列表
	By specialList = By.xpath("//aside/ul/li[6]/ul/li/ul/li[1]");
//	小程序列表
	By miniProgram = By.xpath("//aside/ul/li[6]/ul/li/ul/li[2]");
	// 专辑列表
	By albumList = By.xpath("//aside/ul/li[7]/ul/li/ul/li");
//	站点管理
	By siteManage = By.xpath("//aside/ul/li[8]/ul/li/ul/li[1]");
//	内容频道管理
	By ContentOfTheChannelManage = By.xpath("//aside/ul/li[8]/ul/li/ul/li[2]");
//	系统内容分类
	By SystemContentClassification = By.xpath("//aside/ul/li[8]/ul/li/ul/li[3]");
//	角色管理
	By roleManage = By.xpath("//aside/ul/li[8]/ul/li/ul/li[4]");
//	用户管理
	By userManage = By.xpath("//aside/ul/li[8]/ul/li/ul/li[5]");

	// 获取全部二级导航菜单
	public List<WebElement> getNavigation() {
		List<WebElement> elements = webDriver.findElements(navSecond);
		return elements;
	}

//	获取一级导航菜单
	public List<WebElement> getFirstStageNav() {
		List<WebElement> list = webDriver.findElements(this.navFirst);
		return list;
	}
}
