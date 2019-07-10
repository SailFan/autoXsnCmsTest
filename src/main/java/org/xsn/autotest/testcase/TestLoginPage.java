package org.xsn.autotest.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xsn.autotest.page.LoginPage;

public class TestLoginPage {
	ChromeDriver brower;

	@BeforeMethod(groups = { "tp", "check", "Unverified" })
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ikan\\Desktop\\driver\\chromedriver_win32\\chromedriver.exe");
		brower = new ChromeDriver();
		brower.get("http://test.admin.vocy.cn");
		brower.manage().window().maximize();

	}

	@Test(groups = { "tp", "check" })
	public void testLoginSuccess() throws InterruptedException {
		LoginPage page = new LoginPage(brower);
		page.loginToXsn("admin", "123456");
		page.myDDwait(10).until(ExpectedConditions.titleIs("欢迎页"));
		Assert.assertEquals("欢迎页", page.currentPageTitle());
	}

	@Test(groups = { "check" })
	public void testLoginEmptyUsernameAndPassward() {
		LoginPage page = new LoginPage(brower);
		page.loginToXsn("", "");
		Assert.assertEquals("请输入账号", page.getUserNameTips());
		Assert.assertEquals("请输入密码", page.getPassWordTips());
		page.closeBrower();
	}

	@Test(groups = { "check" })
	public void testErrorPassword() {
		LoginPage page = new LoginPage(brower);
		page.loginToXsn("admin", "dfafdsa");
		page.myDDwait(10).until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".el-message.el-message--error p")));
		Assert.assertEquals("登录密码验证失败", page.getAlertMessage());
		page.closeBrower();
	}

	@Test(groups = { "check" })
	public void testUserNameNonExistent() {
		LoginPage page = new LoginPage(brower);
		page.loginToXsn("admin1", "123456");
		page.myDDwait(10).until(
				ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".el-message.el-message--error p")));
		Assert.assertEquals("该账户不存在", page.getAlertMessage());
		page.closeBrower();
	}

	@Test(groups = { "check" })
	public void testCheckUpper() {
		LoginPage page = new LoginPage(brower);
		page.loginToXsn("Admin", "123456");
		page.myDDwait(10).until(ExpectedConditions.titleIs("欢迎页"));
		Assert.assertEquals("欢迎页", page.currentPageTitle());
		page.closeBrower();
	}

//	验证最大用户名输入
	@Test(groups = { "check", "Unverified" })
	public void testCheckMaxUserNameInput() {
		String userName = "0123456789001234567890";
		LoginPage page = new LoginPage(brower);
		page.loginToXsn(userName, "");
		Assert.assertEquals(page.getUserNameValue().length(), 15);
		page.closeBrower();
	}

//	验证最小密码输入
	@Test(groups = { "check", "Unverified" })
	public void testCheckMaxPasswordInput() {
		String passWord = "0123456789012345765746";
		LoginPage page = new LoginPage(brower);
		page.loginToXsn("admin", passWord);
		String passWordValue = page.getPassWordValue();
		System.out.println(passWordValue);
		Assert.assertEquals(15, passWordValue.length());
		page.closeBrower();
	}
}