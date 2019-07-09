package org.xsn.autotest.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xsn.autotest.page.LoginPage;

public class TestLoginPage {
	ChromeDriver brower;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ikan\\Desktop\\driver\\chromedriver_win32\\chromedriver.exe");
		brower = new ChromeDriver();
		brower.get("http://test.admin.vocy.cn");
		brower.manage().window().maximize();

	}

//	@Test
//	public void testLoginSuccess() throws InterruptedException {
//		LoginPage page = new LoginPage(brower);
//		page.loginToXsn("admin", "123456");
//		page.myDDwait(10).until(ExpectedConditions.titleIs("欢迎页"));
//		Assert.assertEquals("欢迎页", page.currentPageTitle());
//		page.closeBrower();
//	}

	@Test
	public void testLoginEmptyUsernameAndPassward() {
		LoginPage page = new LoginPage(brower);
		page.loginToXsn("admin", "asdfsfas");
		System.out.println(page.getAlertMessage());
	}

}