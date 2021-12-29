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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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
public class CreateOrgWithIndustries_TypeTest extends BaseClass{
	
	@Test
	

	public  void createOrgWithIndustries_TypeTest() throws Throwable {
	
		//getRandom Number
		int randomNum=jLib.getRanDomNumber();	
		
		//read test data from Excel file
		String orgName = eLib.getDataFromExcel("Sheet1",1,2) + randomNum;
		String industry = eLib.getDataFromExcel("Sheet1",1,3);
		String type = eLib.getDataFromExcel("Sheet1",1,4);
		
		Assert.fail();
		
		//Navigate to organization module
		HomePage hp= new HomePage(driver);
		hp.clickOnOrganizationsLnk();
		
		//Navigate to new organization 
		OrganizationsPage op= new OrganizationsPage(driver);
		op.clickOnCreateOrg();
		
		//Create an organization with mandatory fields
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrgWithIndustry(orgName, industry, type);
		
		//verification
		OrganizationsInfoPage oip= new OrganizationsInfoPage(driver);
		String msg = oip.getOrganizationInfo();
		if(msg.contains(industry)) {
			System.out.println("Industry is created..PASS");
		}else {
			System.out.println("Industry is not created..FAIL");
		}

	}

}
