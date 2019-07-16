package org.xsn.autotest.testcase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xsn.autotest.page.ModifyPasswordPage;

public class TestModify {
	
	ChromeDriver brower;
	ModifyPasswordPage modifyPasswordPage;
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ikan\\Desktop\\driver\\chromedriver_win32\\chromedriver.exe");
		brower = new ChromeDriver();
		brower.get("http://test.admin.vocy.cn");
		brower.manage().window().maximize();
		modifyPasswordPage = new ModifyPasswordPage(brower);
	}
	
	
	
	@Test(groups = {"tp"})
	public void testModifySuccess() {
		
		
	}
}
