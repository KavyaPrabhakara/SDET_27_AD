package com.crm.autodesk.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * It is developed using Apache POI libraries, which is used to handle Microsoft Excel
 * @author Tejaswini
 *
 */

public class ExcelUtility {
	/**
	 * It is used to read the data from excel with below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return Data
	 * @return Throwable
	 * @throws Throwable 
	 */
	
	public String getDataFromExcel(String SheetName,int rowNum,int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./data/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(cellNum).getStringCellValue();
		wb.close();
		return data;	
	}
	
	/**
	 * Used to get the last used row number on specified sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable 
	 * @throws Throwable
	 */
	
	public int getRowCount(String SheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("/data/org.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		return sh.getLastRowNum();
	}
	
	public void setDataExcel(String SheetName,int rowNum,int cellNum,String data) throws Throwable {
		FileInputStream fis = new FileInputStream("/data/");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		FileOutputStream fos = new FileOutputStream("");
		wb.write(fos);
		wb.close();
		
	}
}
