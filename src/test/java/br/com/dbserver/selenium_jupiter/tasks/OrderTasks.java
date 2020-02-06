package br.com.dbserver.selenium_jupiter.tasks;

import org.openqa.selenium.WebDriver;

import br.com.dbserver.selenium_jupiter.appObjects.OrderAppObject;

public class OrderTasks {
	private OrderAppObject appObject;
	
	public OrderTasks(WebDriver driver) {
		this.appObject = new OrderAppObject(driver);		
	}		
	public void clickProceedToCheckoutButton() {
		this.appObject.getProceedToCheckoutButton().click();
	}
}
