package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

public class ContactsPage extends WebDriverUtility {
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactsLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name="submit")
	private WebElement searchNowBtn;
	
	//Step3
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateContactsLookUpImg() {
		return createContactsLookUpImg;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	//Business library
	public void clickOnCreateContact()
	{
		createContactsLookUpImg.click();
	}
}
