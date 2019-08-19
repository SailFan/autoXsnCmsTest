package org.xsn.autotest.common;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClas {
	ChromeDriver brower; 
	
	@BeforeMethod
	public void test1() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\codecms\\autoXsnCmsTest\\src\\main\\java\\org\\xsn\\autotest\\driver\\chromedriver.exe");
		brower = new ChromeDriver();
		brower.get("http://test.site.vocy.cn");
		brower.manage().window().maximize();
	}
	
	@Test
	public void test2(){
		String handle = brower.getWindowHandle();
		System.out.println(handle);
		brower.findElementByXPath("//div[2]/div/div[1]/div[2]/div[1]/div/div/div[1]/a/dl/dd/img").click();
		Set<String> windowHandles = brower.getWindowHandles();
		for (String string : windowHandles) {
			System.out.println(string);
		}
		brower.switchTo().window("windowHandles");
		
	}
}
