package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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

public class  Contact{
	//private static final CharSequence Name = null;

	public static void main(String[] args) throws  Throwable{
		
		
		// create object for libraries
		
		JavaUtility jLib=new JavaUtility();
		//WebDriverUtility =new WebDriverUtility()
		//WebDriverUtility wLib= new WebDriverUtility();
	    ExcelUtility eLib = new ExcelUtility();
	   FileUtility fLib = new FileUtility();
	   
	  //random
	   
	   int rand = jLib.getRanDomNumber();
		//create the property file
	   String URL = fLib.getPropertyKeyValue("Url");
		 String Browser = fLib.getPropertyKeyValue("browser");
		 String UserName = fLib.getPropertyKeyValue("username");
		 String Password = fLib.getPropertyKeyValue("password");
		 
	

	//read data from excel sheet
	
			String con = eLib.getDataFromExcel("Sheet2", 1, 1)+rand;
				 
		 
	WebDriver driver;
	if(Browser.equals("chrome")) {
		driver =new ChromeDriver();
	}
	else if(Browser.equals("firefox")) {
		driver=new FirefoxDriver();
	}
	else if (Browser.equals("ig")) {
		driver=new InternetExplorerDriver();
	} else {
		driver=new ChromeDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	driver.get(URL);
	
	 LoginPage lp=new LoginPage(driver);
	  lp.login(UserName, Password);
	  
	  HomePage hp=new HomePage(driver);
		hp.clickOnContactsLnk();
		
	  ContactsPage cp=new ContactsPage(driver);
	  cp.clickOnCreateContact();
	  
	  CreateContactPage cp1=new CreateContactPage(driver);
	  cp1.createContact(con);
	 
	 /* ContactsInfoPage cInfo=new ContactsInfoPage(driver);
String msg = cInfo.ContactVerify();
if(msg.contains(con)) {
	System.out.println("sucess");
}
else {
	System.out.println("not sucess");
}
hp.mouseOverForSignOut(driver);*/
}
	 
	
	
	}