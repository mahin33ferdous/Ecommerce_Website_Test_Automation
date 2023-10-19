package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class LogInPage extends BaseClass{
	public LogInPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

}
