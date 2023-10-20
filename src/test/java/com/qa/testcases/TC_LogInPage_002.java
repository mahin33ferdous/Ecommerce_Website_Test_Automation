package com.qa.testcases;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.LogInPage;
import com.qa.pages.RegisterPage;

public class TC_LogInPage_002 extends BaseClass {
	
	// get url of targeted website
	@Test(priority=0)
	public void test1() {
		TC_linkTest_001 tc1=new TC_linkTest_001();
		tc1.linkTest();
	}
	
//	@Test(priority=1, description = "Varify User logged in with correct email and password")
//	public void loginWithEmptyInput() throws InterruptedException {
//		LogInPage lp=new LogInPage(driver);
//		lp.login("mahin1111@gmail.com", "1234");
//		
//	    boolean isUserNameExist = driver.findElement(By.xpath("//b[contains(text(),'Mahin')]")).isDisplayed();
//		Assert.assertTrue(isUserNameExist);
//		
//	}
	
	@Test(priority=1, description = "Varify User can't logged in with empty input field")
	public void loginWithEmptyInput() throws InterruptedException {
		LogInPage lp=new LogInPage(driver);
		lp.login("", "");
		String actualTitle= driver.getTitle();
		String ExpTitle= "Automation Exercise - Signup / Login"; // will stay in same page
		Assert.assertEquals(actualTitle, ExpTitle);

		
	}
	
	@Test(priority=1, description = "Varify User can't logged in invalid email address")
	public void loginWithInvalidEmail() throws InterruptedException {
		LogInPage lp=new LogInPage(driver);
		lp.login("wrong@gmail.com", "1234");

	    boolean Error_Validate_Invalid_Email = driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).isDisplayed();
		Assert.assertTrue(Error_Validate_Invalid_Email);

		
	}
	
	@Test(priority=2, description = "Varify User can't logged in invalid password")
	public void loginWithInvalidPassword() throws InterruptedException {
		LogInPage lp=new LogInPage(driver);
		lp.login("mahin1111@gmail.com", "1234444444444444");

	    boolean Error_Validate_Invalid_Email = driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).isDisplayed();
		Assert.assertTrue(Error_Validate_Invalid_Email);

		
	}

	
	@Test(priority=3, description = "Varify User logged in with correct email and password")
	public void loginWithValidEmailAndPassword() throws InterruptedException {
		LogInPage lp=new LogInPage(driver);
		lp.login("mahin1111@gmail.com", "1234");
		
	    boolean isUserNameExist = driver.findElement(By.xpath("//b[contains(text(),'Mahin')]")).isDisplayed();
		Assert.assertTrue(isUserNameExist);
		
	}

}
