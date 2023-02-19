package com.qa.factory;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	/**
	 * This method is used to initialize the threadlocal driver on the basis of given browser
	 * @param browser
	 * @return
	 */

	public WebDriver initDriver(String browser, String driverPath) {
	  
		WebDriver driver = null;
		System.out.println("browser value is: "+ browser);
		
		if(browser.equals("chrome")) {
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.addArguments("--no-sandbox");
			chromeoptions.addArguments("--ignore-ssl-errors=yes");
			chromeoptions.addArguments("--ignore-certificate-errors");
			chromeoptions.addArguments("--disable-dev-shm-usage");
		//	chromeoptions.addArguments("--headless");
			if(!StringUtils.isBlank(driverPath))
			{
				System.setProperty("webdriver.chrome.driver", driverPath);
			}
			driver = new ChromeDriver(chromeoptions);
			tlDriver.set(driver); 
		} else { 
			System.out.println("Please pass the correct browser value: " + browser);
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		return getDriver();
	}
	
	/**
	 * this is used to get the driver with ThreadLocal
	 * @return
	 */
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
