package com.Automation.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Automation.Dataprovider.ConfigReader;
import com.Automation.factory.BrowserFactory;

public class BaseClass {
	public WebDriver driver;
	@BeforeClass
	public void setup()
	{
		
		System.out.println("************ LOG INFO- Running Setup *****************");
		
		System.out.println("******************** LOG:INFO- Application will be running on "+ConfigReader.getProperty("browser")+" ********");
		 driver=BrowserFactory.startBrowser(ConfigReader.getProperty("browser"), ConfigReader.getProperty("appURL"));

	}
	
	@AfterClass
	public void tearDown()
	{
		
		System.out.println("************ LOG INFO- Tear Down *****************");
		BrowserFactory.closeAllssion(driver);
	}
	
	
}
