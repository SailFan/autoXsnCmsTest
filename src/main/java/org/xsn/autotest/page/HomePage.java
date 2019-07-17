package org.xsn.autotest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.xsn.autotest.common.PublicMethod;

public class HomePage extends PublicMethod {

	@FindBy(xpath = "/html/body/div/section/header/div/div[1]/div[2]/ul/li[3]/a")
	WebElement logoutButton;

	@FindBy(css = "#app > section > header > div > div.el-row > div.el-col.el-col-8 > ul > li:nth-child(1) > a")
	WebElement modifyPasswordButton;

	@FindBy(xpath = "/html/body/div[2]/div/div[3]/button[2]")
	public WebElement confireLoginButton;

	@FindBy(xpath = "/html/body/div[2]/div/div[3]/button[1]")
	WebElement resetLoginButton;

	public HomePage(WebDriver webDriver) {
		super.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void clickLogoutButton() {
		logoutButton.click();
	}

	public void clickModifyButton() {
		modifyPasswordButton.click();
	}
	
	
	public void confireLogout() {
		confireLoginButton.click();
	}
	
	public void resetLogout() {
		resetLoginButton.click();
	} 
}
