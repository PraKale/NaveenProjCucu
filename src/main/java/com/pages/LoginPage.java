package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	//Web elements using By locator
	private By emailId=By.xpath("//input[@type='email']");
	private By password=By.xpath("//input[@type='password']");
	private By login=By.xpath("//button[@type='submit']");
	
	//Constructor to init driver
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//action methods
	public String getPageTitle() {
		return driver.getTitle();
	}
	public void enterUsername(String uname) {
		driver.findElement(emailId).clear();
		driver.findElement(emailId).sendKeys(uname);
	}
	public void enterPwd(String pwd) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pwd);
	}
	public void clickLogin() {
		driver.findElement(login).click();
	}
	
}
