package com.tt.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	
	public static Object[][] readExcelAsMap(String name,String sheetName) throws IOException
	{
		File file = new File(name);
	    FileInputStream fis = new FileInputStream(file);

	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet = wb.getSheet(sheetName);
	    
	    int lastRowNum = sheet.getLastRowNum() ;
	    int lastCellNum = sheet.getRow(0).getLastCellNum();
	    Object[][] obj = new Object[lastRowNum][1];

	    
	    	for (int i = 0; i < lastRowNum; i++) {
	  	      Map<Object, Object> datamap = new HashMap<>();
	  	      for (int j = 0; j < lastCellNum; j++) {
	  	        datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
	  	      }
	  	      obj[i][0] = datamap;

	  	    }
	  
	    
	    return  obj;

	}

	public HashMap<String, String> readData(String fileName, String sheetName) throws IOException {
		HashMap<String, String> hMap = new HashMap<String, String>();

		File src = new File(fileName);
		FileInputStream inputStream = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);

		XSSFSheet sheet = wb.getSheet(sheetName);
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < cols; i++) {
				String val = sheet.getRow(j).getCell(i).getStringCellValue();
				hMap.put(sheet.getRow(0).getCell(i).getStringCellValue(), val);
			}
		}
		//System.out.println(hMap);
		return hMap;

	}

	public List<HashMap<String, String>>  readData1(String fileName, String sheetName) throws IOException
	{
		List<HashMap<String, String>> mydata = new ArrayList<HashMap<String, String>>();
		File src = new File(fileName);
		FileInputStream inputStream = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);

		XSSFSheet sheet = wb.getSheet(sheetName);
		Row HeaderRow = sheet.getRow(0);
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
		    Row currentRow = sheet.getRow(i);
		    HashMap<String, String> currentHash = new HashMap<String, String>();
		    for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
		        Cell currentCell = currentRow.getCell(j);
		        switch (currentCell.getCellType()) {
		            case Cell.CELL_TYPE_STRING:
		                currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
		                break;
		            case Cell.CELL_TYPE_NUMERIC:
		                currentHash.put(HeaderRow.getCell(j).getStringCellValue(), String.valueOf(currentCell.getNumericCellValue()));
		                break;
		        }

		    }
		    mydata.add(currentHash);
		}
		return mydata;
	}
	public int getExcelRows(String fileName, String sheetName) throws IOException {
		File src = new File(fileName);
		FileInputStream inputStream = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);

		XSSFSheet sheet = wb.getSheet(sheetName);
		int rows = sheet.getPhysicalNumberOfRows();
		return rows;

	}

	/*
	 * public static void main(String[] args) throws IOException {
	 * readData(1,"C:\\Users\\TT072\\Desktop\\data.xlsx","Login"); }
	 */
}
