package com.Automation.factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.Automation.Dataprovider.ConfigReader;

public class BrowserFactory {
	static WebDriver driver;
	public static void closeAllssion(WebDriver driver)
	{
		driver.quit();
	}
	
	public static void closeActiveSession(WebDriver driver)
	{
		driver.close();
	}
	
	//getter method - which will return WebDriver indstance
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	public static WebDriver startBrowser(String appURL)
	{
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("pageLoad"))));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("scriptTimeOut"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitwait"))));
		
		
		driver.get(appURL);
		
		return driver;
	}
	

	public static WebDriver startBrowser(String browser, String appURL, boolean cloud) {
		WebDriver driver = null;
		if(cloud)
		{
				ChromeOptions opt=new ChromeOptions();
				opt.setPlatformName("macOS Catalina");
				opt.setBrowserVersion("121.0");
				HashMap<String, Object> map= new HashMap<String, Object>();
				map.put("username", "niraliqa");
				map.put("accessKey", "6Nt0Ab07CReBlWjsClQakrwqEfsKqCsIVzlNWYkUbNMnD4irO3");
				//map.put("selenium_version", "4.0.0");//if you don't select selenium version then 
				map.put("w3c", true);//this medotory with selenium 4.0.0 version
				map.put("visual", true);
				map.put("network", true);
				map.put("project", "Selenium Cloud Automation project");
				opt.setCapability("LT:Options", map);
				
				try {
					URL hubUrl=new URL("http://niraliqa:6Nt0Ab07CReBlWjsClQakrwqEfsKqCsIVzlNWYkUbNMnD4irO3@hub.lambdatest.com/wd/hub");
					driver=new RemoteWebDriver(hubUrl, opt);
					
				} catch (MalformedURLException e) {
					
				}
				
			
		}
		else
		{
			if(browser.equalsIgnoreCase("Chrome"))
			{
				driver=new ChromeDriver();
			}
			else if (browser.equalsIgnoreCase("Firefox"))
			{
				driver=new FirefoxDriver();
				
			}
			else if (browser.equalsIgnoreCase("Edge"))
			{
				driver=new EdgeDriver();
			}
			else if (browser.equalsIgnoreCase("Safari"))
			{
				driver=new SafariDriver();
			}
			else
			{
				System.out.println("We don't suppourt this browser currently");
			}

			
			//return driver;
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("pageLoad"))));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("scriptTimeOut"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitwait"))));
		
		
		driver.manage().window().maximize();
		driver.get(appURL);
		return driver;
	}
	
	
	public static WebDriver startBrowser(String browser, String appURL)
	{
		

		if (browser.equalsIgnoreCase("Chrome")) {
		
			
			ChromeOptions opt=new ChromeOptions();
			//opt.addArguments("--headless=new");
		//	opt.addArguments("--incognito");
			//driver=new ChromeDriver(opt);
			//driver = new ChromeDriver();
			
			Map<String, String> map = new HashMap<String, String>();
			
			String downloadDrirectory = System.getProperty("user.dir")+"/DownloadedFiles/";
			
			map.put("download.default.default_directory", downloadDrirectory);
			
			opt.setExperimentalOption("prefs", map);
			
			if(ConfigReader.getProperty("headless").equalsIgnoreCase("true"))
			{
				opt.addArguments("headless=new");
			}
			
			
			driver=new ChromeDriver(opt);
			
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			
		}else if (browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
			
		}else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			
		} else {
			System.out.println("we are not supporting currently");
		}
		
	//	long time=Long.parseLong(ConfigReader.getProperty("PageLoad"));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("pageLoad"))));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("scriptTimeOut"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitwait"))));
		
		driver.manage().window().maximize();
		driver.get(appURL);
		return driver;
	}
	
}
