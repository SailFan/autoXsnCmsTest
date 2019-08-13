package org.xsn.autotest.testcase;

import java.util.Iterator;
import java.util.LinkedList;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	
	@BeforeMethod(groups = "group1")
	public void BeforeMethod1() {
		System.out.println("group1");
	}
	@BeforeMethod(groups = {"group2"})
	public void BeforeMethod2() {
		System.out.println("group2");
	}

	@Test(groups = {"group1"})	
	public void f1() {
		System.out.println("f1");
	}

	@Test(groups = {"group2"})
	public void f() {
		System.out.println("f2");

	}
}
