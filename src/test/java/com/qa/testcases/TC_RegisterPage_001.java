package com.qa.testcases;

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
      
		String title= driver.getTitle();
		String ExpTitle= "Automation Exercise";
		Assert.assertEquals(title, ExpTitle);
		

    }
	
	// fill up register page with valid name and email
	@Test(priority=2, description = "User shall be proceed to signup with valid name and email")
	public void doSignUpWithValidEmail() throws InterruptedException {
     RegisterPage rp=new RegisterPage(driver);
      
     rp.register("Mahin","mahin11@gmail.com");
		String title= driver.getTitle();
		String ExpTitle= "Automation Exercise - Signup";
		Assert.assertEquals(title, ExpTitle);
    }
	

//	
//	@Test(priority=3)
//	public void test3() throws InterruptedException {
//      RegisterPage rp=new RegisterPage(driver);
//      
//      rp.informationPage("1234",5,6,6);
//      rp.addressInfo("Mahin","Ferdous","xyz company","ecb road, 1206","dhaka","dhaka","1216","444444444");
//	}
	
	
	

}
