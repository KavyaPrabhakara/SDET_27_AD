package com.crm.autodesk.contacttest;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.genericUtility.BaseClass;
import com.crm.autodesk.genericUtility.ExcelUtility;
import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.JavaUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;
import com.crm.autodesk.objectRepository.ContactsInfoPage;
import com.crm.autodesk.objectRepository.ContactsPage;
import com.crm.autodesk.objectRepository.CreateContactPage;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.LoginPage;

@Listeners(com.crm.autodesk.genericUtility.ListenerImplementation.class)
public class CreateContactTest extends BaseClass {
	@Test

	public void createContactTest() throws Throwable {
				
		//getRandom Number
		int randomNum=jLib.getRanDomNumber();
		
		//read test data from Excel file
		String contactName = eLib.getDataFromExcel("Sheet2",2,2) + randomNum;
		
		//Navigate to contact module(HomePage)
		HomePage hp= new HomePage(driver);
		hp.clickOnContactsLnk();
		
		//Click on create new Contact
		ContactsPage cp= new ContactsPage(driver);
		cp.clickOnCreateContact();
		
		Assert.fail();
		
		//Enter all details create an contact & Save
		CreateContactPage cop=new CreateContactPage(driver);
		cop.createContact(contactName);
		
		//Verification
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String msg = cip.getContactInfo();
		
		
		
		/*//Verify contact name in header of the message
		String actSuc_msg = driver.findElement(By.className("dvHeaderText")).getText();
		if(actSuc_msg.contains(contactName)) {
			System.out.println("Contact is created..PASS");
		}else {
			System.out.println("Contact is not created..FAIL");
		}*/
		
		/*//Logout
		wLib.mouseOverOnElement(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.close();*/
		
		//Logout
		//hp.logout(driver);
		//driver.close();
		
	}

}
