package org.xsn.autotest.page;
/**
 * @author ikan
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.xsn.autotest.common.PublicMethod;

public class LoginPage extends PublicMethod {

	@FindBy(css = "[type=\"text\"]")
	WebElement userNameInput;

	@FindBy(css = "[type=\'password\']")
	WebElement passWordInput;

	@FindBy(css = "button:nth-of-type(1)")
	WebElement loginButton;

	@FindBy(css = "button:nth-of-type(2)")
	WebElement resetButton;

	@FindBy(xpath = "//form/div[1]/div/div[2]")
	WebElement usernameTips;

	@FindBy(xpath = "//form/div[2]/div/div[2]")
	WebElement passwordTips;

	@FindBy(xpath = "//input[@type='text']")

	WebElement userNameValue;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passWordValue;

	@FindBy(css = ".el-message.el-message--error p")
	public WebElement alertMessage;

	public LoginPage(WebDriver webDriver) {
		super.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		// TODO Auto-generated constructor stub
	}

	public void setUserName(String userName) {

		userNameInput.sendKeys(userName);
	}

	public void setPassword(String passWord) {
		passWordInput.sendKeys(passWord);
	}

	public void loginButton() {
		loginButton.click();
	}

	public void resetButton() {
		resetButton.click();
	}

	public String getUserNameTips() {
		return usernameTips.getText();
	}

	public String getPassWordTips() {
		return passwordTips.getText();
	}

	public String getAlertMessage() {
		return alertMessage.getText();
	}

	public String getUserNameValue() {
		return userNameValue.getAttribute("value");
	}

	public String getPassWordValue() {
		return passWordValue.getAttribute("value");
	}

	public void loginToXsn(String username, String password) {
		this.setUserName(username);
		this.setPassword(password);
		this.loginButton();
	}
}
