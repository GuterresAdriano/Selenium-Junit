package br.com.dbserver.selenium_jupiter.appObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.dbserver.selenium_jupiter.tools.ElementsTools;

public class ItemPageAppObject {

	private WebDriver driver;	

	public ItemPageAppObject(WebDriver driver) {
		this.driver = driver;
	}			
	public WebElement getAddCartButton() {
		return ElementsTools.waitForElement(this.driver, By.cssSelector("button[name='Submit'] > span"));
	}	
	public WebElement getProceedToCheckoutButton() {
		return ElementsTools.waitForElement(this.driver, By.cssSelector("a.button-medium > span"));
	}		
}
