package com.crm.qa.util;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.crm.qa.testBase.TestBase;

public class TestUtil extends TestBase {

	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 3;
	
	
	
	public static String TESTDATA_SHEET_PATH = "G:\\programs_eclipse\\CRMPROTest\\src\\main\\java\\com\\crm\\qa\\testData\\FreeCRMNewContacts.xlsx";
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		
		int rowCount=sheet.getLastRowNum();
		int columnCount=sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount][columnCount];//Object[][] data= new Object[rowCount][colCount];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < rowCount; i++) {
			for (int k = 0; k < columnCount; k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				 System.out.print(data[i][k] + " || ");
			}
		}
		return data;
	}
	
	public void getScreenshot(String testMethodName) throws IOException {
		TakesScreenshot shot=(TakesScreenshot) driver;
		File src=shot.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"\\reports\\"+testMethodName+".png";
		
		FileUtils.copyFile(src,new File(dest));  //commons.io dependency

	}
}
