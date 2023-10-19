package com.qa.testcases;

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
	
//	@Test(priority=1)
//	public void test2() throws InterruptedException {
//      RegisterPage rp=new RegisterPage(driver);
//      
//      rp.register();
//	}
//	
	
	@Test(priority=1)
	public void test2() throws InterruptedException {
      RegisterPage rp=new RegisterPage(driver);
      
      rp.register("Mahin","mahin11@gmail.com");
	}
	
	@Test(priority=2)
	public void test3() throws InterruptedException {
      RegisterPage rp=new RegisterPage(driver);
      
      rp.informationPage();
      rp.addressInfo();
	}
	
	

}
