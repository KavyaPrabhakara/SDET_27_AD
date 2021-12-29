package com.crm.autodesk.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.genericUtility.BaseClass;
import com.crm.autodesk.genericUtility.ExcelUtility;
import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.JavaUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;
import com.crm.autodesk.objectRepository.ContactsInfoPage;
import com.crm.autodesk.objectRepository.ContactsPage;
import com.crm.autodesk.objectRepository.CreateContactPage;
import com.crm.autodesk.objectRepository.CreateOrganizationPage;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.LoginPage;
import com.crm.autodesk.objectRepository.OrganizationsPage;

@Listeners(com.crm.autodesk.genericUtility.ListenerImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass{
	
	@Test

	public void createContactWithOrganizationTest() throws Throwable {
		
		//getRandom Number
		int randomNum=jLib.getRanDomNumber();	
		
		//read test data from Excel file
		String orgName = eLib.getDataFromExcel("Sheet1",1,2) + randomNum;
		String contactName = eLib.getDataFromExcel("Sheet2",1,2);
		
		//Navigate to organization module
		HomePage hp= new HomePage(driver);
		hp.clickOnOrganizationsLnk();
		
		//Click on create organization
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrg();
		
		//Enter all details create an organization
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrg(orgName);
		
		//Wait for Element to be active
		WebElement headerWb = driver.findElement(By.className("dvHeaderText"));
        wLib.waitForElementToBeClickable(driver, headerWb);

		//Navigate to contact module
		hp.clickOnContactsLnk();
		
		Assert.fail();
		
		//Click on create contact
		ContactsPage cp= new ContactsPage(driver);
		cp.clickOnCreateContact();
		
		//Enter all details create an contact
		CreateContactPage cop1=new CreateContactPage(driver);
		
		cop1.createContactWithOrg(driver, contactName, orgName);
		
		ContactsInfoPage cip= new ContactsInfoPage(driver);
		String msg = cip.getContactInfo();	
		
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(msg.contains(contactName));
		sa.assertAll();
		
		
		//Click on add organization button
		//driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		/*String parentWindowHandle = driver.getWindowHandle();
		String parentTitle = driver.getTitle();
		Set<String> child = driver.getWindowHandles();
		System.out.println(child);
		for(String b:child)
		{
			driver.switchTo().window(b);
			if (!(driver.getTitle().equals(parentTitle))) 
			{
				break;
			}	
		}*/
		/*WebElement d = driver.findElement(By.id("search_txt"));
		d.sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(orgName)).click();
		
		driver.switchTo().window(parentWindowHandle);*/
		
		//Logout
		/*hp.logout(driver);
		driver.close();*/
	}
}
