package br.com.dbserver.selenium_jupiter.appObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.dbserver.selenium_jupiter.tools.ElementsTools;

public class ShippingAppObject {
	
	private WebDriver driver;
	
	public ShippingAppObject(WebDriver driver){
		this.driver = driver;		
	}		
	public WebElement getIGreeCheckbox() {
		return ElementsTools.waitForElement(this.driver, By.id("cgv"));	
	}	
	public WebElement getCarrierRadioButton() {
		return ElementsTools.waitForElement(this.driver, By.cssSelector("input.delivery_option_radio"));
	}	
	public WebElement getProceedCheckoutButton() {
		return ElementsTools.waitForElement(this.driver, By.cssSelector("button[name='processCarrier'] > span"));
	}
}
