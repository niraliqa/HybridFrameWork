package com.Automation.testcases;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Automation.Dataprovider.CustomDataProvider;
import com.Automation.base.BaseClass;
import com.Automation.factory.BrowserFactory;
import com.Automation.helper.Utility;
import com.Automation.pages.HomePage;
import com.Automation.pages.LoginPage;

public class LoginToApplication extends BaseClass{

	
	@Test(priority = 1, description = "Verify login", dataProvider = "LoginCredentials", dataProviderClass = CustomDataProvider.class)
	public void loginApp(String username, String password)
	{
		
		LoginPage login=new LoginPage(driver);
		HomePage home=login.loginToApplicationAsAdminUser(username, password);
		
		Assert.assertTrue(home.getWelcomMessage().contains("Welcome"),"Manage option is not displayed");
				
	}
	
	
}
