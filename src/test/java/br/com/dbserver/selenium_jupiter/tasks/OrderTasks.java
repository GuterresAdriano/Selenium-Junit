package br.com.dbserver.selenium_jupiter.tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.dbserver.selenium_jupiter.appObjects.OrderAppObject;

public class OrderTasks {
	private OrderAppObject appObject;
	
	public OrderTasks(WebDriver driver) {
		super();
		this.appObject = new OrderAppObject(driver);		
	}
	
	public String getProductNameLabel() {
		WebElement element = appObject.getProductNameLabel();
		return element.getText();
	}	
	public String getProductQtdLabel() {
		WebElement element = appObject.getProductQtdLabel(); 	
		return element.getAttribute("value");
	}
	public String getProductPriceLabel() {	
		WebElement element = appObject.getProductUnitPriceLabel();
		return element.getText();
	}
	public String getProductPriceTotalLabel() {
		WebElement element = appObject.getProductTotalPriceLabel();
		return element.getText();
	}		
	
	public String getOrderTotalAllProductsLabel() {
		WebElement element = appObject.getOrderTotalProductsLabel();
		return element.getText();
	}
	public String getTotalShippingLabel() {
		WebElement element = appObject.getOrderTotalShippinglLabel();
		return element.getText();
	}	
	public String getTotalWithoutTaxLabel() {
		WebElement element = appObject.getOrderTotalWithoutTaxLabel();
		return element.getText();
	}
	public String getTotalTaxLabel() {
		WebElement element = appObject.getOrderTotalTaxlLabel();
		return element.getText();
	}	
	public String getTotalOrderLabel() {
		WebElement element = appObject.getOrderTotalOrderLabel();
		return element.getText();
	}	
	public void clickProceedToCheckoutButton() {
		WebElement element = this.appObject.getProceedToCheckoutButton();
		element.click();
	}
	
}
