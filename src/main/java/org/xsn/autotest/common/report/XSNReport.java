package org.xsn.autotest.common.report;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.xml.XmlSuite;

public class XSNReport implements IReporter {

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		// suites包含所有测试的结果集
		for (ISuite iSuite : suites) {
//			获取单个套件的结果
			Map<String, ISuiteResult> results = iSuite.getResults();
//			获取map的键
			Set<String> keySet = results.keySet();
			for (String key : keySet) {
				// 编辑set集合， 根据key取value， 在从value中使用getTestContext()方法拿到ITestContext
				ITestContext context = results.get(key).getTestContext();
				// 打印套件的详细信息到控制台
				System.out.println("Suite Name-->" + context.getName() + "::Report output Ditectory-->"
						+ context.getOutputDirectory() + "::Suite Name->" + context.getSuite().getName()
						+ "::Start Date Time for execution->" + context.getStartDate()
						+ "::End Date Time for execution->" + context.getEndDate());

//				获取失败的方法的IResultMap
				IResultMap tests = context.getFailedTests();
				Collection<ITestNGMethod> methods = tests.getAllMethods();
				System.out.println("--------FAILED TEST CASE---------");
				for (ITestNGMethod failMethod : methods) {	
					//打印失败的测试用例的详细
					 System.out.println("TESTCASE NAME->"+failMethod.getMethodName()

                     +"\nDescription->"+failMethod.getDescription()

                     +"\nPriority->"+failMethod.getPriority()

                     +"\n:Date->"+new Date(failMethod.getDate()));

				}
			}
		}
	}

}
