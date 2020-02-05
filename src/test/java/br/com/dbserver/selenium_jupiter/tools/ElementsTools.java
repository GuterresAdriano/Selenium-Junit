package br.com.dbserver.selenium_jupiter.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsTools {

	public static WebElement waitForElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30); 
		return wait.until(ExpectedConditions.elementToBeClickable(locator));		
	}	
	
	public static void highlightElement(WebDriver driver, WebElement element){		
		((JavascriptExecutor) driver).executeScript("scroll(0, 500);", element);
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='2px solid red'", element);
	}
	
	public static void unHighlightElement(WebDriver driver, WebElement element){ 
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border=''", element);	
	}
	

}
