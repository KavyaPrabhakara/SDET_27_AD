package com.crm.autodesk.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImpl implements IRetryAnalyzer{
	
	int count=0;
	int retrycount=4;
	public boolean retry(ITestResult result) {	
		while(count<retrycount)
		{
			count++;
			return true;
		}
		return false;
	}
	
}

