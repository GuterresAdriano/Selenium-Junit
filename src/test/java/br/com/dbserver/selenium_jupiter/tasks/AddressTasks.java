package br.com.dbserver.selenium_jupiter.tasks;

import org.openqa.selenium.WebDriver;

import br.com.dbserver.selenium_jupiter.appObjects.AddressAppObject;

public class AddressTasks {
	
	private AddressAppObject addressAppObject;
	
	public AddressTasks(WebDriver driver) {
		this.addressAppObject = new AddressAppObject(driver);		
	}		
	public void clickProceedCheckoutButton() {
		this.addressAppObject.getProceedCheckoutButton().click();
	}
}
