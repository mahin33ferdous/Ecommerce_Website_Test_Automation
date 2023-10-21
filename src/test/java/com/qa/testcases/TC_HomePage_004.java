package com.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LogInPage;

public class TC_HomePage_004 extends BaseClass {
	
	HomePage homePage;
	LogInPage loginPage;
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
		homePage=new HomePage(driver);
		homePage.checkLinkCounts();
		
		int expectedLinkCount=147;;
		
		int actualLinkCount=homePage.checkLinkCounts();
		
		//Hard assertion
		Assert.assertEquals(actualLinkCount,expectedLinkCount);
	}
	
	
	// Positive scenario
	// check the total number of links of category from entire homepage 
	
	@Test(priority=2)
	public void checkCategoriesLink() {
		homePage=new HomePage(driver);
		homePage.checkMainCategories();
		
		int expectedLinkCount=8;
		int actualLinkCount=homePage.categoryLinkCount();
		Assert.assertEquals(actualLinkCount, expectedLinkCount);
	}
	
//add items from featured items		
	@Test(priority=3)
	public void checkFeaturedProduct() throws InterruptedException {
		homePage =new HomePage(driver);
		homePage.featuredItemsVisible();
	}
	

	
	@Test(priority=4)
	public void checkRecomendededProduct() throws InterruptedException {
		homePage =new HomePage(driver);
		homePage.recomendItemsVisible();
		Thread.sleep(3000);
	}
	
	@Test(priority=5)
	public void viewCart() throws InterruptedException {
		homePage =new HomePage(driver);
		homePage.viewCart();
        String url= driver.getCurrentUrl();
        Assert.assertTrue(url.contains("view_cart"));
		
	}
	
//	@Test(priority=8)
//	public void deleteFromCart() throws InterruptedException {
//		homePage =new HomePage(driver);
//		homePage.deleteProduct();
//    //error ask question	
//	}
//	
	@Test(priority=8)
	public void CheckoutLogIn() throws InterruptedException {
		homePage =new HomePage(driver);
		homePage.logInToCheckout();
        String url= driver.getCurrentUrl();
        Assert.assertTrue(url.contains("login"));

	}
	
	@Test(priority=9, description = "Varify User logged in with for checkout")
	public void loginWithAndCheckOut() throws InterruptedException {
		
		loginPage=new LogInPage(driver);
		loginPage.login("mahin1111@gmail.com", "1234");
		
	    boolean isUserNameExist = driver.findElement(By.xpath("//b[contains(text(),'Mahin')]")).isDisplayed();
		Assert.assertTrue(isUserNameExist);
		viewCart();
	    boolean isProccedButtonExists = driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]")).isDisplayed();
		Assert.assertTrue(isProccedButtonExists);
		driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]")).click();
	    Thread.sleep(2000);
		  
	    boolean isOrderOptionExists = driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).isDisplayed();
		Assert.assertTrue(isOrderOptionExists);
		driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();
		Thread.sleep(2000);
	    String url= driver.getCurrentUrl();
	    Assert.assertTrue(url.contains("payment"));
	    Thread.sleep(2000);
		  
		  
		
	}
}

