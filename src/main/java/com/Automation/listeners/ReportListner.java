package com.Automation.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.Automation.Dataprovider.ConfigReader;
import com.Automation.factory.BrowserFactory;
import com.Automation.helper.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.observer.entity.MediaEntity;
//import com.aventstack.extentreports.observer.entity.MediaEntity.MediaEntityBuilder;

public class ReportListner implements ITestListener {

	ExtentReports extent= ExtentManager.getInstance();
	
	ExtentTest extentTest;
	
	ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("Starting Test");
		
		extentTest=extent.createTest(result.getMethod().getMethodName());
		
		test.set(extentTest);
		
	}
	
		public void onTestSucess(ITestResult result) {
				if(ConfigReader.getProperty("ScreenshotonSuccess").equalsIgnoreCase("true"))
				{
					test.get().pass("Test passed"+result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.captuurScreenshotAsBase64(BrowserFactory.getDriver())).build());
				}
				else 
				{
					test.get().pass("Test passed");
				}
			
				
				}
	
		
		public  void onTestFailure(ITestResult result) 
		{
			
			if(ConfigReader.getProperty("ScreenshotonFailure").equalsIgnoreCase("true"))
			{
				test.get().pass("Test Failed: "+ result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.captuurScreenshotAsBase64(BrowserFactory.getDriver())).build());
			}
			
			else 
			{
				test.get().fail("test Failed: "+result.getThrowable().getMessage());	
			}
					
			
		}
		
	
	
		public  void onTestSkipped(ITestResult result) 
		{
			
			if(ConfigReader.getProperty("ScreenshotonSkip").equalsIgnoreCase("true"))
			{
				test.get().skip("Test Skipp: "+ MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.captuurScreenshotAsBase64(BrowserFactory.getDriver())).build());
			}
			else
			{
				test.get().skip(result.getThrowable().getMessage());
			}
			
		}

		public void onFinish(ITestContext context) {
			extent.flush();
			System.out.println("Adding result to report");
		}
		
	
	
}
