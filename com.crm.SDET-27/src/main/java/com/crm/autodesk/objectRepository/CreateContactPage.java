package com.crm.autodesk.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{
	@FindBy(name="lastname")
	private WebElement contactLastNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img")
	private WebElement clickOnOrgNameLookUp;
	
	@FindBy(id="search_txt")
	private WebElement searchTxtEdt;
	
	@FindBy(name="search")
	private WebElement searchbtn;
	
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactLastNameEdt() {
		return contactLastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getClickOnOrgNameLookUp() {
		return clickOnOrgNameLookUp;
	}
	
	public void createContact(String contactName)
	{
		contactLastNameEdt.sendKeys(contactName);
		saveBtn.click();
	}
	public void createContactWithOrg(WebDriver driver,String contactName,String orgName)
	{
		contactLastNameEdt.sendKeys(contactName);
		clickOnOrgNameLookUp.click();
		switchToWindow(driver, "Accounts");
		searchTxtEdt.sendKeys(orgName);
		searchbtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();	
	}
		
}





