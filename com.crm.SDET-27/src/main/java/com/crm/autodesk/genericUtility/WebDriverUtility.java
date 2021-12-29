package com.crm.autodesk.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * It contains Webdriver specific reusable actions
 * @author Tejaswini
 *
 */

public class WebDriverUtility {
	/**
	 * wait for page to load before identifying any synchronized element in DOM[HTML-document]
	 * @param driver
	 */
	
	public void waitForPAgeToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * wait for page to load before identifying any asynchronized [java script actions]element in DOM[HTML-document]
	 * @param driver
	 */
	public void waitForPAgeToLoadForJSElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	
	/**
	 * Used to wait for the element to be clickable in GUI & check for specific element for every 500 milliseconds
	 * @param driver
	 * @param element 
	 */
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * Used to switch to any window based on window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String wID = it.next();
			driver.switchTo().window(wID);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}
	
	/**
	 * Used to switch to alert window & click on OK button
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver)	{
		driver.switchTo().alert().accept();
	}
	/**
	 * Used to switch to alert window & click on Cancel button
	 * @param driver
	 */
	public void switchToAlertWindowAndDismiss(WebDriver driver)	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * Used to switch to frame window based on index
	 * @param driver
	 * @index
	 */
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * Used to switch to frame window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver, String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	
	/**
	 * Used to select value from dropdown based on index
	 * @param element
	 * @param index
	 */
	public void selectByIndex(WebElement element, int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * Used to select value from dropdown based on value or based on options available in GUI
	 * @param element
	 * @param index
	 */
	public void selectByVisibleText(WebElement element, String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
		
	/**
	 * Used to place cursor on specified element
	 * @param driver
	 * @param element
	 */
	
	public void mouseOverOnElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * Used to right click on specified element
	 * @param driver
	 * @param element
	 */
	
	public void rightClickOnElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * 
	 */
	
	public void executeJavaScript(WebDriver driver,String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
	}
	
	/**
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count=0;
		while(count<20) {
			try {
				element.click();
				break;
			}catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * 
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable
	 */
	public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+screenshotName+".PNG");
		Files.copy(src, dest);
	}
	
	/**
	 * pass enter key appeared in the browser
	 * @param driver
	 */
	
	public void ppassEnterKey(WebDriver driver) {
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
