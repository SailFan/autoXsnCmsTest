package org.xsn.autotest.page;
/**
 * @author ikan
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.xsn.autotest.common.PublicMethod;

public class LoginPage extends PublicMethod{


	@FindBy(css = "[type=\"text\"]")
	WebElement userNameInput;

	@FindBy(css = "[type=\'password\']")
	WebElement passWordInput;

	@FindBy(css = "button:nth-of-type(1)")
	WebElement loginButton;

	@FindBy(css = "button:nth-of-type(2)")
	WebElement resetButton;

//	public LoginPage(WebDriver webDriver) {
//		super();
//		this.webDriver = webDriver;
//		PageFactory.initElements(webDriver, this);
//	}
		
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
	
	public void loginToXsn(String username, String password) {
		this.setUserName(username);
		this.setPassword(password);
		this.loginButton();
	}
}
