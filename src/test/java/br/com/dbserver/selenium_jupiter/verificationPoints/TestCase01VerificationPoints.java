package br.com.dbserver.selenium_jupiter.verificationPoints;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import br.com.dbserver.selenium_jupiter.appObjects.AddressAppObject;
import br.com.dbserver.selenium_jupiter.appObjects.OrderAppObject;
import br.com.dbserver.selenium_jupiter.tools.ElementsTools;
import br.com.dbserver.selenium_jupiter.tools.Report;

public class TestCase01VerificationPoints {
	private WebDriver    	 driver;
	private OrderAppObject 	 appObject;
	private AddressAppObject addressAppObject;

	public TestCase01VerificationPoints(WebDriver driver) {
		this.driver     	  = driver;		
		this.appObject   	  = new OrderAppObject(this.driver);
		this.addressAppObject = new AddressAppObject(this.driver);
	}
	
	public void verifyItemDetailsCart(String productName, 
									  String productUnitPrice, 
									  String productQtd ,
									  String productTotalPrice) {
	
		verifyProductName      (productName);				
		verifyProductUnitPrice (productUnitPrice);			
		verifyProductQtd	   (productQtd);
		verifyProductTotalPrice(productTotalPrice);		
	}
	
	public void verifyOrderDetailsCart(	String orderTotalProductPrice,
										String orderShipping , 
										String orderTotalWithoutTax, 
										String orderIncommingTax,
										String orderTotalCost) {
		
		verifyOrderTotalProductsPrice(orderTotalProductPrice);	
		verifyOrderShipping          (orderShipping);	
		verifyOrderTotalWithoutTax   (orderTotalWithoutTax);	
		verifyOrderIncommingtTax     (orderIncommingTax);	
		verifyOrderTotalCost         (orderTotalCost);	
		
	}
	
