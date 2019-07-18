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
	public WebElement oldPasswordTips;

	@FindBy(xpath = "/html/body/div/section/section/main/div/div/div[2]/div[1]/form/div[3]/div/div[2]")
	public WebElement newPasswordFirstTips;

	@FindBy(xpath = "/html/body/div/section/section/main/div/div/div[2]/div[1]/form/div[4]/div/div[2]")
	public WebElement newPasswordSecondTips;

	public ModifyPasswordPage(WebDriver webDriver) {
		super.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
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

	void clickLoginButton() {
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
