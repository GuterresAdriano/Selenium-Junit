package br.com.dbserver.selenium_jupiter.tasks;

import org.openqa.selenium.WebDriver;

import br.com.dbserver.selenium_jupiter.appObjects.ShippingAppObject;

public class ShippingTasks {
	private ShippingAppObject appObject;

	public ShippingTasks(WebDriver driver) {
		this.appObject = new ShippingAppObject(driver);
	}	
	public void confirmShipping() {
		this.appObject.getIGreeCheckbox().click();
		this.appObject.getProceedCheckoutButton().click();		
	}
}
