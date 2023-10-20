package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.RegisterPage;

public class TC_RegisterPage_001 extends BaseClass {
	
	// get url of targeted website
	@Test(priority=0)
	public void test1() {
		TC_linkTest_001 tc1=new TC_linkTest_001();
		tc1.linkTest();
	}
	
	@Test(priority=1, description = "User shall not be proceed signup with blank input")
	public void doSignUpWithBlankInput() throws InterruptedException {
      RegisterPage rp=new RegisterPage(driver);
      
      rp.signUpWithBlankInput();
      Thread.sleep(2000);
      
		String actualTitle= driver.getTitle();
		String ExpTitle= "Automation Exercise - Signup / Login"; // will stay in same page
		Assert.assertEquals(actualTitle, ExpTitle);
	 }
	
	// fill up register page with valid name and email
	@Test(priority=2, description = "User shall be proceed to signup with valid name and email")
	public void doSignUpWithValidEmail() throws InterruptedException {
     RegisterPage rp=new RegisterPage(driver);
        rp.register("Mahin","mahin1111@gmail.com");
        
		String actualTitle= driver.getTitle();
		String ExpTitle= "Automation Exercise - Signup"; // will redirect to signup page
		Assert.assertEquals(actualTitle, ExpTitle);
    }
	
	@Test(priority=3, description = "User account shall not be created with blank information input")
	public void fillSignupInfoWithBlankInput() throws InterruptedException {
      RegisterPage rp=new RegisterPage(driver);
      
      rp.signUpInfoBlankInput();
      Thread.sleep(2000);
      
		String actualTitle= driver.getTitle();
		String ExpTitle= "Automation Exercise - Signup"; // will remain to signup page
		Assert.assertEquals(actualTitle, ExpTitle);
  

    }
	
	@Test(priority=4, description = "User account shall be created with all required information input")
	public void fillupValidSignupInformation() throws InterruptedException {
      RegisterPage rp=new RegisterPage(driver);
      
      rp.informationPage("1234",5,6,6);
      rp.addressInfo("Mahin","Ferdous","xyz company","ecb road, 1206","dhaka","dhaka","1216","444444444");
		String actualTitle= driver.getTitle();
		String ExpTitle= "Automation Exercise - Account Created"; // will redirect to account created validation page
		Assert.assertEquals(actualTitle, ExpTitle);
	}
	
	
	@Test(priority=5, description = "User shall be logged in and username must be showing")
	public void verifyUserAccout() throws InterruptedException {
      RegisterPage rp=new RegisterPage(driver);
      rp.verifyUserAccount();
      
      boolean isUserNameExist = driver.findElement(By.xpath("//b[contains(text(),'Mahin')]")).isDisplayed();
	  Assert.assertTrue(isUserNameExist);
	 }
	
	

}
