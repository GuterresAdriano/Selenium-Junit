package br.com.dbserver.selenium_jupiter.tasks;

import org.openqa.selenium.WebDriver;

import br.com.dbserver.selenium_jupiter.appObjects.PaymentAppObject;

public class PaymentTasks {
	private PaymentAppObject appObject;
	
	public PaymentTasks(WebDriver driver) {
		this.appObject = new PaymentAppObject(driver);		
	}	
	public void clickBankWireButton() {
		this.appObject.getBankWireButton().click();
	}	
}
