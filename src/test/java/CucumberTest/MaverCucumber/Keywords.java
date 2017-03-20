
/**
 * @author Syed Mustafizur Rahman
 * 
 * Date started: 03/19/2017
 * Last modified on: 03/20/2017
 */

package CucumberTest.MaverCucumber;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.Select;



public class Keywords {
	
	WebDriver driver;	
	WebElement element;
	
	public Keywords(WebDriver driver)
	{
		this.driver=driver;
	}

	/**
	 * @author Syed Mustafiz
	 * Setting the browser where to launch the application
	 * 
	 * @param browser
	 * @return
	 */

	public WebDriver setBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("IE"))
		{driver = new InternetExplorerDriver();}
		else if(browser.equalsIgnoreCase("Firefox"))
		{driver = new FirefoxDriver();}
		else {{driver = new ChromeDriver();}}
		
		return driver;
				
	}
			
	/**  
	 * The 'launchApplication' keyword-method launches a chosen
	 * web application with it's URL in a chosen web-browser
	 * 
	 * @param URL
	 * @throws InterruptedException 
	 */

	public void launchApplication(String URL) throws InterruptedException
	{		
		driver.get(URL);
		Thread.sleep(3000);
	}
	
	public void clickElement(String property, String locator)
	{  
		switch (property) {
		case "id" :
			element = driver.findElement(By.id(locator));
			break;
		
		case "className" :
			element = driver.findElement(By.className(locator));
			break;
			
		case "name" :
			element = driver.findElement(By.name(locator));
			break;
			
		case "xpath" :
			element = driver.findElement(By.xpath(locator));
			break;
			
		case "cssSelector" :
			element = driver.findElement(By.cssSelector(locator));
			break;
			
		case "linkText" :
			element = driver.findElement(By.linkText(locator));
			break;		
			
		case "partialLinkText" :
			element = driver.findElement(By.partialLinkText(locator));
			break;
			
	}	
		if(element.isDisplayed() && element.isEnabled())
		{
			element.click();
		}
		else
		{
			System.out.println("Element could not be clicked");
		}
	}
	
	public void type (String property, String locator, String input)
	{  
		switch (property) {
		case "id" :
			element = driver.findElement(By.id(locator));
			break;
		
		case "className" :
			element = driver.findElement(By.className(locator));
			break;
			
		case "name" :
			element = driver.findElement(By.name(locator));
			break;
			
		case "xpath" :
			element = driver.findElement(By.xpath(locator));
			break;
			
		case "cssSelector" :
			element = driver.findElement(By.cssSelector(locator));
			break;
			
		case "linkText" :
			element = driver.findElement(By.linkText(locator));
			break;		
			
		case "partialLinkText" :
			element = driver.findElement(By.partialLinkText(locator));
			break;
			
	}		
		element.sendKeys(input);
	}
	
	
	public void verifyElement (String property, String locator)
	{  
		switch (property) {
		case "id" :
			element = driver.findElement(By.id(locator));
			break;
		
		case "className" :
			element = driver.findElement(By.className(locator));
			break;
			
		case "name" :
			element = driver.findElement(By.name(locator));
			break;
			
		case "xpath" :
			element = driver.findElement(By.xpath(locator));
			break;
			
		case "cssSelector" :
			element = driver.findElement(By.cssSelector(locator));
			break;
			
		case "linkText" :
			element = driver.findElement(By.linkText(locator));
			break;		
			
		case "partialLinkText" :
			element = driver.findElement(By.partialLinkText(locator));
			break;
			
	}		
		if(element.isEnabled())
		{System.out.println("The element is enabled");}
		else{System.out.println("The element is not enabled");}
		
		if(element.isDisplayed())
		{System.out.println("The element is displayed");}
		else{System.out.println("The element is not displayed");}
	}
	
	public void validateText (String text)
	{  
		if(driver.getPageSource().contains(text))
		{
			System.out.println("The text is present!");
		}
		else
		{
			System.out.println("The text is not present!");
		}
	}
	
	public void switchWindow()
	{
		String parentWindow = driver.getWindowHandle();  // Parent window handler
		
		Set<String> wHandles = driver.getWindowHandles();  //Using 'Set' as 'Set' keeps unique items only
		
		for(String wHandle: wHandles)
		{
			System.out.println("Now in window of: " + wHandle);
			
			if(!wHandle.equals(parentWindow))
			{
				driver.switchTo().window(wHandle);
			}
		}
	}
	
	public void closeCurrentWindow()
	{
		driver.close();
	}
	
	public void switchToIFrame(String identifierValue) throws InterruptedException
	{
		Thread.sleep(3000);
		
		driver.switchTo().frame(identifierValue); // This 'identifierValue' can be value of only 'id' or 'name' of the iframe.
		
	}
	
	public void switchToIFrameByIndex(int index) throws InterruptedException
	{
		Thread.sleep(3000);
		
		driver.switchTo().frame(index); // This 'index' can be 0, 1 ...
		
	}
	
	public void switchBackFromIframe() throws InterruptedException
	{
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
	}
	
	/**
	 * This 'switchToIFrameByElement' keyword method is used to switch to any iframe 
	 * when only id, name or index is not enough to locate the iframe
	 * 
	 * @param property
	 * @param locator
	 * @param element
	 * @throws InterruptedException
	 */
	
	public void switchToIFrameByElement(String property, String locator, WebElement element) throws InterruptedException
	{	
		switch (property) {
		case "id" :
			element = driver.findElement(By.id(locator));
			break;
		
		case "className" :
			element = driver.findElement(By.className(locator));
			break;
			
		case "name" :
			element = driver.findElement(By.name(locator));
			break;
			
		case "xpath" :
			element = driver.findElement(By.xpath(locator));
			break;
			
		case "cssSelector" :
			element = driver.findElement(By.cssSelector(locator));
			break;
			
		case "linkText" :
			element = driver.findElement(By.linkText(locator));
			break;		
			
		case "partialLinkText" :
			element = driver.findElement(By.partialLinkText(locator));
			break;
			
	}
		Thread.sleep(3000);
		
		driver.switchTo().frame(element); // This 'element' is the 'iframe-element'
		
	}
	
	public void jsAlertAccept() throws InterruptedException
	{
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void jsAlertDismiss() throws InterruptedException
	{
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	private String getRandomString(int length) {

		StringBuilder sb = new StringBuilder();
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYXabcdefghijklmnopqrstuvwxyz1234567890";
		
		for(int i=0; i< length; i++)
		{
			int index = (int) Math.random() * characters.length();
			sb.append(characters.charAt(index));
		}
		
		return sb.toString();
	}
	
	public void captureSnapshot(String directory) throws Exception
	{
		String fileName = getRandomString(10) + ".png";
		
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
	}
	
	
	public void pressKeyboardButton(String strKeyToPress)  //Still under development
	{
		Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
		
		switch (strKeyToPress){
		case "F5" :
		keyboard.pressKey(Keys.F5);
		break;
		case "F6" :
		keyboard.pressKey(Keys.F6);
		break;
		}
		
	}
	
	public void pressKeyboardKeys(CharSequence[] sKeysToSend)   //Still under development
	{
		Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
		keyboard.sendKeys(sKeysToSend);
	}	
	
	public WebElement locateElement(String property, String locator)
	{
		switch (property) {
		case "id" :
			element = driver.findElement(By.id(locator));
			break;
		
		case "className" :
			element = driver.findElement(By.className(locator));
			break;
			
		case "name" :
			element = driver.findElement(By.name(locator));
			break;
			
		case "xpath" :
			element = driver.findElement(By.xpath(locator));
			break;
			
		case "cssSelector" :
			element = driver.findElement(By.cssSelector(locator));
			break;
			
		case "linkText" :
			element = driver.findElement(By.linkText(locator));
			break;		
			
		case "partialLinkText" :
			element = driver.findElement(By.partialLinkText(locator));
			break;			
	}
		return element;
	}
	
	public void mouseHoverToElement(String property, String locator) throws Exception
	{
		element = locateElement(property, locator);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		Thread.sleep(2000);
	}
	
	public void dragAndDropElement(String property, String locator) throws Exception
	{
		WebElement fromElement = locateElement(property, locator);
		WebElement toElement = locateElement(property, locator);
		
		Actions action = new Actions(driver);
		action.dragAndDrop(fromElement, toElement).perform();
		Thread.sleep(1000);
	}
	
	
	public void javascriptToLocateElement(String jScript)  // Example, jString = "return document.getElementById('eId');"
	{
		JavascriptExecutor jsX = (JavascriptExecutor) driver;
		element = (WebElement) jsX.executeScript(jScript);
	}
	
	//public void hiddenElement(){}
	
	public void selectDropDownElementByValue(String property, String locator, String value)
	{
		Select sel = (Select) locateElement(property, locator);
		sel.selectByValue(value);
		
	  //	Select sel2 = new Select(locateElement(property, locator));  //==> Also fine.
	}
	
	public void selectDropDownElementByIndex(String property, String locator, int index)
	{
		Select sel = (Select) locateElement(property, locator);
		sel.selectByIndex(index);
	}
	
	public String getElementText(String property, String locator)
	{
		element = locateElement(property, locator);
		String elementText = element.getText();
		
		return elementText;
	}
	
	public String getElementAttributeValue(String property, String locator, String attribute)
	{
		element = locateElement(property, locator);
		String attributeValue = element.getAttribute(attribute);
		
		return attributeValue;
	}

}
