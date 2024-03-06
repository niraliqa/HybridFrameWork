package com.Automation.Dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader {

	@DataProvider(name="registrationData")
	public static Object[][] getDataFromExcel(String Sheetname)
	{
		XSSFWorkbook wb = null;
		
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File("./TestData/Test_Data.xlsx")));
		} catch (FileNotFoundException e) {
			
			System.out.println("File not found "+e.getMessage());
			
		} catch (IOException e) {
			
			System.out.println("Could not read file");
		}
		
		int rowCount=wb.getSheet(Sheetname).getPhysicalNumberOfRows();
		
		int column=wb.getSheet(Sheetname).getRow(0).getPhysicalNumberOfCells();
		
		Object [][] arr=new Object[rowCount-1][column];
		
		System.out.println("Number of rows "+ (rowCount-1));
		
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<column;j++)
			{
					String value="";
				
					CellType type=wb.getSheet(Sheetname).getRow(i).getCell(j).getCellType();
					
					if(type==CellType.NUMERIC)
					{
						value=String.valueOf(wb.getSheet(Sheetname).getRow(i).getCell(j).getNumericCellValue());
					}
					else if(type==CellType.STRING)
					{
						value=wb.getSheet(Sheetname).getRow(i).getCell(j).getStringCellValue();
					}
					else if(type==CellType.BOOLEAN)
					{
						value=String.valueOf(wb.getSheet(Sheetname).getRow(i).getCell(j).getBooleanCellValue());
					}
					else if(type==CellType.BLANK)
					{
						value="";
					}
					
				arr[i-1][j]=value;
			}


		}
		
		return arr;
		
	}
	
	
	
}
