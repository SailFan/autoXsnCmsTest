package org.xsn.autotest.testcase.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xsn.autotest.common.PublicMethod;

public class NewTest2 {
	
	@BeforeClass(groups = {"a"})
	public void beforeClass1() {
		System.out.println("beforeClass1");
	}
	
	@BeforeClass(groups = {"b"})
	public void beforeClass2() {
		System.out.println("beforeClass2");
	}
	
	@Test(groups = {"b"})
	public void test() {
		System.out.println("Test");
	}
}

