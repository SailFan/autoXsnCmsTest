package org.xsn.autotest.testcase.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.xsn.autotest.common.PublicMethod;

public class NewTest {
	
	
	@Test
	void f1() {
		System.setProperty("webdriver.chrome.driver", "D:\\code\\autotestxsn\\autotest\\src\\main\\java\\org\\xsn\\autotest\\driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://test.admin.vocy.cn/#/login"); 
		driver.findElementByCssSelector("[type='text']").sendKeys("admin");
		driver.findElementByCssSelector("[type='password']").sendKeys("123456");
		driver.findElementByCssSelector("button:nth-of-type(1)").click();
//		List<WebElement> list = driver.findElementsByXPath("//aside/ul/li/div");
//		System.out.println(list.size());
//		for (WebElement webElement : list) {
//			webElement.click();
//		}
		By nav = By.xpath("/html/body/div/section/section/aside/ul/li[1]/div");
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(nav));
		WebElement element = driver.findElementByXPath("/html/body/div/section/section/aside/ul/li[1]/div");
		
		if (element == null) {
			
			System.out.println("Null");
		}
		element.click();
	}
}

