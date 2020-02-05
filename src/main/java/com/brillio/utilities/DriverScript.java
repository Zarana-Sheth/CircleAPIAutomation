package com.brillio.utilities;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class DriverScript {

	public final static Logger logger = Logger.getLogger(DriverScript.class);
	public static Map<String, String> logMap;
	private static String alMID;
	public static Map<String, String> mapClassName;
	public static String testDataFile;
	public static ITestResult result;
	public static String rowNumber;
	public static Map<Integer, String> testsFailMap;
	public static String mobileMedium;
	public static String medium;

	public String browser1 = null;
	public static boolean parallel = false;
	public static ExtentReports extentReports;
	public static Map<String, Integer> testsExcelMap;
	public static String platform;
	public static boolean batchRun;

	/**
	 * @param propertyUtil
	 * @throws IOException
	 */

	public DriverScript(String almID) {
		DriverScript.alMID = almID;
		mapClassName = new HashMap<String, String>();
	}

	/**
	 * Sets the driver.
	 * 
	 * @param browser
	 *
	 * @param browserType
	 *            the new driver
	 * @throws DriverScriptException
	 */
	
	

	public static void logMessage(TestDriver testDriver, String logType, String msg) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
				logger.error(dateFormat.format(date) + " " + logType + msg);
			
			Reporter.log(dateFormat.format(date) + " " + logType + "<br/>");
	}

	/**
	 * Gets the classname.
	 *
	 * @param className
	 *            the class name
	 * @return the classname
	 */
	public static String getClassname(String className) {
		int counter = 0;
		for (int i = className.length() - 1; i > 0; i--) {
			if (className.charAt(i) == '.') {
				break;
			}
			counter = counter + 1;
		}
		className = className.substring(className.length() - counter, className.length());
		return className;
	}


	
	
}