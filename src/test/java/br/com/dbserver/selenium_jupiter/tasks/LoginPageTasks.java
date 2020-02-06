package br.com.dbserver.selenium_jupiter.tasks;

import org.openqa.selenium.WebDriver;

import br.com.dbserver.selenium_jupiter.appObjects.LoginPageAppObject;

public class LoginPageTasks {
	
	private LoginPageAppObject appObject;

	public LoginPageTasks(WebDriver driver) {
		this.appObject = new LoginPageAppObject(driver);
	}	
	public void CreateAccont(String email) {
		this.appObject.getEmailAddressTextfield().sendKeys(email);	
		this.appObject.getCreateAccountButton().click();			
	}
}
