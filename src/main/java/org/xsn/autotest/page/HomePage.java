package org.xsn.autotest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.xsn.autotest.common.PublicMethod;

public class HomePage extends PublicMethod{
	
	@FindBy(xpath = "/html/body/div[1]/section/header/div/div[1]/div[2]/ul/li[2]/a")
	WebElement logoutButton;
	
	@FindBy(xpath = "/html/body/div[1]/section/header/div/div[1]/div[2]/ul/li[1]/a")
	WebElement modifyPasswordButton;

	public HomePage(WebDriver webDriver) {
		super.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	
	
	void ClickLogoutButton() {
		logoutButton.click();
	}
	
	void ClickModifyButton() {
		modifyPasswordButton.click();
	}
	
	
	
}
