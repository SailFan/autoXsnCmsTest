package org.xsn.autotest.common;

public class Path {
	public static String getDir(String arg) {

		String rootPath = System.getProperty("user.dir");
		String driverBasePath = rootPath + "\\src\\main\\java\\org\\xsn\\autotest\\driver\\";
		String brower = null;

		switch (arg) {
		case "chrome":
			brower = "chromedriver.exe";
			break;
		case "firefox":
			break;
		default:
			brower = "chromedriver.exe";
			break;
		}

		String driverPath = driverBasePath + brower;
		return driverPath;
	}

	public static void main(String[] args) {
		System.out.println(getDir("c"));
	}
}
