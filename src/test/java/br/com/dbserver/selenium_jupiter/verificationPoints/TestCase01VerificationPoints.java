package br.com.dbserver.selenium_jupiter.verificationPoints;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import br.com.dbserver.selenium_jupiter.appObjects.AddressAppObject;
import br.com.dbserver.selenium_jupiter.appObjects.OrderAppObject;
import br.com.dbserver.selenium_jupiter.tools.CostumerFake;
import br.com.dbserver.selenium_jupiter.tools.ElementsTools;
import br.com.dbserver.selenium_jupiter.tools.Report;

public class TestCase01VerificationPoints {
	private WebDriver    	 driver;
	private OrderAppObject 	 appObject;
	private AddressAppObject addressAppObject;

	public TestCase01VerificationPoints(WebDriver driver) {
		super();
		this.driver     	  = driver;		
		this.appObject   	  = new OrderAppObject(this.driver);
		this.addressAppObject = new AddressAppObject(this.driver);
	}

	public void verifyProductQtd(String qtd) {   		
		WebElement element = this.appObject.getProductQtdLabel();
		String qtdActual = element.getAttribute("value");
		ElementsTools.highlightElement(this.driver, element);
		if (qtdActual.contains(qtd)) {
			Report.log(Status.PASS, "A quantidade esta correta.", this.driver);
		}else {
			Report.log(Status.FAIL, "A quantidade não esta correta! "
					              + "; Quantitade esperada: "+ qtd
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
								+ "; O preço esperado: "+priceActual
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
								+ "; O nome do produto esperado: "+productName
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
								+ "; A soma dos itens esperada: "+productTotalPrice
								+ "; A soma dos itens encontrada: "+priceTotalActual, this.driver);
		}
		ElementsTools.unHighlightElement(this.driver, element);
	} 

	public void verifyAddressMobile(CostumerFake customer) {
		WebElement element = this.addressAppObject.getMobileLabel();	
		String mobileActual   = element.getText();
		String mobileExpected = customer.getMobile();		
		ElementsTools.highlightElement(driver, element);
		if( mobileExpected.equalsIgnoreCase(mobileActual)) {
			Report.log(Status.PASS, "O telefone esta correto.", this.driver);
		}else {
			Report.log(Status.FAIL, "O telefone não esta correto "
								+ "; O telefone esperado: "+mobileExpected
								+ "; O telefone encontrado: "+mobileActual, this.driver);
		}	
		ElementsTools.unHighlightElement(driver, element);
	}

	public void verifyAddressCountry(CostumerFake customer) {		
		WebElement element =  this.addressAppObject.getCountryLabel();
		String countryActual   = element.getText();
		String countryExpected = customer.getCountry();
		ElementsTools.highlightElement(this.driver, element);		
		if(	countryExpected.equalsIgnoreCase(countryActual)) {
			Report.log(Status.PASS, "O país esta correto.", this.driver);
		}else {
			Report.log(Status.FAIL, "O país não esta correto."
								+ "; O país esperado: "+countryExpected
								+ "; O país encontrado: "+countryActual, this.driver);
		}	
		ElementsTools.unHighlightElement(this.driver, element);
	}	

	public void verifyAddressCityStatePostcode(CostumerFake customer) {		
		WebElement element   = this.addressAppObject.getCityStatePostCodeLabel();	
		String addressActual = element.getText();
		String addressExpected   = customer.getCity()+", "+customer.getState() +" "+customer.getPostalCode();
		ElementsTools.highlightElement(this.driver, element);		
		if (addressExpected.equalsIgnoreCase(addressActual)) {
			Report.log(Status.PASS, "O endereço esta correto.", this.driver);
		}else {
			Report.log(Status.FAIL, "O endereço não esta correto."
								+ "; O endereço esperado: "+addressExpected
								+ "; O endereço encontrado: "+addressActual, this.driver);
		}	
		ElementsTools.unHighlightElement(this.driver, element);		
	}

	public void verifyAddressStreet(CostumerFake customer) {
		WebElement element    = this.addressAppObject.getAddressLabel();
		String streetActual   = element.getText();
		String streetExpected = customer.getStreet();
		ElementsTools.highlightElement(this.driver, element);	
		if (streetExpected.equalsIgnoreCase(streetActual)) {
			Report.log(Status.PASS, "O endereço esta correto.", this.driver);
		}else {
			Report.log(Status.FAIL, "O endereço não esta correto."
								+ "; O endereço esperado: "+streetExpected
								+ "; O endereço encontrado: "+streetActual, this.driver);
		}	
		ElementsTools.unHighlightElement(this.driver, element);	
	}	

