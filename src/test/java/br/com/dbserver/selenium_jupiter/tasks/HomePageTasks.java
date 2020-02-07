package br.com.dbserver.selenium_jupiter.tasks;

import org.openqa.selenium.WebDriver;

import br.com.dbserver.selenium_jupiter.appObjects.HomePageAppObject;

public class HomePageTasks {

	private HomePageAppObject appObject;

	public HomePageTasks(WebDriver driver) {
		this.appObject = new HomePageAppObject(driver);		
	}	
	public void selectFirstItemDresses() {		
		this.appObject.getTitlesMenuDresses().click();		
		this.appObject.getFirstItemBlock().click();	
	}	
}
