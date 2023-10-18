package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;

public class TC_HomePage_004 extends BaseClass {
	@Test(priority=1)
	public void test1() {
		TC_linkTest_001 tc1=new TC_linkTest_001();
		tc1.linkTest();
	}
	
	@Test(priority=2)
	public void checkAllLink() {
		HomePage hp=new HomePage(driver);
		hp.checkAllLinks();
	}
	
	@Test(priority=3)
	public void checkCategoriesLink() {
		HomePage hp=new HomePage(driver);
		hp.checkMainCategories();
		
		int expectedLink=7;
		int actualLink=hp.categoryCount();
		Assert.assertEquals(actualLink, expectedLink);
	}
	
	@Test(priority=4)
	public void checkFeaturedProduct() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.featuredProducts();
	}
}

