package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	//Step1:
	
	//Step2:
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createorgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name="submit")
	private WebElement searchNowBtn;
	
	//Step3
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Step4
	public WebElement getCreateorgLookUpImg() {
		return createorgLookUpImg;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	//Business library
	public void clickOnCreateOrg()
	{
		createorgLookUpImg.click();
	}
	
	
}
