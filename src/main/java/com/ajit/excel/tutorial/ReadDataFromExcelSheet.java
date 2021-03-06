package com.ajit.excel.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.ajit.utility.ResourceHelper;

public class ReadDataFromExcelSheet {
	
public static String[][] readExcelFiles(String path, String sheetName){
		
		//String path = ;
	String[][] dataSet = null;
		try {
//			String[][] dataSet = null;
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            
            Workbook wb = new XSSFWorkbook(fis);
            
            Sheet sheet = wb.getSheet(sheetName);
            int totalRow = sheet.getLastRowNum();
            int totalColumn = sheet.getRow(0).getLastCellNum();
            dataSet = new String[totalRow][totalColumn];
            String value;
            double doubleValue;
            
            for(int i=1; i< sheet.getLastRowNum()+1; i++){
            	
            	Row row = sheet.getRow(i);
            	
            	for(int j=0; j< row.getLastCellNum();j++ ){
            		Cell cell = row.getCell(j);
            			switch (cell.getCellType()){
            			case Cell.CELL_TYPE_NUMERIC:
//            				value = cell.getStringCellValue();
            				doubleValue = cell.getNumericCellValue();
            				value = Double.toString(doubleValue);
            				value = value.replace(".0", "");
            				System.out.println(value);
                    		dataSet[i-1][j]= value;
                    		break;
            			case Cell.CELL_TYPE_STRING:
            				value = cell.getStringCellValue();
            				System.out.println(value);
                    		dataSet[i-1][j]= value;
                    		break;
            			case Cell.CELL_TYPE_BOOLEAN:
            				value = cell.getStringCellValue();
            				System.out.println(value);
                    		dataSet[i-1][j]= value;
                    		break;
            			case Cell.CELL_TYPE_FORMULA:
            				value = cell.getStringCellValue();
            				System.out.println(value);
                    		dataSet[i-1][j]= value;
                    		break;            				
            			}            		
            	} 
            }
            wb.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return dataSet;
	}

public static void updateResult(String path, String sheetName, String testCaseName, String testStatus){
	

	try {
//		String[][] dataSet = null;
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
        
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        
        Sheet sheet = workbook.getSheet(sheetName);        
        for(int i=1; i< sheet.getLastRowNum()+1; i++){  
        		Row row = sheet.getRow(i);
        		String testCaseNameAsString = row.getCell(1).getStringCellValue();
        		if(testCaseNameAsString.contains(testCaseName)){
        			row.createCell(2).setCellValue(testStatus);
        			fileInputStream.close();
        			System.out.println("result updated");
        			FileOutputStream fileOutputStream = new FileOutputStream(file);
        			workbook.write(fileOutputStream);
        			fileOutputStream.close();        			
        		}     	
        }
        workbook.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void main(String[] args){
	String path = ResourceHelper.getResourcePath("\\testData\\excel\\data1.xlsx");
	String sheetName ="RegistrationData";
//	String testCaseName = "Dashboard Test";
//	String testStatus = "PASS";
//	updateResult( path,  sheetName,  testCaseName,  testStatus);
//	String str = "manchester united (with nice players)";
//	System.out.println(str.replace("(with nice players)", ""));
//	int index = str.indexOf("(");
//	System.out.println(str.substring(0, index));
	
	Object[][] data = readExcelFiles(path, sheetName);
	
//	for(int i=0; i<data.length; i++){
//		
//		for(int j =0; j<data.length; j++){
//			System.out.println(data[i][j]);
//		}		
//	}
}
}


