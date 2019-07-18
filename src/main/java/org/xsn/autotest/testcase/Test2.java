package org.xsn.autotest.testcase;

import org.testng.annotations.Test;

public class Test2 {
	@org.testng.annotations.Test
	public void test1() {
		System.out.println("test method 1 run ");
	}

	@Test
	public void test2() {
		System.out.println("test method 2 run ");
	}

	@Test(groups = {"group2"})
	public void test4() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("test method 3 run ");
	}

	@Test(groups = {"group2"})
	public void test5() {
		System.out.println("test method 4 run ");
	}

	@Test(groups = {"group2"})
	public void test6() {
		System.out.println("test method 5 run ");
	}

	@Test(groups = {"group2"})
	public void test7() {
		System.out.println("test method 6 run ");
	}

	@Test(groups = "group3")
	public void test8() {
		System.out.println("test method 7 run ");
		System.out.println("test group3 run ");
	}
}
