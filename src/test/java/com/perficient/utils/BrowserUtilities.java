package com.perficient.utils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;


public class BrowserUtilities {
	
	public File path = new File("src/test/resources/drivers");
	
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
