package com.perficient.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseCommands {
	
	/*public By locatorValue(String locatorType,String locatorValue){
		   
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
		   
		}*/
	
	public static WebDriver getDriver() {
		return Driver.driver.get();
	}

	 // Find Element
	public static WebElement findElement(By by){
		return getDriver().findElement(by);
	}
	
	 // Find Elements
	public static List<WebElement> findElements(By by){
		return getDriver().findElements(by);
	}
	
	public void sendKeys(By by, String text, boolean clear){
		if(clear){
			findElement(by).clear();
		    findElement(by).sendKeys(text);
		}else{
			findElement(by).sendKeys(text);
		}
	}
	
    public void click(By by){
    	findElement(by).click();
    }
	
    public String getText(By by){
    	return findElement(by).getText();
    }
    
    public String getAttribute(By by, String name){
    	String attribute = findElement(by).getAttribute(name);
    	return attribute;
    }
    
    
    
    // DropDown - Select By Index
    
    public void selectByIndex(By by, int index){
    	Select ddindex = new Select(findElement(by));
    	ddindex.selectByIndex(index);	
    }
    
    // DropDown - Select By Value
    
    public void selectByValue(By by,String value){
    	Select ddvalue = new Select(findElement(by));
    	ddvalue.selectByValue(value);    	
    }
    
    //DropDown - Select By Visible Text
    
    public void selectByVisibleText(By by,String visibletext){
    	Select ddvisibletext = new Select(findElement(by));
    	ddvisibletext.selectByVisibleText(visibletext);
    }
    
    // DropDown - To check whether the dropdown is multi select
    
    public boolean isMultiple(By by){
    	Select ismul = new Select(findElement(by));
    	if(ismul.isMultiple()){
    		return true;
    	}else{
    		return false;
    	} 	
    }
    
    // DropDown - To Select multiple options using select by index 
    public void selectMultipleOptions(By by,int indexstart, int indexend){
    	Select mulselect = new Select(findElement(by));
    	for(int seldd=indexstart; seldd<=indexend; seldd++){
    	mulselect.selectByIndex(seldd);
    	}  	
    }
    
    // DropDown - To select multiple options using select by value or visible text
    public void mulOptionsByValueVisibleText(By by, String selectiontype, List<String> selectiontext){
    	Select mulvalue = new Select(findElement(by));
    	if(selectiontype.equalsIgnoreCase("Value")){
    		for(String options:selectiontext){
    		   System.out.println("Values to be selected"+options);
    		   mulvalue.selectByValue(options);
    		}
    	}else if(selectiontype.equalsIgnoreCase("Visible Text")){
    	   for(String opt:selectiontext){
    		System.out.println("Options to be selected"+opt);
    		mulvalue.selectByVisibleText(opt);
    	   }	
    	}
    }
    
    // DropDown - To get and print all the options present in the drop down
    public List<WebElement> getOptions(By by){
    	Select print = new Select(findElement(by));
    	List<WebElement> alloptions = print.getOptions();
    	for(WebElement web:alloptions){
    		System.out.println("Options in the dropdown"+web.getText());
    	}
    	return alloptions;
    }
    
    // DropDown - To get all the selected options in the drop down
    public List<WebElement> getSelectedOptions(By by){
    	Select selOptions =  new Select(findElement(by));
    	List<WebElement> selectedOptions = selOptions.getAllSelectedOptions();
    	for(WebElement sel:selectedOptions){
    		System.out.println("Selected Options in the drop down"+sel.getText());
    	}
    	return selectedOptions;
    }
    
    // DropDown - To get first selected option in the drop down
    
    public WebElement getFirstSelectedOption(By by){
    	Select selOpt = new Select(findElement(by));
    	WebElement selFirstOpt =  selOpt.getFirstSelectedOption();
    	System.out.println("First Selected Option"+selFirstOpt.getText());
    	return selFirstOpt;
    }
    
    // DropDown - Deselect All options
    
    public void deselectAll(By by){
    	Select deselect = new Select(findElement(by));
    	deselect.deselectAll();
    }
    
    
 // DropDown - Deselect By Index
    
    public void deselectByIndex(By by, int index){
    	Select dselindex = new Select(findElement(by));
    	dselindex.deselectByIndex(index);	
    }
    
    // DropDown - Deselect By Value
    
    public void deselectByValue(By by,String value){
    	Select dselvalue = new Select(findElement(by));
    	dselvalue.deselectByValue(value);;    	
    }
    
    //DropDown - Deselect By Visible Text
    
    public void deselectByVisibleText(By by,String visibletext){
    	Select dselvisibletext = new Select(findElement(by));
    	dselvisibletext.deselectByVisibleText(visibletext);
    }
    
    // DropDown - To Deselect multiple options using select by index 
    public void deselectMultipleOptions(By by,int indexstart, int indexend){
    	Select deselect = new Select(findElement(by));
    	for(int deseldd=indexstart; deseldd<=indexend; deseldd++){
    		deselect.deselectByIndex(deseldd);
    	}  	
    }
    
    // DropDown - To Deselect multiple options using select by value or visible text
    public void deselmulOptionsByValueVisibleText(By by, String deselectiontype, List<String> deselectiontext){
    	Select deselmulvalue = new Select(findElement(by));
    	if(deselectiontype.equalsIgnoreCase("Value")){
    		for(String options:deselectiontext){
    		   System.out.println("Values to be deselected"+options);
    		   deselmulvalue.deselectByValue(options);
    		}
    	}else if(deselectiontype.equalsIgnoreCase("Visible Text")){
    	   for(String opt:deselectiontext){
    		System.out.println("Options to be deselected"+opt);
    		deselmulvalue.deselectByVisibleText(opt);
    	   }	
    	}
    }
    
 // 6. Checkbox/Radio button

 	public boolean isSelected(By by) {
 		if (findElement(by).isSelected()) {
 			return true;
 		} else {
 			return false;
 		}
 	}
 	
 	public boolean isEnabled(By by) {
 		if (findElement(by).isEnabled()) {
 			return true;
 		} else {
 			return false;
 		}
 	}
 	
 	public boolean isDisplayed(By by) {
 		if (findElement(by).isDisplayed()) {
 			return true;
 		} else {
 			return false;
 		}
 	}
 	
 	//8.	Mouse Actions (Hover, Drag and Drop, Move to Element)
 	
 	public void mouseHover(int xOffset, int yOffset){
 		Actions builder=new Actions(getDriver());
 		builder.moveByOffset(xOffset, yOffset);
 	}
 	
 	public void mouseHover(By by){
 		Actions builder=new Actions(getDriver());
 		builder.moveToElement(findElement(by));
 	}
 	
 	public void mouseHover(By by, int xOffset, int yOffset){
 		Actions builder=new Actions(getDriver());
 		builder.moveToElement(findElement(by), xOffset, yOffset);
 	}
 	
 	public void dragDrop(By source,By target){
 		Actions builder=new Actions(getDriver());
 		builder.dragAndDrop(findElement(source), findElement(target));
 	}
 	
 	public void dragDrop(By source,int xOffset, int yOffset){
 		Actions builder=new Actions(getDriver());
 		builder.dragAndDropBy(findElement(source), xOffset, yOffset);
 	} 
    
}
