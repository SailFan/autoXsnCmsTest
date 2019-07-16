package org.xsn.autotest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.xsn.autotest.common.PublicMethod;

public class HomePage extends PublicMethod {

	@FindBy(xpath = "/html/body/div[1]/section/header/div/div[1]/div[2]/ul/li[2]/a")
	WebElement logoutButton;

	@FindBy(css = "#app > section > header > div > div.el-row > div.el-col.el-col-8 > ul > li:nth-child(1) > a")
	WebElement modifyPasswordButton;

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

}
