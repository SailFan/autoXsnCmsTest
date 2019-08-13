package org.xsn.autotest.common.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.xsn.autotest.common.PublicMethod;

public class XSNTestListener implements ITestListener{
	private final static Logger logger = Logger.getLogger(XSNTestListener.class);
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("onTestFailure("+result+")");
		PublicMethod.snapImage();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test start");
	}

	@Override
	public void onFinish(ITestContext context) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	logger.debug("没什么想干的， 就是等待3s");
		
	}
	
}
