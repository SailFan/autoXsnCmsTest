
package org.xsn.autotest.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.xsn.autotest.common.PublicMethod;

public class HomePage extends PublicMethod {
	private static final Logger logger = Logger.getLogger(HomePage.class);
	@FindBy(partialLinkText = "退出")
	WebElement logoutButton;

	@FindBy(css = ".header-right li:nth-of-type(4)")
	WebElement currentUser;

	@FindBy(xpath = "//ul/li[1]/a")

	public WebElement modifyPasswordButton;

	@FindBy(xpath = "/html/body/div/section/section/main/div/form/div[6]/div/button[1]")
	public WebElement confireLoginButton;

	@FindBy(xpath = "/html/body/div[2]/div/div[3]/button[1]")
	WebElement resetLoginButton;
	
//	待审核列表
	@FindBy(xpath="//aside/ul/li[1]/ul/li/ul/li[1]")
	public WebElement navFirst;
//	内容列表
	@FindBy(xpath = "//aside/ul/li[1]/ul/li/ul/li[2]")
	public WebElement contentList;
	
	public HomePage(WebDriver webDriver) {
		super.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void clickLogoutButton() {
		logoutButton.click();
	}

	public void clickModifyButton() {
		this.modifyPasswordButton.click();
	}

	public void confireLogout() {
		confireLoginButton.click();
	}

	public void resetLogout() {
		resetLoginButton.click();
	}
}
