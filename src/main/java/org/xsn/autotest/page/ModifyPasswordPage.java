package org.xsn.autotest.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.xsn.autotest.common.PublicMethod;

public class ModifyPasswordPage extends PublicMethod {

//	@FindBy(css="input")
//	List<WebElement> list;

	@FindBy(xpath = "//form/div[1]//input]")
	WebElement usernameInput;

//	旧密码
	@FindBy(xpath = "//form/div[2]//input")
	WebElement passwordOldInput;
//新密码
	@FindBy(xpath = "//form/div[3]//input")
	WebElement passwordNewInput1;
//确认新密码
	@FindBy(xpath = "//form/div[4]//input")
	WebElement passwordNewInput2;
//关闭按键
	@FindBy(xpath = "//button[2]")
	WebElement cancelButton;
//确认按键
	@FindBy(xpath = "//button[1]")
	WebElement confirmButton;
//旧密码提示
	@FindBy(xpath = "//form/div[2]//div[@class='el-form-item__error']")
	public WebElement oldPasswordTips;
//新密码提示
	@FindBy(xpath = "//form/div[3]//div[@class='el-form-item__error']")
	public WebElement newPasswordFirstTips;
//确定新密码提示信息
	@FindBy(xpath = "//form/div[4]//div[@class='el-form-item__error']")
	public WebElement newPasswordSecondTips;
//alert提示信息
	@FindBy(css = "div[role='alert']")
	public WebElement alertMessage;

	public ModifyPasswordPage(WebDriver webDriver) {
		super.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public String getAlertMessage() {
		return alertMessage.getText();
	}

	public void setPasswordOldInput(String oldPassword) {
		passwordOldInput.sendKeys(oldPassword);
	}

	public void setNewPasswordFirst(String newPassword) {
		passwordNewInput1.sendKeys(newPassword);
	}

	public void setNewPasswordSecond(String password) {
		passwordNewInput2.sendKeys(password);
	}

	public void clickLoginButton() {
		confirmButton.click();
	}

	public void resetInput() {
		cancelButton.click();

	}

	/**
	 * 获取用输入框的内容
	 * 
	 * @return
	 */
	public String getUsernameInputValue() {
		return usernameInput.getAttribute("value");
	}

	public String getOldPasswordInputValue() {
		return passwordOldInput.getAttribute("value");
	}

	public String getPasswordNewInput1Value() {
		return passwordNewInput1.getAttribute("value");
	}

	public String getPsswordNewInput2Value() {
		return passwordNewInput2.getAttribute("value");
	}

	public String getOldPasswordTips() {
		return oldPasswordTips.getText();
	}

	public String getNewPasswordFirstTips() {
		return newPasswordFirstTips.getText();
	}

	public String getNewPasswordSecondTips() {
		return newPasswordSecondTips.getText();
	}

	/**
	 * modify password
	 */

	public void modifyPassword(String oldPassword, String newPassword, String password) {
		this.setPasswordOldInput(oldPassword);
		this.setNewPasswordFirst(newPassword);
		this.setNewPasswordSecond(password);
		this.clickLoginButton();
	}

}
