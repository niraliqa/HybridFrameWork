package com.Automation.pages;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr;

import com.Automation.helper.Utility;
import com.github.javafaker.Internet.UserAgent;

public class CoursesPage {
	
	WebDriver driver;
	
	public CoursesPage(WebDriver driver)
	{
		this.driver=driver;
	}

	//private By addNewCoursebtn= By.xpath("//button[normalize-space()='Add New Course']");
	
	private By addNewCoursebtn =By.xpath("//button[text()='Add New Course ']");
		
	private By choosefile= By.xpath("//input[@id='thumbnail']");
	
	private By course= By.xpath("//input[@id='name']");
	
	private By describe= By.xpath("//textarea[@id='description']");
	
	private By InstructorName= By.xpath("//input[@id='instructorNameId']");
	
	private By payment =By.xpath("//input[@id='price']");
	
	private By courseVerify= By.xpath("//td[normalize-space()='LoadRunner']");	
	
	private By deleteCourse=By.xpath("//td[normalize-space()='LoadRunner']//following::td[4]//button[text()='Delete']");
	
	private By CourseStatus=By.xpath("//td[normalize-space()='LoadRunner']//preceding::td[1]");
	public void AddNewCourse(String filepath, String Coursename, String description,String Instructor, String Price) {
		// TODO Auto-generated constructor stub
		
		Utility.getElement(driver, addNewCoursebtn).click();
		
		Utility.getElement(driver, choosefile).sendKeys(filepath);
		
		Utility.getElement(driver, course).sendKeys(Coursename);
		
		Utility.getElement(driver, describe).sendKeys(description);
		
		Utility.getElement(driver, InstructorName).sendKeys(Instructor);
		
		Utility.getElement(driver, payment ).sendKeys(Price);
		
		Utility.getElement(driver,By.xpath("//div[text()='Select Category']")).click();
		
		Utility.getElement(driver, By.xpath("//button[text()='LoadRunner']")).click();
		
	//	Utility.sleep(2);
		Utility.getElement(driver, By.xpath("//button[@class='action-btn']")).click();
		
	}
	
	
	public  boolean checkCoursePresence() {
		
		boolean Coursepresent=Utility.getElement(driver, courseVerify).isDisplayed();
		
		return Coursepresent;
	}
	
	public  boolean checkCourseStatus() {
		boolean checkStauts=Utility.getElement(driver, CourseStatus).isEnabled();
		
		return checkStauts;
	}
	
	
	public void deleteCourse() {
		Utility.getElement(driver, deleteCourse).click();
	}

}
