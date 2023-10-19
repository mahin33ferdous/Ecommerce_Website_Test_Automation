package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;

public class TC_HomePage_004 extends BaseClass {
	
	// get url of targeted website
	@Test(priority=0)
	public void test1() {
		TC_linkTest_001 tc1=new TC_linkTest_001();
		tc1.linkTest();
	}
	
	// Positive scenario
	// check the total number of links from entire homepage 
	@Test(priority=1)
	public void checkLinkCount() {
		HomePage hp=new HomePage(driver);
		hp.checkLinkCounts();
		
		int expectedLinkCount=147;;
		
		int actualLinkCount=hp.checkLinkCounts();
		
		//Hard assertion
		Assert.assertEquals(actualLinkCount,expectedLinkCount);
	}
	
	
	// Positive scenario
	// check the total number of links of category from entire homepage 
	
	@Test(priority=2)
	public void checkCategoriesLink() {
		HomePage hp=new HomePage(driver);
		hp.checkMainCategories();
		
		int expectedLinkCount=8;
		int actualLinkCount=hp.categoryLinkCount();
		Assert.assertEquals(actualLinkCount, expectedLinkCount);
	}
	
//add items from featured items		
	@Test(priority=3)
	public void checkFeaturedProduct() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.featuredItemsVisible();
	}
	

	
	@Test(priority=4)
	public void checkRecomendededProduct() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.recomendItemsVisible();
		Thread.sleep(3000);
	}
}

