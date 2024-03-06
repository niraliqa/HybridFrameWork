package com.Automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Automation.helper.Utility;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
   private By welcomeMsg=By.xpath("//h4[@class='welcomeMessage']");
   
   private By manageOptions= By.xpath("//span[normalize-space()='Manage']");
   
   private By manageCourses= By.xpath("//a[normalize-space()='Manage Courses']");
   
   
   
   public String getWelcomMessage()
   {
	   
	  String welcomeText = Utility.getElement(driver, welcomeMsg).getText();
	   
	   return welcomeText;
	  
   }
   
   public CoursesPage clickOnManageCourses()
   {
	   Utility.getElement(driver, manageOptions).click();
	
	   Utility.getElement(driver, manageCourses).click();
	   
	   CoursesPage course= new CoursesPage (driver);
		return course;
   }
}
