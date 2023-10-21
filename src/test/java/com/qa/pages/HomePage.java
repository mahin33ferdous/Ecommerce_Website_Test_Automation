package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class HomePage extends BaseClass{
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName="a")
	List <WebElement> links;
	
	
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li")
	List <WebElement> CategoriesLinks;
	
//	Getting all featured items from homepage
	@FindBy(xpath="//div[@class='features_items']//div[@class='col-sm-4']")
 	List <WebElement> featuredItems;
//	
	@FindBy(xpath="//div[@class='features_items']/div/div/div/div[2]/div/a")
	List <WebElement> featuredItemsAddButton;
	
	//div[@class='recommended_items']/div/div/div/div/div/div/div[@class='productinfo text-center']/a
	////div[@class='recommended_items']//div[@class='productinfo text-center']//a
	
	@FindBy(xpath="//div[@class='recommended_items']//div[@class='col-sm-4']")
 	List <WebElement> recomendedItems;
	
	@FindBy(xpath="//div[@class='features_items']/div/div/div/div[2]/div/a")
	List <WebElement> recomendedItemsAddButton;
	
	@FindBy(xpath="//button[@class='btn btn-success close-modal btn-block']")
	WebElement continueShopping;
//	
//	@FindBy (xpath="/html/body/div[4]/div[1]/div[1]/div[1]/a")
//	WebElement title;
	
	public int checkLinkCounts() {
		 int totalLink=links.size();
		 System.out.println(totalLink);
		for(WebElement elements : links) {
			System.out.println(elements.getText());
		}
		return totalLink;
	}	
	
	public int categoryLinkCount() {
		 int totalLink=CategoriesLinks.size();
		 System.out.println(totalLink);
		 return totalLink;
	}
		public void checkMainCategories() {
			categoryLinkCount();
			for(WebElement elements : CategoriesLinks) {
				System.out.println(elements.getText());
			}
		}
		
	//add items from featured items	
	public void featuredItemsVisible() throws InterruptedException {
		int totalItems=featuredItems.size();
		 
		 System.out.println("Featured items available: " + totalItems);
		 
		
		 
		 featuredItems.get(4).findElement(By.xpath("//div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/a")).click();
		 //  add '.' in the start of xpath so it can search within all element
		 Thread.sleep(5000);
		 
		 continueShopping.click();
		
		
	}
	

	public void recomendItemsVisible() throws InterruptedException {
		int totalItems= recomendedItems.size();
		 
		 System.out.println("Recomended items available: " + totalItems);
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 // Scrolling dowm
		 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 Thread.sleep(3000);
		 
		 // Scrolling down to the featured items
		 WebElement location=driver.findElement(By.xpath("//div[@class='recommended_items']"));
		 js.executeScript("arguments[0].scrollIntoView(true);",location );
		 Thread.sleep(3000);

		 recomendedItems.get(2).findElement(By.xpath("//div[@class='recommended_items']//div[@class='productinfo text-center']//a")).click();
		 //  add '.' in the start of xpath so it can search within all element
		 Thread.sleep(3000);
		 continueShopping.click();
		 
		 //Scrolling back to the top
		 Thread.sleep(3000);
		 js.executeScript("window.scrollTo(0,0)");
		 Thread.sleep(3000);
		 
		 
		
		
	}
	
	public void viewCart() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
		 Thread.sleep(2000);
	}
	
	public void deleteProduct() throws InterruptedException {
		 
		driver.findElement(By.xpath("//tr[@id='product-3']//a[1]/i[1]")).click();
		Thread.sleep(2000);
	}
	
	public void logInToCheckout() throws InterruptedException {
		 
		driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//u[contains(text(),'Register / Login')]")).click();
		Thread.sleep(2000); 
	}
}
