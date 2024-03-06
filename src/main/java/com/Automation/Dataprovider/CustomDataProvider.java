package com.Automation.Dataprovider;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class CustomDataProvider {

	@DataProvider(name="LoginCredentials")
	public static Object[][] getLoginCredentials()
	{
		
		Object [][] arr=ExcelReader.getDataFromExcel("LoginCredentials");
		
		System.out.println("************ LOG INFO- Setting up Data compelete *****************");
		return arr;
		
	}
	
	@DataProvider(name = "NewUserInfo")
	public static Object[][] newuserInfo()
	{
		System.out.println("************ LOG INFO- Setting up Data *****************");
		
		Object [][] arr=ExcelReader.getDataFromExcel("NewUser");
		
		System.out.println("************ LOG INFO- Setting up Data compelete *****************");
		
		
		return arr;
	}
	
	
	@DataProvider(name = "AddNewCourse")
	public static Object[][] NewCourse()
	{
		System.out.println("************ LOG INFO- Setting up Data New Course*****************");
		
		Object [][] arr=ExcelReader.getDataFromExcel("NewCourse");
		
		System.out.println("************ LOG INFO- Setting up Data compelete New Course*****************");
		
		
		return arr;
	}
	
}
