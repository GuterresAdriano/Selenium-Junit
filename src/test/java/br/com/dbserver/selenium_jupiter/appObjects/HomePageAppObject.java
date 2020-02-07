package br.com.dbserver.selenium_jupiter.appObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.dbserver.selenium_jupiter.tools.ElementsTools;

public class HomePageAppObject {
	
	private WebDriver driver;
	
	public HomePageAppObject(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getTitlesMenuDresses() {		
		return ElementsTools.waitForElement(this.driver, By.cssSelector("ul.sf-menu > li > [title='Dresses']"));
	}	
	public WebElement getFirstItemBlock() {		
		return ElementsTools.waitForElement(this.driver, By.cssSelector(".first-item-of-tablet-line.first-in-line .product-name")); 
	}			
}
