package com.crm.autodesk.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListenerImplementation implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		
		//Capture the method Name
		String methodName= result.getMethod().getMethodName();
		
		//Capture the current date
		String CurrentDate=new JavaUtility().getSystemDateWithFormate();
		
		//Capture the screenshot
		String screenShotName = methodName + "_" +CurrentDate;
		
		try {
			new WebDriverUtility().takeScreenshot(BaseClass.sdriver, screenShotName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
	}
	
}