	public void verifyAddressCompany(CostumerFake customer) {
		WebElement element = this.addressAppObject.getCompanyLabel();
		String companyActual   = element.getText();
		String companyExpected = customer.getCompany();
		ElementsTools.highlightElement(this.driver, element);	
		if (companyExpected.equalsIgnoreCase(companyActual)) {
			Report.log(Status.PASS, "O nome da compania esta correto.", this.driver);
		}else {
			Report.log(Status.FAIL, "O nome da compania não esta correto."
								+ "\nO nome da compania esperado: "+companyExpected
								+ "\nO nome da compania encontrado: "+companyActual, this.driver);	
		}
		ElementsTools.unHighlightElement(this.driver, element);	
	}

	public void verifyCostumerName(CostumerFake costumerFake) {
		WebElement element = this.addressAppObject.getAddressNameLabel();
		String costumerActual   = element.getText();
		String costumerExpected = costumerFake.getName()+" "+costumerFake.getLastName();
		ElementsTools.highlightElement(this.driver, element);	
		if (costumerExpected.equalsIgnoreCase(costumerActual)) {
			Report.log(Status.PASS, "O nome do cliente esta correto.", this.driver);
		}else {
			Report.log(Status.FAIL, "O nome do cliente não esta correto."
								+ "; O nome da cliente esperado: "+costumerExpected
								+ "; O nome da cliente encontrado: "+costumerActual, this.driver);	
		}	
		ElementsTools.unHighlightElement(this.driver, element);	
	}

	public void verifyOrderTotalProductsPrice(String orderTotalProductsPrice) {
		WebElement element = this.appObject.getTotalOrderLabel();	
		String totalActual = element.getText().replace("$","");
		ElementsTools.highlightElement(this.driver, element);		
		if ( totalActual.equalsIgnoreCase(orderTotalProductsPrice)) {
			Report.log(Status.PASS, "A soma total esta correta.", this.driver);
		}else {
			Report.log(Status.FAIL, "A soma total não esta correta."
								+ "; A soma total esperado: "+orderTotalProductsPrice
								+ "; A soma total encontrado: "+totalActual, this.driver);	
		}	
		ElementsTools.unHighlightElement(this.driver, element);
	}

	public void verifyOrderShipping(String orderShipping) {	
		WebElement element    = this.appObject.getTotalShippinglLabel();
		String shippingActual = element.getText().replace("$","");
		ElementsTools.highlightElement(this.driver, element);		
		if (shippingActual.equalsIgnoreCase(orderShipping)) {
			Report.log(Status.PASS, "O frete esta correto.", this.driver);
		}else {
			Report.log(Status.FAIL, "O frete não esta correto."
								+ "; O frete esperado: "+orderShipping
								+ "; O frete encontrado: "+shippingActual, this.driver);
		}	
		ElementsTools.unHighlightElement(this.driver, element);		
	}
	
	

	public void verifyOrderTotalWithoutTax(String orderTotalWithoutTax) {
		WebElement element = this.appObject.getTotalOrderLabel();	
		String orderActual = element.getText().replace("$","");
		ElementsTools.highlightElement(this.driver, element);		
		if ( orderActual.equalsIgnoreCase(orderTotalWithoutTax)) {
			Report.log(Status.PASS, "A soma sem impostos esta correta.", this.driver);
		}else {
			Report.log(Status.FAIL, "A soma sem impostos não esta correta."
								+ "; A soma sem impostos esperada: "+orderTotalWithoutTax
								+ "; A soma sem impostos encontrada: "+orderActual, this.driver);
		}	
		ElementsTools.unHighlightElement(this.driver, element);		
	}

	public void verifyOrderIncommingtTax(String orderIncommingTax) {		
		WebElement element = this.appObject.getTotalTaxlLabel();
		String taxActual   = element.getText().replace("$","");
		ElementsTools.highlightElement(this.driver, element);		
		if ( taxActual.equalsIgnoreCase(orderIncommingTax)) {
			Report.log(Status.PASS, "A soma total esta correta.", this.driver);
		}else {
			Report.log(Status.FAIL, "A taxa não esta correta."
								+ "; A taxa esperada: "+ orderIncommingTax
								+ "; A taxa encontrada: "+taxActual, this.driver);
		}	
		ElementsTools.unHighlightElement(this.driver, element);		
	}

	public void verifyOrderTotalCost(String orderTotalCost) {
		
		WebElement element   = this.appObject.getTotalOrderLabel();	
		String totalActual = element.getText().replace("$","");
		ElementsTools.highlightElement(this.driver, element);		
		if (totalActual.equalsIgnoreCase(orderTotalCost)) {
			Report.log(Status.PASS, "A soma total esta correta.", this.driver);
		}else {
			Report.log(Status.FAIL, "A soma total não esta correta."
								+ "; A soma total esperada: "+orderTotalCost
								+ "; A soma total encontrada: "+totalActual, this.driver);
		}	
		ElementsTools.unHighlightElement(this.driver, element);		
	}

}
