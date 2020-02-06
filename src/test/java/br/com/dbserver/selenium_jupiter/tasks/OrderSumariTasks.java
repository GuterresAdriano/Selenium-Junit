package br.com.dbserver.selenium_jupiter.tasks;

import org.openqa.selenium.WebDriver;

import br.com.dbserver.selenium_jupiter.appObjects.OrderSumariAppObject;

public class OrderSumariTasks {
	
	private OrderSumariAppObject appObject ;
	
	public OrderSumariTasks(WebDriver driver) {
		super();
		this.appObject = new OrderSumariAppObject(driver);
	}	
	public void clickIconfirmmButton() {
		this.appObject.getIconfirmButton().click();
	}
}
