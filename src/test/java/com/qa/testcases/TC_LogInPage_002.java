package com.qa.testcases;

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
	
	@Test(priority=1)
	public void test2() throws InterruptedException {
		LogInPage lp=new LogInPage(driver);
		lp.login("mahin11@gmail1.com", "1234");
		
	}

}
