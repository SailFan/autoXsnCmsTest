package org.xsn.autotest.page;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.xsn.autotest.common.PublicMethod;
import org.xsn.autotest.common.Util;

public class HomePage_2 extends PublicMethod {
	private final static Logger logger = Logger.getLogger(HomePage_2.class);
	WebDriver brower = null;
	By loginOut = By.partialLinkText("退出");
	By currentUser = By.cssSelector(".header-right li:nth-of-type(4)");
	By modifyPasswordButton = By.partialLinkText("修改密码");
	By Lis = By.cssSelector("li[role=\"menuitem\"]");

	public HomePage_2() {
		brower = Util.openBrower("chrome", null);
		super.webDriver = brower;
	}
	
	WebElement getNavigation(){
		List<WebElement> list = webDriver.findElements(Lis);
		return null;
	}
}
