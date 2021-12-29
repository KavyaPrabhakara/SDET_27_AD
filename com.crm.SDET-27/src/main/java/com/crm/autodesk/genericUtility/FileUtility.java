package com.crm.autodesk.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author Tejaswini
 *
 */

public class FileUtility {
	/**
	 * It is used to read the data from data.properties file based on key which you pass as an argument
	 * @param key
	 * @throws Throwable 
	 * @throws Throwable
	 */
	
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./data/data.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
		
	}
	

}
