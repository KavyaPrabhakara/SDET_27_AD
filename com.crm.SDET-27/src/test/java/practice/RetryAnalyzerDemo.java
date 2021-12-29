package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerDemo {
	
	@Test(retryAnalyzer=com.crm.autodesk.genericUtility.RetryAnalyzerImpl.class)
	public void retryAnalyzerDemoTest()
	{
		System.out.println("RetryAnalyzer");
		Assert.fail();
	}
}
