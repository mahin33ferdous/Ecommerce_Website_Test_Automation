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
	
	@FindBy(xpath="//input[@name='name']")
	WebElement name;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement email;
	
	@FindBy(xpath="//*[contains(text(),'Signup')and @type='submit']")
	WebElement signupSubmit;

	
	public void register() throws InterruptedException {
		signup.click();
		Thread.sleep(3000);
		
		name.click();
		name.sendKeys("Mahin");
		Thread.sleep(3000);
		email.sendKeys("mahin11@gmail.com");
		Thread.sleep(3000);
		signupSubmit.click();
	}
	
	public void informationPage() throws InterruptedException {
		//driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
		WebElement button=driver.findElement(By.xpath("//*[@id='id_gender2']"));
		button.click(); 
		boolean exp=true;
		boolean act=button.isSelected();
		Assert.assertEquals(act, exp);
		Thread.sleep(3000);//*[@id='password']
		
		WebElement password=driver.findElement(By.xpath("//*[@id='password']"));
		password.click();
		password.sendKeys("1234");
		Thread.sleep(3000);
		
		WebElement days=driver.findElement(By.xpath("//*[@id='days']"));
		Select selectDay=new Select(days);
		selectDay.selectByIndex(5);
		Thread.sleep(3000);
		
		WebElement months=driver.findElement(By.xpath("//*[@id='months']"));
		Select selectMonth=new Select(months);
		selectMonth.selectByIndex(6);
		Thread.sleep(3000);
		
		WebElement years=driver.findElement(By.xpath("//*[@id='years']"));
		Select selectYear=new Select(years);
		selectYear.selectByIndex(6);
		Thread.sleep(3000);
		
		WebElement check=driver.findElement(By.xpath("//input[@id='newsletter']"));
		check.click();
		Thread.sleep(3000);
		
		
	}
	
	public void addressInfo() throws InterruptedException {
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 // Scrolling dowm
		 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 Thread.sleep(2000);
		 
		 // Scrolling down to the featured items
		 WebElement location=driver.findElement(By.xpath("//*[contains(text(),'Address Information')]"));
		 js.executeScript("arguments[0].scrollIntoView(true);",location );
		 
		WebElement firstName=driver.findElement(By.xpath("//input[@name='first_name']"));
		firstName.click();
		firstName.sendKeys("Mahin");
		Thread.sleep(2000);
		
		WebElement lasttName=driver.findElement(By.name("last_name"));
		lasttName.click();
		lasttName.sendKeys("Ferdous");
		Thread.sleep(2000);
		
		WebElement company=driver.findElement(By.name("company"));
		company.click();
		company.sendKeys("xyz company");
		Thread.sleep(2000);
		
		WebElement address =driver.findElement(By.id("address1"));
		address.click();
		address.sendKeys("ecb road, 1206");
		Thread.sleep(2000);
		
		WebElement state=driver.findElement(By.name("state"));
		state.click();
		state.sendKeys("dhaka");
		Thread.sleep(2000);
		
		WebElement city=driver.findElement(By.id("city"));
		city.click();
		city.sendKeys("dhaka");
		Thread.sleep(2000);
		
		WebElement zipcode=driver.findElement(By.id("zipcode"));
		zipcode.click();
		zipcode.sendKeys("1216");
		Thread.sleep(2000);
		
		WebElement mobile_number=driver.findElement(By.id("mobile_number"));
		mobile_number.click();
		mobile_number.sendKeys("444444444");
		Thread.sleep(2000);	
		
		 WebElement location2=driver.findElement(By.xpath("//*[contains(text(),'Create Account')]"));
		 js.executeScript("arguments[0].scrollIntoView(true);",location2 );
		 Thread.sleep(2000);	


		
	}
}
