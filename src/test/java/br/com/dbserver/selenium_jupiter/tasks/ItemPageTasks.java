package br.com.dbserver.selenium_jupiter.tasks;

import org.openqa.selenium.WebDriver;

import br.com.dbserver.selenium_jupiter.appObjects.ItemPageAppObject;

public class ItemPageTasks {
	private ItemPageAppObject appObject;

	public ItemPageTasks(WebDriver driver) {
		super();
		this.appObject = new  ItemPageAppObject(driver);
	}			
	public void addFirstItemDressesCart() {
		this.appObject.getAddCartButton().click();
		this.appObject.getProceedToCheckoutButton().click();		
	}	
}