package org.xsn.autotest.testcase.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameters {
	
	@Parameters("brower")
	@BeforeMethod
	public void setUp(@Optional("encode") String brower){
		System.out.println(brower);
	}
		
	
	@Parameters({"name","age"})
	@Test
	public void testSingleString(String name, String age) {
		System.out.println(name);
		System.out.println(age);
	}
	
	
}
