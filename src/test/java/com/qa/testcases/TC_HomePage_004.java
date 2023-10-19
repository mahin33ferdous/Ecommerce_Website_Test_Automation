package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;

public class TC_HomePage_004 extends BaseClass {
	@Test(priority=0)
	public void test1() {
		TC_linkTest_001 tc1=new TC_linkTest_001();
		tc1.linkTest();
	}
	
	@Test(priority=1)
	public void checkLinkCount() {
		HomePage hp=new HomePage(driver);
		hp.checkLinkCounts();
		
		int expectedLinkCount=147;;
		
		int actualLinkCount=hp.checkLinkCounts();
		
		//Hard assertion
		Assert.assertEquals(actualLinkCount,expectedLinkCount);
	}
	
//	@Test(priority=2)
//	public void checkCategoriesLink() {
//		HomePage hp=new HomePage(driver);
//		hp.checkMainCategories();
//		
//		int expectedLink=7;
//		int actualLink=hp.categoryCount();
//		Assert.assertEquals(actualLink, expectedLink);
//	}
//	
//	@Test(priority=3)
//	public void checkFeaturedProduct() throws InterruptedException {
//		HomePage hp=new HomePage(driver);
//		hp.featuredProducts();
//	}
}

