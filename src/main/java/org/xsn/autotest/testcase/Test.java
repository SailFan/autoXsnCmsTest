package org.xsn.autotest.testcase;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.xsn.autotest.common.Util;

public class Test {
	ChromeDriver brower;
	
	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\code\\autotestxsn\\autotest\\src\\main\\java\\org\\xsn\\autotest\\driver\\chromedriver.exe");
		brower = new ChromeDriver();
	}
	@org.testng.annotations.Test
	@Ignore
	public void test1() {
		ChromeDriver brower = Util.openBrower("chrome");
		brower.get("http://demo.guru99.com/test/delete_customer.php");
		brower.findElement(By.name("cusid")).sendKeys("53920");					
		brower.findElement(By.name("submit")).submit();
		Alert alert = brower.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		System.out.println(text);
	}
	
	
	
	
	
	@org.testng.annotations.Test
	@Ignore
	public void test2() {
		System.setProperty("webdriver.chrome.driver","D:\\code\\autotestxsn\\autotest\\src\\main\\java\\org\\xsn\\autotest\\driver\\chromedriver.exe");
		ChromeDriver brower = new ChromeDriver();
		brower.manage().window().maximize();
		brower.get("http://demo.guru99.com/popup.php");
		brower.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		String mainWindow = brower.getWindowHandle();
		Set<String> handles = brower.getWindowHandles();
		Iterator<String> iterator = handles.iterator(); 
		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
			if(!mainWindow.equalsIgnoreCase(next)) {
				brower.switchTo().window(next);
				brower.findElement(By.name("emailid"))
                .sendKeys("gaurav.3n@gmail.com");
				brower.findElement(By.name("btnLogin")).click();
			}
		}
		 brower.switchTo().window("handles");
		
	}
	
	@org.testng.annotations.Test
	@Ignore
	public void test3() {
		System.setProperty("webdriver.chrome.driver","D:\\code\\autotestxsn\\autotest\\src\\main\\java\\org\\xsn\\autotest\\driver\\chromedriver.exe");
		
		brower.manage().window().maximize();
		brower.get("http://www.baidu.com");
	}
	
	@org.testng.annotations.Test
	public void  test4() {
		
		
		brower.get("http://www.baidu.com");
//		brower.navigate().to("http://test.admin.vocy.cn");
	}
	@org.testng.annotations.Test
	public void test5() {
		brower.get("http://test.site.vocy.cn");
		
	}
	
	
	
	
	
}
