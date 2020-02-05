package br.com.dbserver.selenium_jupiter.tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.dbserver.selenium_jupiter.appObjects.LoginPageAppObject;

public class LoginPageTasks {
	
	private LoginPageAppObject appObject;

	public LoginPageTasks(WebDriver driver) {
		super();
		this.appObject = new LoginPageAppObject(driver);
	}
	
	public void fillEmailAddressTextfield(String email) {
		WebElement element = this.appObject.getEmailAddressTextfield();
		element.sendKeys(email);		
	}
	
	public void clickCreateAccountButton() {		
		WebElement element = this.appObject.getCreateAccountButton();
		element.click();		
	}
}
