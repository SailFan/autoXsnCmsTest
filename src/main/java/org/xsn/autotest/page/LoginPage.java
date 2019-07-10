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

	@FindBy(css = "div.el-form-item:nth-child(2) > div:nth-child(1) > div:nth-child(2)")
	WebElement usernameTips;
	
	@FindBy(css="div.el-form-item:nth-child(3) > div:nth-child(1) > div:nth-child(2)")
	WebElement passwordTips;
	
	@FindBy(xpath = "/html/body/div/form/div[1]/div/div/input")
	WebElement userNameValue;
	
	@FindBy(css="div.el-form-item:nth-child(3) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")
	WebElement passWordValue;
	
	
	@FindBy(css=".el-message.el-message--error p")
	WebElement alertMessage;
	
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
