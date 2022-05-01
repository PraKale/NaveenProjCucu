package com.qa.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
//	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();
	/**
	 * This method uses ThreadLocal concept to initialize the browser
	 */
	public WebDriver init_driver(String browser) {
		switch(browser) {
		case "chrome": {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
			break;
		}
		case "ff": {
//			System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
			break;
		}
	}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	//Using synchronized keyword for multi-threaded application
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
}
