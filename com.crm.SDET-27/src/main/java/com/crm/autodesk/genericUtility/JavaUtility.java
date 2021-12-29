package com.crm.autodesk.genericUtility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Tejaswini
 *
 */

public class JavaUtility {
	/**
	 * It is used to generate random number
	 * @return int data
	 */
	public int getRanDomNumber() {
		Random random = new Random();
		int intRandom = random.nextInt(10000);
		return intRandom;
	}
	
	/**
	 * Used to get system date and time in IST format
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date date = new Date();
		return date.toString();	
	}
	
	/**
	 * used to get the system date YYYY-MM-DD
	 * @return
	 */
	public String getSystemDateWithFormate() {
		Date date = new Date();
		String dateAndTime = date.toString();
		String YYYY = dateAndTime.split("")[5];
		String DD = dateAndTime.split("")[2];
		int MM = date.getMonth()+1;
		String finalFormat = YYYY + "-" + MM + "-" +DD; 
		return finalFormat;
		
	}
	
	

}
