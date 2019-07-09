package org.xsn.autotest.common;

public class Path {
	public static String getDir(String args) {
		String rootPath = System.getProperty("user.dir");
		String driverBasePath = rootPath+"\\src\\main\\java\\org\\xsn\\autotest\\driver\\";
		String driverPath = driverBasePath+args;
		System.out.println(driverPath);
		return driverPath;
	}
}
