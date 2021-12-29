package com.crm.autodesk.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.LoginPage;

public class BaseClass {
	
	public DataBaseUtility dLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite
	public void dbConnection() {
		dLib.connectionToDb();
		System.out.println("====Database Connection Successfull====");
}
	@Parameters("browser")
	@BeforeClass
	public void launchBrowser(String BROWSER) throws Throwable {
		//read the data
		//String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("Url");
		if(BROWSER.contains("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.contains("FIREFOX")) {
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("invalid Browser");
		}
		sdriver=driver;
		wLib.waitForPAgeToLoad(driver);
		wLib.maximizeWindow(driver);
		driver.get(URL);
		System.out.println("====Browser launched=====");
	}
	
	@BeforeMethod
	public void loginToApp() throws Throwable {
		//read the data
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("=====Login Success====");
	}
	
	@AfterMethod
	public void logoutApp() 
	{
		HomePage hp = new HomePage(driver);
		hp.logout(driver);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
		System.out.println("=====browser quit====");
	}
	
	@AfterSuite
	public void closeConnection() {
		dLib.closeDb();
		System.out.println("====browser closed====");
	}
}


