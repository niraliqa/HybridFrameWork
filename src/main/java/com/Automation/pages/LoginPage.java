package com.Automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Automation.helper.Utility;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	private By userID=By.xpath("//input[@placeholder='Enter Email']");
	
	private By passcode=By.name("password1");
	
	private By logingButton=By.className("submit-btn");
	
	private By signuplink= By.xpath("//a[text()='New user? Signup']");
	
	public void clickOnNewUserLink()
	{
		Utility.getElement(driver, signuplink).click();
	}
	
	public HomePage loginToApplicationAsAdminUser(String username, String password)
	{
		
		Utility.getElement(driver, userID).sendKeys(username);
		
		Utility.getElement(driver, passcode).sendKeys(password);
		
		Utility.getElement(driver, logingButton).click();
		
		HomePage home=new HomePage(driver);
		
		return home;
	}
}
