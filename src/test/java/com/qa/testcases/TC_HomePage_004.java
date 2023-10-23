package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
	@Test(priority=1, description = "Verify all the link exists on homepage")
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
	
	@Test(priority=2, description = "Verify all the category link exists on homepage")
	public void checkCategoriesLink() {
		homePage=new HomePage(driver);
		homePage.checkMainCategories();
		
		int expectedLinkCount=8;
		int actualLinkCount=homePage.categoryLinkCount();
		Assert.assertEquals(actualLinkCount, expectedLinkCount);
	}
	
//add items from featured items		
	@Test(priority=3, description = "Verify user can add featured products to the cart")
	public void checkFeaturedProduct() throws InterruptedException {
		homePage =new HomePage(driver);
		homePage.featuredItemsVisible();
	}
	

	
	@Test(priority=4, description = "Verify user can add recomended products to the cart")
	public void checkRecomendededProduct() throws InterruptedException {
		homePage =new HomePage(driver);
		homePage.recomendItemsVisible();
		Thread.sleep(3000);
	}
////	
	@Test(priority=5, description = "Verify user can view cart")
	public void viewCart() throws InterruptedException {
		homePage =new HomePage(driver);
		homePage.viewCart();
        String url= driver.getCurrentUrl();
        Assert.assertTrue(url.contains("view_cart"));
		
	}
//	
////	@Test(priority=8)
////	public void deleteFromCart() throws InterruptedException {
////		homePage =new HomePage(driver);
////		homePage.deleteProduct();
////    //error ask question	
////	}
////	
	
	@Test(priority=8, description = "Verify user can't checkout order without logging in")
	public void CheckoutWithOutLogIn() throws InterruptedException {
		homePage =new HomePage(driver);
		homePage.checkoutWithOutLogIn();
	    //boolean required_LogIn_to_Checkout_Model = driver.findElement(By.xpath("//p[contains(text(),'Register / Login account to proceed on checkout.')]")).isDisplayed();
		boolean required_LogIn_to_Checkout_Model = driver.findElement(By.xpath("//u[contains(text(),'Register / Login')]")).isDisplayed();
		Assert.assertTrue(required_LogIn_to_Checkout_Model );

	}
//	
////	@Test(priority=8)
////	public void CheckoutLogIn() throws InterruptedException {
////		homePage =new HomePage(driver);
////		homePage.logInToCheckout();
////        String url= driver.getCurrentUrl();
////        Assert.assertTrue(url.contains("login"));
////
//	}
	
	@Test(priority=9, description = "Varify User logged in with for checkout")
	public void loginWithAndCheckOut() throws InterruptedException {
		
		driver.findElement(By.xpath("//u[contains(text(),'Register / Login')]")).click();
  	    Thread.sleep(2000); 

		loginPage=new LogInPage(driver);
		loginPage.login("mahi321@gmail.com", "1234");
		
	    boolean isUserNameExist = driver.findElement(By.xpath("//b[contains(text(),'Mahin')]")).isDisplayed();
		Assert.assertTrue(isUserNameExist);
		viewCart();
	    boolean isProccedButtonExists = driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]")).isDisplayed();
		Assert.assertTrue(isProccedButtonExists);
		driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]")).click();
	    Thread.sleep(2000);
		   
	    boolean isOrderOptionExists = driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).isDisplayed();
		Assert.assertTrue(isOrderOptionExists);
		
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		 // Scrolling down to the featured items
		 WebElement location=driver.findElement(By.xpath("//a[contains(text(),'Place Order')]"));
		 js.executeScript("arguments[0].scrollIntoView(true);",location );
		 
		driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();
		Thread.sleep(2000);
	    String url2= driver.getCurrentUrl();
	    Assert.assertTrue(url2.contains("payment"));
	    Thread.sleep(2000);
		  
		  
		
	}
}

