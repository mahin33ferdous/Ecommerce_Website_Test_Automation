package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qa.base.BaseClass;

public class RegisterPage extends BaseClass{
	public  RegisterPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[4]/a")
	WebElement signup;
	
	@FindBy(xpath="//a[@href=\"/login\"]")
	WebElement signup1;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement name;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement email;
	
	@FindBy(xpath="//*[contains(text(),'Signup')and @type='submit']")
	 WebElement signupSubmit;
	
	@FindBy(xpath="//button[@data-qa='create-account']")
	 WebElement createAccount;
	
	public WebElement getName() {
		return name;
	}
	
	public void signUpWithBlankInput() throws InterruptedException {
		  signup1.click();
		 Thread.sleep(2000);
		 signupSubmit.click();;
		 Thread.sleep(2000);
	}


	
	public void register(String n,String p) throws InterruptedException {
		signup.click();
		Thread.sleep(1000);
		
		name.click();
		name.sendKeys(n);
		Thread.sleep(1000);
		email.sendKeys(p);
		Thread.sleep(1000);
		signupSubmit.click();
		Thread.sleep(1000);
		

	}
	
	public void signUpInfoBlankInput() throws InterruptedException {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 // Scrolling dowm
		 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 Thread.sleep(1000);
		 
		
		 js.executeScript("arguments[0].scrollIntoView(true);",createAccount);
		 Thread.sleep(1000);
		 
		 createAccount.click();
		 Thread.sleep(2000);
	}
	

	
	public void informationPage(String p, int d, int m, int y) throws InterruptedException {
		
		WebElement button=driver.findElement(By.xpath("//*[@id='id_gender2']"));
		button.click(); 
		boolean exp=true;
		boolean act=button.isSelected();
		Assert.assertEquals(act, exp);
		Thread.sleep(1000);
		
		WebElement password=driver.findElement(By.xpath("//*[@id='password']"));
		password.click();
		password.sendKeys(p);
		Thread.sleep(1000);
		
		WebElement days=driver.findElement(By.xpath("//*[@id='days']"));
		Select selectDay=new Select(days);
		selectDay.selectByIndex(d);
		Thread.sleep(1000);
		
		WebElement months=driver.findElement(By.xpath("//*[@id='months']"));
		Select selectMonth=new Select(months);
		selectMonth.selectByIndex(m);
		Thread.sleep(1000);
		
		WebElement years=driver.findElement(By.xpath("//*[@id='years']"));
		Select selectYear=new Select(years);
		selectYear.selectByIndex(y);
		Thread.sleep(1000);
		
		WebElement check=driver.findElement(By.xpath("//input[@id='newsletter']"));
		check.click();
		Thread.sleep(1000);
		
		
	}
	

	public void addressInfo(String fname, String lname,String com, String addr, String st, String c, String zcode, String phn) throws InterruptedException {
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 // Scrolling dowm
		 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 Thread.sleep(1000);
		 
		 // Scrolling down to the featured items
		 WebElement location=driver.findElement(By.xpath("//*[contains(text(),'Address Information')]"));
		 js.executeScript("arguments[0].scrollIntoView(true);",location );
		 
		WebElement firstName=driver.findElement(By.xpath("//input[@name='first_name']"));
		firstName.click();
		firstName.sendKeys(fname);
		Thread.sleep(1000);
		
		WebElement lasttName=driver.findElement(By.name("last_name"));
		lasttName.click();
		lasttName.sendKeys(lname);
		Thread.sleep(1000);
		
		WebElement company=driver.findElement(By.name("company"));
		company.click();
		company.sendKeys(com);
		Thread.sleep(1000);
		
		WebElement address =driver.findElement(By.id("address1"));
		address.click();
		address.sendKeys(addr);
		Thread.sleep(1000);
		
		WebElement state=driver.findElement(By.name("state"));
		state.click();
		state.sendKeys(st);
		Thread.sleep(1000);
		
		WebElement city=driver.findElement(By.id("city"));
		city.click();
		city.sendKeys(c);
		Thread.sleep(1000);
		
		WebElement zipcode=driver.findElement(By.id("zipcode"));
		zipcode.click();
		zipcode.sendKeys(zcode);
		Thread.sleep(1000);
		
		WebElement mobile_number=driver.findElement(By.id("mobile_number"));
		mobile_number.click();
		mobile_number.sendKeys(phn);
		Thread.sleep(1000);	
		
		 WebElement location2=driver.findElement(By.xpath("//*[contains(text(),'Create Account')]"));
		 js.executeScript("arguments[0].scrollIntoView(true);",location2 );
		 Thread.sleep(1000);
		 
		 
		 createAccount.click();
		 Thread.sleep(1000);
		
       }
	public void verifyUserAccount() throws InterruptedException {
		WebElement continueButton=driver.findElement(By.xpath("//a[@class=\"btn btn-primary\"]"));
		continueButton.click();
		Thread.sleep(1000);
	}
	
	public void doLogOut() throws InterruptedException {
		WebElement logOutButton=driver.findElement(By.xpath("//a[@href=\"/logout\"]"));
		logOutButton.click();
		Thread.sleep(1000);
	}
}
