package com.crm.autodesk.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
public class CreateOrganizationAssignmentTest extends BaseClass{

	@Test
	public void createOrganizationAssignmentTest() throws Throwable {
	
		//getRandom Number
		int randomNum=jLib.getRanDomNumber();	
		
		//read test data from Excel file
		String orgName = eLib.getDataFromExcel("Sheet1",2,2) + randomNum;
		
		//Navigate to organization module
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationsLnk();
		
		//Navigate to new organization 
		OrganizationsPage op= new OrganizationsPage(driver);
		op.clickOnCreateOrg();
		
		//Create an organization with mandatory fields
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrg(orgName);
		
		Assert.fail();
		
		//Verification
		OrganizationsInfoPage oip=new OrganizationsInfoPage(driver);
		String msg = oip.getOrganizationInfo();
		
		Assert.assertTrue(msg.contains(orgName));
		Reporter.log("Organization is created", true);
		
		
		
		/*
		//Verify organization name in header of the message
		String actSuc_msg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actSuc_msg.contains(orgName)) {
			System.out.println("Organization is created... PASS");
		}else {
			System.out.println("Organization is not created... FAIL");
		}
		
		//Logout
		wLib.mouseOverOnElement(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.close(); */
		
		//Logout
		/*hp.logout(driver);
		driver.close();*/
	
	}

}





