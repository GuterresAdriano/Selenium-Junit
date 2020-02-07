package br.com.dbserver.selenium_jupiter.appObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.dbserver.selenium_jupiter.tools.ElementsTools;

public class OrderAppObject {

	private WebDriver driver;

	public OrderAppObject(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getProductNameLabel() {
		return ElementsTools.waitForElement(this.driver, By.cssSelector("td.cart_description > .product-name > a"));	
	}	
	public WebElement getProductUnitPriceLabel() {				
		return ElementsTools.waitForElement(this.driver, By.cssSelector("td.cart_unit > .price > .price"));	
	}
	public WebElement getProductQtdLabel() {
		return ElementsTools.waitForElement(this.driver, By.cssSelector(".cart_quantity_input"));	
	}	
	public WebElement getProductTotalPriceLabel() {				
		return ElementsTools.waitForElement(this.driver, By.cssSelector("td.cart_total > .price"));	
	}		
	public WebElement getOrderTotalProductsLabel() {	
		return ElementsTools.waitForElement(this.driver, By.cssSelector("#total_product"));
	}	
	public WebElement getOrderTotalShippinglLabel() {			
		return ElementsTools.waitForElement(this.driver, By.cssSelector("#total_shipping"));
	}	
	public WebElement getOrderTotalWithoutTaxLabel() {			
		return ElementsTools.waitForElement(this.driver, By.cssSelector("#total_price_without_tax"));
	}
	public WebElement getOrderTotalTaxlLabel() {			
		return ElementsTools.waitForElement(this.driver, By.cssSelector("#total_tax"));
	}	
	public WebElement getOrderTotalOrderLabel() {			
		return ElementsTools.waitForElement(this.driver, By.cssSelector("#total_price"));
	}
	public WebElement getProceedToCheckoutButton() {
		return ElementsTools.waitForElement(this.driver, By.cssSelector("a.standard-checkout > span"));
	}
}
