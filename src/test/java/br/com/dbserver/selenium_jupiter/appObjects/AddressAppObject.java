package br.com.dbserver.selenium_jupiter.appObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.dbserver.selenium_jupiter.tools.ElementsTools;

public class AddressAppObject {
	private WebDriver driver;
	
	public AddressAppObject(WebDriver driver) {
		this.driver = driver;			
	}	
	public WebElement getAddressNameLabel() {
		return ElementsTools.waitForElement(this.driver, By.cssSelector("li[class='address_firstname address_lastname']"));
	}	
	public WebElement getCompanyLabel() {
		return ElementsTools.waitForElement(this.driver, By.cssSelector("li[class='address_company']"));
	}	
	public WebElement getAddressLabel() {
		return ElementsTools.waitForElement(this.driver, By.cssSelector("li[class='address_address1 address_address2']"));
	}	
	public WebElement getCityStatePostCodeLabel() {
		return ElementsTools.waitForElement(this.driver, By.cssSelector("li[class='address_city address_state_name address_postcode']"));
	}	
	public WebElement getCountryLabel() {
		return ElementsTools.waitForElement(this.driver, By.cssSelector("li[class='address_country_name']"));
	}	
	public WebElement getMobileLabel() {
		return ElementsTools.waitForElement(this.driver, By.cssSelector("li[class='address_phone_mobile']"));
	}	
	public WebElement getProceedCheckoutButton() {
		return ElementsTools.waitForElement(this.driver, By.name("processAddress"));
	}

}
