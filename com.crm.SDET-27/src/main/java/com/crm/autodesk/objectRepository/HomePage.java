package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	@FindBy(linkText="Organizations")
	private WebElement organizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLnk;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	
	public void clickOnOrganizationsLnk()
	{
		organizationsLnk.click();
	}
	public void clickOnContactsLnk()
	{
		contactsLnk.click();
	}
	public void logout(WebDriver driver)
	{
		mouseOverOnElement(driver, administratorImg);
		signoutLnk.click();
	}

	}

