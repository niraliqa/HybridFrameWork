package com.Automation.testcases;

import java.security.Signature;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Automation.Dataprovider.CustomDataProvider;
import com.Automation.base.BaseClass;
import com.Automation.pages.LoginPage;
import com.Automation.pages.SignupPage;



public class RegisterNewUser extends BaseClass{
	
	
	@Test(dataProvider = "NewUserInfo", dataProviderClass = CustomDataProvider.class)
	public void createNewUser(String uname, String email, String pass, String interest, String gender, String state, String hobbies)
	{
		LoginPage login = new LoginPage(driver);
		
		login.clickOnNewUserLink();
		
		SignupPage signup = new SignupPage(driver);
		
		signup.createNewUser(uname, email, pass, interest, gender, state, hobbies);
		
		Assert.assertTrue(signup.confirmMessageDisplayed(),"User Creation failed");
	}

	@Test
	public void deactiveCourse()
	{
		
	}
	
}
