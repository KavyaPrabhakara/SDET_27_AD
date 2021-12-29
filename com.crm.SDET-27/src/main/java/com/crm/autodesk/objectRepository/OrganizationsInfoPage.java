package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage {
	//declaration
	@FindBy(className="dvHeaderText")
	private WebElement organizationHeaderInfoText;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industryDropDown;
	
	@FindBy(id="dtlview_Type")
	private WebElement typeDropDown;
	
	//initialization
	public OrganizationsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrganizationHeaderInfoText() {
		return organizationHeaderInfoText;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}
	
	//Business library
	public String getOrganizationInfo() 
	{
		return (organizationHeaderInfoText.getText());	
	}
	public String getIndustryName()
	{
		return (industryDropDown.getText());
		
	}
	public String getTypeName()
	{
		return (typeDropDown.getText());
		
	}
}
