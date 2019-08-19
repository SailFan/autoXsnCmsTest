package org.xsn.autotest.testcase;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestInjection {
	@DataProvider(parallel = true)
	public Object[][] createData(Method m){
		System.out.println(m.getName());
		return new Object[][] {
			new Object[] { "Cedric" },
			new Object[] { "Lwf" },
			new Object[] { "lwt" }
			
		};
		
	}
	
	@Test(dataProvider = "createData")
	public void test1(String s) {
		System.out.println(s);
		System.out.println(Thread.currentThread());
		System.out.println(Thread.activeCount());
	}
}
