package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	//Declaration
	@FindBy(className="dvHeaderText")
	private WebElement contactHeaderInfotxt;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement organizationInfo;
	
	//Initialization
	public ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getContactHeaderInfotxt() {
		return contactHeaderInfotxt;
	}

	public WebElement getOrganizationInfo() {
		return organizationInfo;
	}
	
	//Business library
	public String getContactInfo()
	{
		return (contactHeaderInfotxt.getText());
	}
	
	public String getOrgInfo()
	{
		return (organizationInfo.getText());
	}
}
