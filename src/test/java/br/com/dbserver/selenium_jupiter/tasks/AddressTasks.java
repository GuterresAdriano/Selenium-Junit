package br.com.dbserver.selenium_jupiter.tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.dbserver.selenium_jupiter.appObjects.AddressAppObject;

public class AddressTasks {
	
	private AddressAppObject addressAppObject;
	
	public AddressTasks(WebDriver driver) {
		super();
		this.addressAppObject = new AddressAppObject(driver);		
	}	
	public String getAddressNameLabel() {		
		WebElement element = this.addressAppObject.getAddressNameLabel();
		return element.getText();
	}	
	public String getCompanyLabel() {
		WebElement element = this.addressAppObject.getCompanyLabel();
		return element.getText();		
	}	
	public String getAddressLabel() {
		WebElement element = this.addressAppObject.getAddressLabel(); 
		return element.getText();
	}	
	public String getCityStatePostCodeLabel() {
		WebElement element = this.addressAppObject.getCityStatePostCodeLabel();
		return element.getText();
	}	
	public String getCountryLabel() {
		WebElement element = this.addressAppObject.getCountryLabel();
		return element.getText();
	}	
	public String getMobileLabel() {
		WebElement element = this.addressAppObject.getMobileLabel();
		return element.getText();
	}	
	public void clickProceedCheckoutButton() {
		WebElement element = this.addressAppObject.getProceedCheckoutButton();
		element.click();
	}
}