	public void verifyOrderAccountDetails(String name, 
										  String company, 
										  String street,
										  String cityStatePostcode, 
										  String country, 
										  String mobile) {
		verifyCostumerName(name);	
		verifyAddressCompany(company);	
		verifyAddressStreet(street);	
		verifyAddressCityStatePostcode(cityStatePostcode);	
		verifyAddressCountry(country);	
		verifyAddressMobile(mobile);	
		
	}
	
	
	public void verifyProductQtd(String qtd) {   		
		WebElement element = this.appObject.getProductQtdLabel();
		String qtdActual = element.getAttribute("value");
		ElementsTools.highlightElement(this.driver, element);
		if (qtdActual.contains(qtd)) {
			Report.log(Status.PASS, "A quantidade esta correta.", this.driver);
		}else {
			Report.log(Status.FAIL, "A quantidade não esta correta! "
					              + "  Quantitade esperada: "+ qtd
					              + "; Quantitade encontrada: "+qtdActual, this.driver);
		}		
		ElementsTools.unHighlightElement(this.driver, element);
	}
	public void verifyProductUnitPrice(String productUnitPrice) {    	
		WebElement element = this.appObject.getProductUnitPriceLabel(); 
		String priceActual = element.getText();
		ElementsTools.highlightElement(this.driver, element);
		if (priceActual.contains(productUnitPrice)) {
			Report.log(Status.PASS, "O preço esta correto.", this.driver);
		}else {
			Report.log(Status.FAIL, "O preço não esta correto."
								+ "  O preço esperado: "+priceActual
		                        + "; O preço encontrado: "+productUnitPrice, this.driver);
		}
		ElementsTools.unHighlightElement(this.driver, element);
	}
	public void verifyProductName(String productName) {    	
		WebElement element = this.appObject.getProductNameLabel();  
		String nameActual = element.getText();
		ElementsTools.highlightElement(this.driver, element);
		if (nameActual.contains(productName)) {
			Report.log(Status.PASS, "O produto esta correto.", this.driver);
		}else {
			Report.log(Status.FAIL, "O nome do produto não esta correto."
								+ "  O nome do produto esperado: "+productName
								+ "; O nome do produto encontrado: "+nameActual, this.driver);
		}
		ElementsTools.unHighlightElement(this.driver, element);
	}
	public void verifyProductTotalPrice(String productTotalPrice) {    	
		WebElement element = this.appObject.getProductTotalPriceLabel();
		String priceTotalActual = element.getText().replace("$","");
		ElementsTools.highlightElement(this.driver, element);			
		if (priceTotalActual.equalsIgnoreCase(productTotalPrice) ) {
			Report.log(Status.PASS, "A soma dos itens esta correta.", this.driver);
		}else {
			Report.log(Status.FAIL, "A soma dos itens não esta correta."
								+ "  A soma dos itens esperada: "+productTotalPrice
								+ "; A soma dos itens encontrada: "+priceTotalActual, this.driver);
		}
		ElementsTools.unHighlightElement(this.driver, element);
	} 
	public void verifyAddressMobile(String mobile) {
		WebElement element = this.addressAppObject.getMobileLabel();	
		String mobileActual   = element.getText();	
		ElementsTools.highlightElement(driver, element);
		if( mobile.equalsIgnoreCase(mobileActual)) {
			Report.log(Status.PASS, "O telefone esta correto.", this.driver);
		}else {
			Report.log(Status.FAIL, "O telefone não esta correto "
								+ "  O telefone esperado: "+mobile
								+ "; O telefone encontrado: "+mobileActual, this.driver);
		}	
		ElementsTools.unHighlightElement(driver, element);
	}
	public void verifyAddressCountry(String country) {		
		WebElement element =  this.addressAppObject.getCountryLabel();
		String countryActual   = element.getText();
		ElementsTools.highlightElement(this.driver, element);		
		if(	country.equalsIgnoreCase(countryActual)) {
			Report.log(Status.PASS, "O país esta correto.", this.driver);
		}else {
			Report.log(Status.FAIL, "O país não esta correto."
								+ "  O país esperado: "+country
								+ "; O país encontrado: "+countryActual, this.driver);
		}	
		ElementsTools.unHighlightElement(this.driver, element);
	}	
	public void verifyAddressCityStatePostcode(String cityStatePostcode) {		
		WebElement element   = this.addressAppObject.getCityStatePostCodeLabel();	
		String addressActual = element.getText();
		ElementsTools.highlightElement(this.driver, element);		
		if (cityStatePostcode.equalsIgnoreCase(addressActual)) {
			Report.log(Status.PASS, "A localidade esta correta.", this.driver);
		}else {
			Report.log(Status.FAIL, "A localidade não esta correta."
								+ "  A localidade esperada: "+cityStatePostcode
								+ "; A localidade encontrada: "+addressActual, this.driver);
		}	
		ElementsTools.unHighlightElement(this.driver, element);		
	}
	public void verifyAddressStreet(String street) {
		WebElement element    = this.addressAppObject.getAddressLabel();
		String streetActual   = element.getText();
		ElementsTools.highlightElement(this.driver, element);	
		if (street.equalsIgnoreCase(streetActual)) {
			Report.log(Status.PASS, "O endereço esta correto.", this.driver);
		}else {
			Report.log(Status.FAIL, "O endereço não esta correto."
								+ "  O endereço esperado: "+street
								+ "; O endereço encontrado: "+streetActual, this.driver);
		}	
		ElementsTools.unHighlightElement(this.driver, element);	
	}	
	public void verifyAddressCompany(String customer) {
		WebElement element = this.addressAppObject.getCompanyLabel();
		String companyActual   = element.getText();
		ElementsTools.highlightElement(this.driver, element);	
		if (customer.equalsIgnoreCase(companyActual)) {
			Report.log(Status.PASS, "O nome da compania esta correto.", this.driver);
		}else {
			Report.log(Status.FAIL, "O nome da compania não esta correto."
								+ "  O nome da compania esperado: "+customer
								+ "; O nome da compania encontrado: "+companyActual, this.driver);	
		}
		ElementsTools.unHighlightElement(this.driver, element);	
	}
	public void verifyCostumerName(String name) {
		WebElement element = this.addressAppObject.getAddressNameLabel();
		String costumerActual   = element.getText();
		ElementsTools.highlightElement(this.driver, element);	
		if (name.equalsIgnoreCase(costumerActual)) {
			Report.log(Status.PASS, "O nome do cliente esta correto.", this.driver);
		}else {
			Report.log(Status.FAIL, "O nome do cliente não esta correto."
								+ "  O nome da cliente esperado: "+name
								+ "; O nome da cliente encontrado: "+costumerActual, this.driver);	
		}	
		ElementsTools.unHighlightElement(this.driver, element);	
	}
	public void verifyOrderTotalProductsPrice(String orderTotalProductsPrice) {
		WebElement element = this.appObject.getOrderTotalProductsLabel();	
		String totalActual = element.getText().replace("$","");
		ElementsTools.highlightElement(this.driver, element);		
		if ( totalActual.equalsIgnoreCase(orderTotalProductsPrice)) {
			Report.log(Status.PASS, "A soma total esta correta.", this.driver);
		}else {
			Report.log(Status.FAIL, "A soma total não esta correta."
								+ "  A soma total esperado: "+orderTotalProductsPrice
								+ "; A soma total encontrado: "+totalActual, this.driver);	
		}	
		ElementsTools.unHighlightElement(this.driver, element);
	}
	public void verifyOrderShipping(String orderShipping) {	
		WebElement element    = this.appObject.getOrderTotalShippinglLabel();
		String shippingActual = element.getText().replace("$","");
		ElementsTools.highlightElement(this.driver, element);		
		if (shippingActual.equalsIgnoreCase(orderShipping)) {
			Report.log(Status.PASS, "O frete esta correto.", this.driver);
		}else {
			Report.log(Status.FAIL, "O frete não esta correto."
								+ "  O frete esperado: "+orderShipping
								+ "; O frete encontrado: "+shippingActual, this.driver);
		}	
		ElementsTools.unHighlightElement(this.driver, element);		
	}	
	public void verifyOrderTotalWithoutTax(String orderTotalWithoutTax) {
		WebElement element = this.appObject.getOrderTotalWithoutTaxLabel();	
		String orderActual = element.getText().replace("$","");
		ElementsTools.highlightElement(this.driver, element);		
		if ( orderActual.equalsIgnoreCase(orderTotalWithoutTax)) {
			Report.log(Status.PASS, "A soma sem impostos esta correta.", this.driver);
		}else {
			Report.log(Status.FAIL, "A soma sem impostos não esta correta."
								+ "  A soma sem impostos esperada: "+orderTotalWithoutTax
								+ "; A soma sem impostos encontrada: "+orderActual, this.driver);
		}	
		ElementsTools.unHighlightElement(this.driver, element);		
	}
	public void verifyOrderIncommingtTax(String orderIncommingTax) {		
		WebElement element = this.appObject.getOrderTotalTaxlLabel();
		String taxActual   = element.getText().replace("$","");
		ElementsTools.highlightElement(this.driver, element);		
		if ( taxActual.equalsIgnoreCase(orderIncommingTax)) {
			Report.log(Status.PASS, "A taxa esta correta.", this.driver);
		}else {
			Report.log(Status.FAIL, "A taxa não esta correta."
								+ "  A taxa esperada: "+ orderIncommingTax
								+ "; A taxa encontrada: "+taxActual, this.driver);
		}	
		ElementsTools.unHighlightElement(this.driver, element);		
	}
	public void verifyOrderTotalCost(String orderTotalCost) {
		
		WebElement element   = this.appObject.getOrderTotalOrderLabel();	
		String totalActual = element.getText().replace("$","");
		ElementsTools.highlightElement(this.driver, element);		
		if (totalActual.equalsIgnoreCase(orderTotalCost)) {
			Report.log(Status.PASS, "A soma total esta correta.", this.driver);
		}else {
			Report.log(Status.FAIL, "A soma total não esta correta."
								+ "  A soma total esperada: "+orderTotalCost
								+ "; A soma total encontrada: "+totalActual, this.driver);
		}	
		ElementsTools.unHighlightElement(this.driver, element);		
	}

	
}
