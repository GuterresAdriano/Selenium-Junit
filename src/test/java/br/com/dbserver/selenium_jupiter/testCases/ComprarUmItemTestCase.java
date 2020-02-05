package br.com.dbserver.selenium_jupiter.testCases;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.com.dbserver.selenium_jupiter.tasks.AddressTasks;
import br.com.dbserver.selenium_jupiter.tasks.HomePageTasks;
import br.com.dbserver.selenium_jupiter.tasks.ItemPageTasks;
import br.com.dbserver.selenium_jupiter.tasks.LoginPageTasks;
import br.com.dbserver.selenium_jupiter.tasks.MyAccountTasks;
import br.com.dbserver.selenium_jupiter.tasks.OrderSumariTasks;
import br.com.dbserver.selenium_jupiter.tasks.OrderTasks;
import br.com.dbserver.selenium_jupiter.tasks.PaymentTasks;
import br.com.dbserver.selenium_jupiter.tasks.ShippingTasks;
import br.com.dbserver.selenium_jupiter.tools.CostumerFake;
import br.com.dbserver.selenium_jupiter.tools.DriverConfig;
import br.com.dbserver.selenium_jupiter.tools.Report;
import br.com.dbserver.selenium_jupiter.verificationPoints.TestCase01VerificationPoints;

@TestInstance(Lifecycle.PER_CLASS)
class ComprarUmItemTestCase {	

	private WebDriver driver ;	

	private HomePageTasks    			 homePageTasks;
	private LoginPageTasks   			 loginPageTasks;
	private MyAccountTasks   			 accountTasks;
	private ItemPageTasks  				 itemPageTasks;
	private OrderTasks       			 orderTasks;
	private AddressTasks     			 addressTasks;
	private ShippingTasks  	 			 shippingTasks;
	private PaymentTasks   	 			 paymentTasks;	
	private OrderSumariTasks 			 orderSumariTasks;
	private TestCase01VerificationPoints verifications;
	private CostumerFake 				 customerFake;

	private final static String PRODUCT_NAME              = "Printed Dress";
	private final static String PRODUCT_UNIT_PRICE        = "26.00";
	private final static String PRODUCT_QTD 		      = "1";
	private final static String PRODUCT_TOTAL_PRICE       = "26.00";
	
	private final static String ORDER_TOTAL_PRODUCT_PRICE = "26.00";
	private final static String ORDER_SHIPPING       	  =  "2.00";
	private final static String ORDER_TOTAL_WITHOUT_TAX   = "28.00";
	private final static String ORDER_INCOMMING_TAX       =  "0.00";
	private final static String ORDER_TOTAL_COST          = "28.00";

	@BeforeAll  		
	public void setUp() {		

		Report.startTest("Comprar Um Item");

		this.customerFake = new CostumerFake();

		this.driver = DriverConfig.getWebdriverChrome("http://automationpractice.com/index.php");	

		this.homePageTasks    = new HomePageTasks 	(this.driver);
		this.loginPageTasks   = new LoginPageTasks	(this.driver);
		this.accountTasks     = new MyAccountTasks	(this.driver);
		this.itemPageTasks    = new ItemPageTasks 	(this.driver);
		this.orderTasks       = new OrderTasks    	(this.driver);
		this.addressTasks     = new AddressTasks  	(this.driver);
		this.shippingTasks    = new ShippingTasks 	(this.driver);
		this.paymentTasks     = new PaymentTasks    (this.driver);
		this.orderSumariTasks = new OrderSumariTasks(this.driver);
		this.verifications    = new TestCase01VerificationPoints(this.driver);
	} 

	@AfterAll 
	public void tearDown() {			
		this.driver.quit();
		Report.close();
	}

	@Test
	public void testMain() {	

		try {
			Report.log(Status.INFO, "O teste iniciou!");

			this.homePageTasks.selectItemMenu();		
			this.homePageTasks.chooseFirstItemBlock();		
			this.homePageTasks.clickFirstItemBlock();	

			this.itemPageTasks.clickAddCartButton();		
			this.itemPageTasks.clickProceedCheckoutButton();
			
			this.verifications.verifyProductName      (PRODUCT_NAME);				
			this.verifications.verifyProductUnitPrice (PRODUCT_UNIT_PRICE);			
			this.verifications.verifyProductQtd	      (PRODUCT_QTD);
			this.verifications.verifyProductTotalPrice(PRODUCT_TOTAL_PRICE);
			
			this.verifications.verifyOrderTotalProductsPrice(ORDER_TOTAL_PRODUCT_PRICE);	
			this.verifications.verifyOrderShipping          (ORDER_SHIPPING);	
			this.verifications.verifyOrderTotalWithoutTax   (ORDER_TOTAL_WITHOUT_TAX);	
			this.verifications.verifyOrderIncommingtTax     (ORDER_INCOMMING_TAX);	
			this.verifications.verifyOrderTotalCost         (ORDER_TOTAL_COST);	

			this.orderTasks.clickProceedToCheckoutButton();
			
			this.loginPageTasks.fillEmailAddressTextfield(this.customerFake.getEmail());		
			this.loginPageTasks.clickCreateAccountButton();
			
			this.accountTasks.markMisterRadioButton();		
			this.accountTasks.fillFirstNameTextfield(this.customerFake.getName());		
			this.accountTasks.fillLastNameTextfield(this.customerFake.getLastName());		
			this.accountTasks.fillLastEmailTextfield(this.customerFake.getEmail());		
			this.accountTasks.fillPasswordTextfield(this.customerFake.getPassword());	
			this.accountTasks.choseDaysBithdayCombobox(this.customerFake.getDayBirthday()+"");		
			this.accountTasks.choseMonthBithdayCombobox(this.customerFake.getMonthBirthday()+"");		
			this.accountTasks.choseYearComboboxCombobox(this.customerFake.getYearBirthday()+"");		
			this.accountTasks.fillCompanyTextfield(this.customerFake.getCompany());		
			this.accountTasks.fillAddressTextfield(this.customerFake.getStreet());		
			this.accountTasks.fillCityTextfield(this.customerFake.getCity());				
			this.accountTasks.choseStateCombobox(this.customerFake.getState());		
			this.accountTasks.fillPostCodeTextfield(this.customerFake.getPostalCode());		
			this.accountTasks.choseCountryCombobox(this.customerFake.getCountry());		
			this.accountTasks.fillMobileTextfield(this.customerFake.getMobile());		
			this.accountTasks.clickRegisterButton();		

			this.verifications.verifyCostumerName(customerFake);	
			this.verifications.verifyAddressCompany(customerFake);	
			this.verifications.verifyAddressStreet(customerFake);	
			this.verifications.verifyAddressCityStatePostcode(customerFake);	
			this.verifications.verifyAddressCountry(customerFake);	
			this.verifications.verifyAddressMobile(customerFake);	

			this.addressTasks.clickProceedCheckoutButton();		
			
			this.shippingTasks.markIGreeCheckbox();
			this.shippingTasks.clickProceedCheckout();		
			
			this.paymentTasks.clickBankWireButton();

			this.orderSumariTasks.clickIconfirmmButton();			

			Report.log(Status.INFO, "O teste finalizou!");
			
		}catch (Exception e) {
			Report.log(Status.FATAL, "O teste falhou: "+e);
			fail(e);
		}

	}
}