package com.crm.autodesk.orgtest;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.genericUtility.BaseClass;
import com.crm.autodesk.genericUtility.ExcelUtility;
import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.JavaUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;
import com.crm.autodesk.objectRepository.CreateOrganizationPage;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.LoginPage;
import com.crm.autodesk.objectRepository.OrganizationsInfoPage;
import com.crm.autodesk.objectRepository.OrganizationsPage;

@Listeners(com.crm.autodesk.genericUtility.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass{
	
	@Test
	public void createOrganizationTest() throws Throwable {
		
		//getRandom Number
		int randomNum=jLib.getRanDomNumber();	
		
		//read test data from Excel file
		String orgName = eLib.getDataFromExcel("Sheet1",2,2) + randomNum;
		
		/*//Login
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);*/
		
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationsLnk();
		
		//Organization Page//LookUp
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrg();
		
		Assert.fail();
		
		//Create new Organization page
		CreateOrganizationPage cop= new CreateOrganizationPage(driver);
		cop.createOrg(orgName);
		
		//Verification
		OrganizationsInfoPage oip=new OrganizationsInfoPage(driver);
		String msg = oip.getOrganizationInfo();
		
		Assert.assertTrue(msg.contains(orgName));
		Reporter.log("Organization is created", true);
		
		//Logout
		//hp.logout(driver);
		//driver.close();
			
		/*//Verify organization name in header of the message
		String actSuc_msg = driver.findElement(By.className("dvHeaderText")).getText();
		if(actSuc_msg.contains(orgName)) {
			System.out.println("Organization is created..PASS");
		}else {
			System.out.println("Organization is not created..FAIL");
		}*/
	}
		@Test
		public void orgDemoTest()
		{
			System.out.println("Hello");
		}
	
}
