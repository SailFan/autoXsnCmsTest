package org.xsn.autotest.testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {
	
	@BeforeMethod(groups = {"check"})
	public void bdforeMethod() {
		System.out.println("bdforeMethod method running");
		throw new RuntimeException("出异常了");
	}
	
	
	@Test(groups = "check", dependsOnMethods = "bdforeMethod")
	void f1(){
		System.out.println("F1 method running");
	}
}
