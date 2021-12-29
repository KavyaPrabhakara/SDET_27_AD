package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {
	@FindBy(name="accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgEdt() {
		return organizationNameEdt;
	}

	public WebElement getIndustryDropown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business library
	public void createOrg(String orgName)
	{
		organizationNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	public void createOrgDropDown(String orgName)
	{
		organizationNameEdt.sendKeys(orgName);
	}
	public String checkIndustryDropDown()
	{
		industryDropDown.click();
		if(industryDropDown.isEnabled()) {
			System.out.println("Dropdown is working");
		}else {
			System.out.println("Dropdown is working");
		}
		return null;
	}
	public void createOrgWithIndustry(String orgName,String industry,String type)
	{
		organizationNameEdt.sendKeys(orgName);
		selectByVisibleText(industryDropDown,industry);
		selectByVisibleText(typeDropDown, type);
		saveBtn.click();
	}
	
}
