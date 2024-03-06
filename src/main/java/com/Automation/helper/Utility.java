package com.Automation.helper;

import java.io.File;
import java.io.IOException;
import java.lang.module.Configuration;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;



import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;import org.testng.internal.thread.ThreadExecutionException;

import com.Automation.Dataprovider.ConfigReader;

public class Utility {

	public static String captureCurrentDateAndTime()
	{
		String date=new SimpleDateFormat(" HH_mm_ss_dd_MM_yyyy").format(new Date());
		//HH_mm_ss_dd_MM_yyyy
		return date;
	}
	
	
	public static String captuurScreenshotAsBase64(WebDriver driver) {
		TakesScreenshot tS=(TakesScreenshot)driver;
	String screenshot=	tS.getScreenshotAs(OutputType.BASE64);
	
	return screenshot;
	}
	
	
	
	
	
	
	public static void captureScreenshot(WebDriver driver) {
		try {
			FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), 
					new File("./Screenshots/Screenshot_"+Utility.captureCurrentDateAndTime()+".png"));
			
			System.out.println("Screenshot captured in Screenshots directory");
			
		} catch (WebDriverException e) {
			System.out.println("Could not take the screenshot"+e.getMessage());
		}catch (IOException e) {
			
			System.out.println("Could not save the screenshot"+e.getMessage());
			// TODO: handle exception
		}
	}
	
		public static WebElement getElement(WebDriver driver, By locator) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			
		
		if(ConfigReader.getProperty("highlightelement").equalsIgnoreCase("true"))
		{
			highlisghtElement(driver, element);
		}
		
		return element;	
			
		}
		
		public static void highlisghtElement(WebDriver driver, WebElement element) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
		//js.executeScript("arguments[0].setAttribute('style', 'background: Yellow; border:   3x solid 2px red;');", element);
	  js.executeScript("arguments[0].setAttribute('style', 'background: Yellow; border:   3px solid red;');", element);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		//	js.executeScript("arguments[0].setAttribute('style', 'border: 2x solid black;');", element);
		  js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid blck;');", element);
		}
		
		
		public static void sleep(int seconds) {
			try {
				Thread.sleep(seconds*1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		
		
		public static void type(WebDriver driver, WebElement element, String value) {
			try {
				element.sendKeys(value);
			} catch (Exception e) {
				System.out.println("Not able to type - trying values using java ScriptExcutor");
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				
				js.executeScript("arguments[0].value=arguments[1]", element, value);
			}
			
		}
		
		public static void clickElement(WebDriver driver, WebElement ele) {
			highlisghtElement(driver, ele);
			
			try {
				ele.click();
				
			} catch (Exception e) {
				try {
					System.out.println("JS click Failed: Trying click using Actions class Click ");
					
					Actions act = new Actions(driver);
					
					act.moveToElement(ele).click().build().perform();
					
				} catch (Exception e2) {
					System.out.println("Normal clck Failed: Trying click Using JavaScriptExecutor");
					
					JavascriptExecutor js = (JavascriptExecutor) driver; 
					js.executeScript("arguments[0]", ele);
					
					
				}
				
			}
		}
		
		
		
}
