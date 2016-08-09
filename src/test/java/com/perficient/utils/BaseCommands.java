package com.perficient.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseCommands {
	
	public By locatorValue(String locatorType,String locatorValue){
		   
		   By by;
		   switch(locatorType){
		   
		   case "id":
			   by = By.id(locatorValue);
			   break;
		  
		   case "name":
			   by = By.name(locatorValue);
			   break;
			   
		   case "linkText":
			   by = By.linkText(locatorValue);
			   break;
			   
		   case "cssSelector":
			   by = By.cssSelector(locatorValue);
			   break;			   
	
		   case "partialLinkText":
			   by = By.partialLinkText(locatorValue);
			   break;
		
		   case "tagName":
			   by = By.tagName(locatorValue);
			   break;
			   
		   case "xpath":
			   by = By.xpath(locatorValue);
			   break;
		   		
		   default:
		      by = null;
		      break;
		   }    
		  return by;
		   
		}

	
	public static WebElement findElement(By by){
		return Driver.driver.findElement(by);
	}
	
	public void sendKeys(By by, String text){
		findElement(by).sendKeys(text);
	}
	
    public void clearText(By by){
    	findElement(by).clear();
    }
    
    public void click(By by){
    	findElement(by).click();
    }
	
    
    public void test(){
    	By by = By.id("test");
    	clearText(by);
    	sendKeys(by,"testtext");
    }
}
