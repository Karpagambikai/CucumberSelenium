package com.perficient.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseCommands {
	
	public int waitTime = 10;
	WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
	
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
 	
 	
 	// To get the title of the page
 	
 	public String getTitle(){
 		String pageTitle = getDriver().getTitle();
 		return pageTitle;
 	}
 	
 	// To get URL
 	
 	public String getCurrentUrl(){
 		String pageUrl = getDriver().getCurrentUrl();
 		return pageUrl;
 	}
 	
 	// To get page source
 	
 	public String getPageSource(){
 		String pagesource = getDriver().getPageSource();
 		return pagesource;
 	}
 	
 	// Window Handles
 	
 	//To get main window handle
 	
 	public String getMainWindowHandle(){
 		String mainWindow = getDriver().getWindowHandle();
 		return mainWindow;
 	}
 	
 	//To get the window handle of all the current windows
 	
 	public Set<String> getAllWindowHandles(){
 		Set<String> windowHandles =  getDriver().getWindowHandles();
 		return windowHandles;
 	}
    
 	// To switch between named windows
 	
 	public void switchWindow(String windowname){
 		getDriver().switchTo().window(windowname);
 	}
 	
 	
 	// To close the current browser
 	
 	public void closeBrowser(){
 		getDriver().close();
 	}
 	
 	
 	// To close all opened windows except main window
 	
 	public void closeWindows(){
 		String mainWind = getMainWindowHandle();
 		Set<String> childWind = getAllWindowHandles();
 		for(String currentWindow:childWind){
 		if(!currentWindow.equals(mainWind)){
 			switchWindow(currentWindow);
 			closeBrowser();
 		}
 		switchWindow(mainWind);
 		}
 	}
 	
 	// To switch to frame by index
 	
 	public void switchFrameByIndex(int index){
 		getDriver().switchTo().frame(index);
 	}
 	
 	// To switch to frame by id or name
 	
 	public void switchFrameById(String locator){
 		getDriver().switchTo().frame(locator);
 	}
 	
 	// To check element is present
 	public boolean isElePresent(By by){
 		boolean elementPresent;
 		int eleSize = findElements(by).size();
 		if(eleSize!=0){
 			elementPresent = true;
 			return elementPresent;
 		}else{
 			elementPresent = false;
 			return elementPresent;
 		}
 	}
 	
 	
 	// To switch to frame by frame element
 	
 	public void switchFrameByFrameElement(By by){
 		try{
 			if(findElements(by).size()!=0){
 				WebElement frameElement = findElement(by);
 				getDriver().switchTo().frame(frameElement);	
 			}
 		}catch(NoSuchFrameException e) {
			System.out.println("Unable to locate frame with element " + e.getStackTrace());
 			
 		}catch(StaleElementReferenceException e){
 			System.out.println("Unable to locate frame with element " + e.getStackTrace());
 		}catch(Exception e){
 			System.out.println("Unable to locate frame with element " + e.getStackTrace());
 		}
 	   
 	}
 	
 	// switching between multiple frames
 	
 	public void switchBetweenFrames(String parentFrame, String childFrame){
 		getDriver().switchTo().frame(parentFrame).switchTo().frame(childFrame);
 	}
 	
 	// To navigate back to page from frame
 	
 	public void switchBack(){
 		getDriver().switchTo().defaultContent();
 	}
 	
 	// To click ok button in the alert
 	
 	public void acceptAlert(){
 		Alert alert = getDriver().switchTo().alert();
 		alert.accept();
 	}
 	
 	
 	// To click cancel button in the alert
 	
 	public void dismissAlert(){
 		Alert alert = getDriver().switchTo().alert();
 		alert.dismiss();
 	}
 	
 	// To get the text present on the alert
 	
 	public String getAlertText(){
 		Alert alert = getDriver().switchTo().alert();
 		String alertText = alert.getText();
 		return alertText;
 	}
 	
 	// To pass the text to the prompt pop up
 	
 	public void sendKeysAlert(String alertText){
 		Alert alert = getDriver().switchTo().alert();
 		alert.sendKeys(alertText);
 		System.out.println(alert.getText());
 		alert.accept();
 	}
 	
    // The expected condition waits for an element to be click-able.	
    // i.e. it should be present/displayed/visible on the screen as well as enabled.
    public void waitForClickable(By by) {
    	waitForElement(by);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
    
    // An expectation for checking that an element is present on the DOM of a page.
    public void waitForElement(By by){
    	wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    
    // An expectation for checking that there is at least one element present on a web page.
    public void waitForAllElements(By by){
    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

	// An expectation for checking that an element is present on the DOM of a page and visible.
    public void waitForVisibility(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	// An expectation for checking that an element is either invisible or not present on the DOM.
    public void waitForInvisibility(By by){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	// An expectation for checking if the given element is selected.
    public void waitForElementToBeSelected(By by){
		wait.until(ExpectedConditions.elementToBeSelected(by));
	}
    
    // check Element present by By
 	public static boolean isElementPresent(By by) {
 		try {
 			getDriver().findElement(by);
 			return true;
 		} catch (NoSuchElementException e) {
 			return false;
 		}
 	}
	
    // The expected condition waits for an alert box to appear.
    public void waitForAlertPresent(){
		//wait.until(ExpectedConditions.alertIsPresent());
		if(wait.until(ExpectedConditions.alertIsPresent())==null)
		    System.out.println("alert was not present");
		else
		    System.out.println("alert was present");
	}
	
    // wait for page to load
	public void pageLoadTimeout(int seconds) {
		getDriver().manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
	}
	
	// create screen shots
	public static void getScreenshot(String Status) throws Exception {
		File dir = new File("");
		if (!dir.exists()) {
			dir.mkdir();
		}
		File srcfile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile,new File(new SimpleDateFormat("'resources/screenshots/"+ Status + "_Screenshot_'yyyyMMdd_hhmmss'.png'").format(new Date())));
	}
    
	// This methods Load a new web page in the current browser window. 
	// It is an Overloaded version of to(String) that makes it easy to pass in a URL.
	public void navigateToURL(String url)
	{
		getDriver().navigate().to(url);
	}
	
	// To move back a single "item" in the web browser's history. 
	// And it will not perform any action if you are on the first page viewed.
	public void navigateBack()
    {
		getDriver().navigate().back();
	}
    
	// To move a single "item" forward in the web browser's history. 
	// And it will not perform any action if we are on the latest page viewed.
	public void navigateForward()
    {
		getDriver().navigate().forward();
	}
	
	// It refreshes the current web page.
	public void navigateRefresh()
    {
		//getDriver().navigate().refresh();
		Actions actions = new Actions(getDriver());
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
    }
 	
}
