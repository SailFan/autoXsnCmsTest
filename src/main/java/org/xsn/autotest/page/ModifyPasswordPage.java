package org.xsn.autotest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.xsn.autotest.common.PublicMethod;

public class ModifyPasswordPage extends PublicMethod {

	@FindBy(xpath = "/html/body/div[1]/section/section/main/div/form/div[2]/div/div/input")
	WebElement usernameInput;
	
	@FindBy(xpath="/html/body/div[1]/section/section/main/div/div/div[2]/div[1]/form/div[2]/div/div[1]/input")
	WebElement passwordOldInput;

	@FindBy(xpath = "/html/body/div[1]/section/section/main/div/div/div[2]/div[1]/form/div[3]/div/div/input")
	WebElement passwordNewInput1;

	@FindBy(xpath = "/html/body/div[1]/section/section/main/div/div/div[2]/div[1]/form/div[4]/div/div[1]/input")
	WebElement passwordNewInput2;

	@FindBy(xpath = "/html/body/div[1]/section/section/main/div/form/div[6]/div/button[2]")
	WebElement cancelButton;

	@FindBy(xpath = "/html/body/div[1]/section/section/main/div/div/div[2]/div[1]/form/div[5]/div/button[1]")
	WebElement confirmButton;

	@FindBy(xpath = "/html/body/div[1]/section/section/main/div/form/div[3]/div/div[2]")
	WebElement oldPasswordTips;

	@FindBy(xpath = "/html/body/div[1]/section/section/main/div/form/div[4]/div/div[2]")
	WebElement newPasswordFirstTips;

	@FindBy(xpath = "/html/body/div[1]/section/section/main/div/form/div[5]/div/div[2]")
	WebElement newPasswordSecondTips;

	public ModifyPasswordPage(WebDriver webDriver) {
		super.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	void setPasswordOldInput(String oldPassword) {
		passwordOldInput.sendKeys(oldPassword);
	}

	void setNewPasswordFirst(String newPassword) {
		passwordNewInput1.sendKeys(newPassword);
	}

	void setNewPasswordSecond(String password) {
		passwordNewInput2.sendKeys(password);
	}

	void clickLoginButton() {
		confirmButton.click();
	}

	void resetInput() {
		cancelButton.click();

	}

	/**
	 * 获取用输入框的内容
	 * 
	 * @return
	 */
	String getUsernameInputValue() {
		return usernameInput.getAttribute("value");
	}

	String getOldPasswordInputValue() {
		return passwordOldInput.getAttribute("value");
	}

	String getPasswordNewInput1Value() {
		return passwordNewInput1.getAttribute("value");
	}

	String getPsswordNewInput2Value() {
		return passwordNewInput2.getAttribute("value");
	}

	String getOldPasswordTips() {
		return oldPasswordTips.getText();
	}

	String getNewPasswordFirstTips() {
		return newPasswordFirstTips.getText();
	}

	String getNewPasswordSecondTips() {
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
