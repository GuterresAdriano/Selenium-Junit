package br.com.dbserver.selenium_jupiter.appObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.dbserver.selenium_jupiter.tools.ElementsTools;

public class OrderAppObject {

	private WebDriver driver;

	public OrderAppObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getProductNameLabel() {
		WebElement table = ElementsTools.waitForElement(this.driver, By.cssSelector("#cart_summary > tbody"));	
		ArrayList<WebElement> td = new ArrayList<WebElement>();
		td.addAll( table.findElements(By.cssSelector("td")));	
		WebElement element = td.get(1);
		return element;
	}

	public WebElement getProductQtdLabel() {
		WebElement table = ElementsTools.waitForElement(this.driver,By.id("cart_summary"));	
		ArrayList<WebElement> rows = new ArrayList<WebElement>();
		rows.addAll( table.findElements(By.xpath("//*[@id=\"cart_summary\"]/tbody")));			
		ArrayList<WebElement> elements = (ArrayList<WebElement>) rows.get(0).findElements(By.cssSelector("td"));
		WebElement element = elements.get(4).findElement(By.cssSelector("input"));
		return element;
	}

	public WebElement getProductUnitPriceLabel() {				
		WebElement table = ElementsTools.waitForElement(this.driver, By.id("cart_summary"));	
		ArrayList<WebElement> rows = new ArrayList<WebElement>();
		rows.addAll( table.findElements(By.xpath("//*[@id=\"cart_summary\"]/tbody")));			
		ArrayList<WebElement> elements = (ArrayList<WebElement>) rows.get(0).findElements(By.cssSelector("td"));	
		WebElement element = elements.get(3);
		return element;
	}

	public WebElement getProductTotalPriceLabel() {				
		WebElement table = ElementsTools.waitForElement(this.driver, By.id("cart_summary"));	
		ArrayList<WebElement> rows = new ArrayList<WebElement>();
		rows.addAll( table.findElements(By.xpath("//*[@id=\"cart_summary\"]/tbody")));			
		ArrayList<WebElement> elements = (ArrayList<WebElement>) rows.get(0).findElements(By.cssSelector("td"));			
		WebElement element = elements.get(5);
		return element;
	}	

	public WebElement getTotalProductsLabel() {	
		WebElement element =  ElementsTools.waitForElement(this.driver, By.id("total_product"));
		return element;
	}

	public WebElement getTotalShippinglLabel() {			
		WebElement element = ElementsTools.waitForElement(this.driver, By.id("total_shipping"));	
		return element;
	}

	public WebElement getTotalTaxlLabel() {			
		WebElement element = ElementsTools.waitForElement(this.driver, By.id("total_tax"));	
		return element;
	}	

	public WebElement getTotalOrderLabel() {			
		WebElement element = ElementsTools.waitForElement(this.driver, By.id("total_price_container"));
		return element;
	}

	public WebElement getProceedToCheckoutButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]"));
	}

}
