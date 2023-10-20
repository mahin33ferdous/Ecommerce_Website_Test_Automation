package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class LogInPage extends BaseClass{
	public LogInPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href=\"/login\"]")
	WebElement login;
	
//	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[4]/a")
//	WebElement login;
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@data-qa='login-password']")
	WebElement password;
	
	@FindBy(xpath=" //*[@class='btn btn-default' and contains(text(),'Login')]")
	WebElement loginSubmit;
	
	
	public void loginWithEmptyInput() throws InterruptedException {
		loginSubmit.click();
		Thread.sleep(3000);
		
	}

	
	public void login(String e,String p) throws InterruptedException {
		login.click();
		Thread.sleep(3000);
	
		email.sendKeys(e);
		Thread.sleep(3000);
		
		password.sendKeys(p);
		Thread.sleep(3000);
		
		loginSubmit.click();
		Thread.sleep(3000);
	
	}
	
	public void doLogOut() throws InterruptedException {
		WebElement logOutButton=driver.findElement(By.xpath("//a[@href=\"/logout\"]"));
		logOutButton.click();
		Thread.sleep(1000);
	}

}
