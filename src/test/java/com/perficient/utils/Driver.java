package com.perficient.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Driver extends BrowserUtilities{

	public static WebDriver driver;
	public String browser = null;
	public String url = null;
	CommonFunctions cfun = new CommonFunctions();
	
	
	
	@Before
	public WebDriver launchBrowser(){
		browser = cfun.readProperties("browser");
		System.out.println("Browser Type"+browser);
		url = cfun.readProperties("url");
		System.out.println("URL"+url);
		try{
		if(browser.equalsIgnoreCase("FF")||browser.equalsIgnoreCase("Firefox")){
			driver = launchFirefoxBrowser(driver);
		} else if(browser.equalsIgnoreCase("IE")||browser.equalsIgnoreCase("Internet Explorer")){
			driver = launchInternetExplorerDriver(driver);
		} else if(browser.equalsIgnoreCase("Chrome")){
			driver = launchChromeDriver(driver);
		} else if(browser.equalsIgnoreCase("Safari")){
			driver = launchSafariDriver(driver);			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getApplicationUnderTest(driver,url);
		}catch(Exception e){
			e.printStackTrace();
		}
		return driver;
	}
	
	@After
	public WebDriver quitBrowser(){	
		driver.quit();
		return driver;
	}
	
}
