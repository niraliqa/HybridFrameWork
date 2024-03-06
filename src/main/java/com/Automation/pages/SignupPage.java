package com.Automation.pages;

import org.apache.xmlbeans.impl.common.IdentityConstraint.SelectorState;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.Automation.helper.Utility;

public class SignupPage {
	WebDriver driver;
	
	public  SignupPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	private By userName=By.xpath("//input[@id='name']");
	
	private By emailId=By.xpath("//input[@id='email']");
	
	private By password=By.xpath("//input[@id='password']");
	
	private By selectstate=By.xpath("//select[@id='state']");
	
	private By hobbies=By.xpath("//select[@name='hobbies']");
	
	private By singup=By.xpath("//button[normalize-space()='Sign up']");
	
	private By confirmNewUser=By.xpath("//div[text()='Signup successfully, Please login!']");
	
	
	public void createNewUser(String uname, String emailAddress, String pass, String interest, String gender, String statevalue, String hobby) {
		
		
		Utility.getElement(driver, userName).sendKeys(uname);
		
		Utility.getElement(driver, emailId).sendKeys(emailAddress);
		
		Utility.getElement(driver, password).sendKeys(pass);
		
		Utility.getElement(driver, By.xpath("//label[normalize-space()='"+interest+"']//preceding::input[1]")).click();
		
		Utility.getElement(driver, By.xpath("//label[normalize-space()='"+gender+"']//preceding::input[1]")).click();		
		
		Select state=new Select(Utility.getElement(driver, selectstate));
		
			   state.selectByVisibleText(statevalue);
				
		Select hobbiesDropdown=new Select(Utility.getElement(driver, hobbies));
				
			   hobbiesDropdown.selectByVisibleText(hobby);
			
		Utility.getElement(driver, singup).click();
	}
	
	public boolean confirmMessageDisplayed() {
		
		boolean  status =Utility.getElement(driver, confirmNewUser).isDisplayed();
		
		return status;
		
		
	}
	
}
