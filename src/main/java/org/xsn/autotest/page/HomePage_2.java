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
	public By loginOut = By.partialLinkText("退出");
	public By currentUser = By.cssSelector(".header-right li:nth-of-type(4)");
	public By modifyPasswordButton = By.partialLinkText("修改密码");
	public By Lis = By.cssSelector("section>aside>ul>li");
	//待审核文章li
	public By dSHWZLi= By.xpath("/html/body/div[1]/section/section/aside/ul/li[1]/ul/li/ul/li[1]");
	//内容列表
	public By nRLBLi = By.xpath("/html/body/div[1]/section/section/aside/ul/li[1]/ul/li/ul/li[2]");
	
	public By secondLevel = By.cssSelector("li[tabindex=\"-1\"]");
	
	
	
//	public HomePage_2() {
//		brower = Util.openBrower("chrome", null);
//		super.webDriver = brower;
//	}
	
	//获取全部左侧导航
	public List<WebElement> getNavigation(){
		return webDriver.findElements(Lis);
	}
	
}
