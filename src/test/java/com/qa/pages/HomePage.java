package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
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
//	
//	@FindBy(xpath="//div[@class='item-box']")
//	List <WebElement> featuredProducts;
//	
//	@FindBy(xpath="//input[@class='button-2 product-box-add-to-cart-button']")
//	List <WebElement> featuredProductsAdd;
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
//	public void featuredProducts() throws InterruptedException {
//		int totalProducts=featuredProducts.size();
//		 
//		 System.out.println("Featured Products availble: " + totalProducts);
//		 
//		 featuredProducts.get(1).findElement(By.xpath(".//input[@class='button-2 product-box-add-to-cart-button']")).click();
//		 //  add '.' in the start of xpath so it can search within all element
//		 Thread.sleep(3000);
//		featuredProducts.get(1).click();
//		
//		Thread.sleep(4000);
//		//title.click();
//		
//		
//	}
}
