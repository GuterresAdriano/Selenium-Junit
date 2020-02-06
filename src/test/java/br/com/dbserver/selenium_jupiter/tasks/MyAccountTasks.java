package br.com.dbserver.selenium_jupiter.tasks;

import org.openqa.selenium.WebDriver;

import br.com.dbserver.selenium_jupiter.appObjects.MyAccountPageAppObject;

public class MyAccountTasks {

	private MyAccountPageAppObject accountPageAppObject;

	public MyAccountTasks(WebDriver driver) {
		this.accountPageAppObject = new MyAccountPageAppObject(driver);	
		}	
	
	public void fillCostumerForm(String firstName,
								 String lastName,
								 String email,
								 String password,
								 String day,
								 String month,
								 String year, 
								 String company,
								 String address,
								 String city,
								 String state,
								 String postCode,
								 String country,
								 String phone) {
		this.accountPageAppObject.getTitleMisterRadioButton().click();		
		this.accountPageAppObject.getFirstNameTexfield().sendKeys(firstName);	
		this.accountPageAppObject.getLastNameTexfield().sendKeys(lastName);
		this.accountPageAppObject.getEmailTexfield().clear();
		this.accountPageAppObject.getEmailTexfield().sendKeys(email);
		this.accountPageAppObject.getPasswordTexfield().sendKeys(password);
		this.accountPageAppObject.getDaysBithdayCombobox().selectByValue(day);
		this.accountPageAppObject.getMonthBithdayCombobox().selectByValue(month);
		this.accountPageAppObject.getYearBithdayCombobox().selectByValue(year);
		this.accountPageAppObject.getCompanyTextfield().sendKeys(company);	
		this.accountPageAppObject.getAddressTextfield().sendKeys(address);
		this.accountPageAppObject.getCityTextfield().sendKeys(city);
		this.accountPageAppObject.getStateCombobox().selectByVisibleText(state);
		this.accountPageAppObject.getPostCodeTextfield().sendKeys(postCode);
		this.accountPageAppObject.getCountryCombobox().selectByVisibleText(country);
		this.accountPageAppObject.getMobileTextfield().sendKeys(phone);
		this.accountPageAppObject.getRegisterButton().click();	
		
	}
}
