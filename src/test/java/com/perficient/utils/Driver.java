package com.perficient.utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Driver{

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public String browser = null;
	public String url = null;
	public File path = new File("src/test/resources/drivers");
	CommonFunctions cfun = new CommonFunctions();
	
	@Before
	public WebDriver launchBrowser(WebDriver driver){
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
	public WebDriver quitBrowser(WebDriver driver){	
		driver.quit();
		return driver;
	}
	
	public WebDriver launchFirefoxBrowser(WebDriver driver){  
    	driver = new FirefoxDriver();
    	return driver;
      }
	
	public WebDriver launchInternetExplorerDriver(WebDriver driver){   	  
  	  DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
  	  capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
  	  System.setProperty("webdriver.ie.driver",path.getAbsolutePath() + "\\IEDriverServer.exe");
  	  driver = new InternetExplorerDriver();
  	  return driver;    	  
    }
    
    public WebDriver launchChromeDriver(WebDriver driver){  
  	  System.setProperty("webdriver.chrome.driver",path.getAbsolutePath() + "\\chromedriver.exe");
  	  driver = new ChromeDriver();
  	  return driver;
    }
    
    public WebDriver launchSafariDriver(WebDriver driver){
  	  driver = new SafariDriver();
  	  return driver;
    }
    
    public WebDriver getApplicationUnderTest(WebDriver driver,String url){
  	  driver.get(url);
  	  return driver;
    }
		
}
