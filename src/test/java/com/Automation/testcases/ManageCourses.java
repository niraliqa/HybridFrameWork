package com.Automation.testcases;

import org.apache.log4j.Priority;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Dataprovider.CustomDataProvider;
import com.Automation.base.BaseClass;
import com.Automation.pages.CoursesPage;
import com.Automation.pages.HomePage;
import com.Automation.pages.LoginPage;

public class ManageCourses extends BaseClass {
	
	 CoursesPage coursesPage;

	@Test (dataProvider = "AddNewCourse" ,dataProviderClass = CustomDataProvider.class)
	public void ManageCourse(String name, String descrip,String Inst, String pay ) {
		// TODO Auto-generated constructor stub
		LoginPage login=new LoginPage(driver);
		
		HomePage home=login.loginToApplicationAsAdminUser("admin@email.com", "admin@123");
		
		CoursesPage course=home.clickOnManageCourses();
		// home.clickOnManageCourses();
		// CoursesPage course =	new CoursesPage(driver);
	
		if(course.checkCoursePresence())
		{
			course.deleteCourse();
		}
		else 
		{
			course.AddNewCourse(System.getProperty("user.dir")+"/TestData/CourseThumbnail.png",name, descrip, Inst, pay );	
	    }
		
		Assert.assertTrue(course.checkCoursePresence());	
		
		Assert.assertTrue(course.checkCourseStatus());
		
	//	course.deleteCourse();
	//	Assert.assertFalse(course.checkCourseStatus());
	}
	
	
	/*@Test( dependsOnMethods = "deactivedCourse" )
	public void activedCourse(){
		
	}
	
	@Test()
	public void deactivedCourse()
	{
		 
	}
	
	

	
	@Test( dependsOnMethods  ="ManageCourse" )
	public void deleteCourse()
	{
		
	}
	*/
	
}
