package org.xsn.autotest.testcase;

import org.testng.annotations.Test;
import org.xsn.autotest.page.ModifyPasswordPage;

public class TestModify {
	
	@Test(groups = {"tp"})
	public void testModifySuccess() {
		ModifyPasswordPage page = new ModifyPasswordPage(webDriver);
		
		
	}
}
