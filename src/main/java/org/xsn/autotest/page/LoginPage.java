package org.xsn.autotest.page;
/**
 * @author ikan
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver webDeiver;

	@FindBy(css = "[type=\"text\"]")
	WebElement userNameInput;

	@FindBy(css = "[type=\'password\']")
	WebElement passWordInput;

	@FindBy(css = "button:nth-of-type(1)")
	WebElement loginButton;

	@FindBy(css = "button:nth-of-type(2)")
	WebElement resetButton;

	public LoginPage(WebDriver webDriver) {
		super();
		this.webDeiver = webDriver;
		PageFactory.initElements(webDriver, this);
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

	public String currentPageTitle() {
		return webDeiver.getTitle();
	}

	public void quitBrower() {
		webDeiver.quit();
	}
	
	public void maxWindows() {
		webDeiver.manage().window().maximize();
	}
	
	public void loginToXsn(String username, String password) {
		this.setUserName(username);
		this.setPassword(password);
		this.loginButton();
	}

}
