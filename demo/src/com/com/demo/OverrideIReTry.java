package com.com.demo;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.log4testng.Logger;

public class OverrideIReTry implements IRetryAnalyzer {
	public static Logger logger = Logger.getLogger(OverrideIReTry.class);
	public int retryCount = 0;
	private static int maxRetryCount;
	static {
		// ��Χ�ļ�����������д�����ʧ�ܺ�����maxRetryCount+1��

		maxRetryCount = 2;// Ҳ����ʧ�ܺ�����3��
		logger.info("maxRunCount=" + (maxRetryCount));
	}

	@Override
	public boolean retry(ITestResult iTestResult) {
		if (retryCount <= maxRetryCount) {
			String message = "running retry for '" + iTestResult.getName() + "' on class " + this.getClass().getName()
					+ " Retrying " + retryCount + " times";
			logger.info(message);
			Reporter.setCurrentTestResult(iTestResult);
			Reporter.log("RunCount=" + (retryCount + 1));
			retryCount++;
			return true;
		}
		return false;
	}
}