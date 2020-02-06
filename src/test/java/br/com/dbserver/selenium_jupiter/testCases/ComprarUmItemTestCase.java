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

	private WebDriver driver;	

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
		DriverConfig.closeDriver(this.driver);
		Report.close();
	}

	@Test
	public void testMain() {	

		try {
			Report.log(Status.INFO, "O teste iniciou!");

			this.homePageTasks.selectFirstItemDresses();	

			this.itemPageTasks.addFirstItemDressesCart();
			
			this.verifications.verifyItemDetailsCart(PRODUCT_NAME,
													 PRODUCT_UNIT_PRICE,
													 PRODUCT_QTD, 
													 PRODUCT_TOTAL_PRICE);
			
			this.verifications.verifyOrderDetailsCart(ORDER_TOTAL_PRODUCT_PRICE,
													  ORDER_SHIPPING, 
													  ORDER_TOTAL_WITHOUT_TAX, 
													  ORDER_INCOMMING_TAX,
													  ORDER_TOTAL_COST);

			this.orderTasks.clickProceedToCheckoutButton();
			
			this.loginPageTasks.CreateAccont(this.customerFake.getEmail());
			
			this.accountTasks.fillCostumerForm(this.customerFake.getName(),				
											   this.customerFake.getLastName(),			
											   this.customerFake.getEmail(),			
											   this.customerFake.getPassword(),				
											   this.customerFake.getDayBirthday()+"",				
											   this.customerFake.getMonthBirthday()+"",			
											   this.customerFake.getYearBirthday()+"",				
											   this.customerFake.getCompany(),		
											   this.customerFake.getStreet(),					
											   this.customerFake.getCity(),				
											   this.customerFake.getState(),				
											   this.customerFake.getPostalCode(),			
											   this.customerFake.getCountry(),			
											   this.customerFake.getMobile());
			
			this.verifications.verifyOrderAccountDetails(this.customerFake.getName()+" "+
														      this.customerFake.getLastName(), 
														 this.customerFake.getCompany(),
														 this.customerFake.getStreet(),
														 this.customerFake.getCity()+", "+
															  this.customerFake.getState() +" "+
															  this.customerFake.getPostalCode(),
														 this.customerFake.getCountry(),
														 this.customerFake.getMobile());

			this.addressTasks.clickProceedCheckoutButton();		
			
			this.shippingTasks.confirmShipping();
			
			this.paymentTasks.clickBankWireButton();

			this.orderSumariTasks.clickIconfirmmButton();			

			Report.log(Status.INFO, "O teste finalizou!");
			
		}catch (Exception e) {
			Report.log(Status.FATAL, "O teste falhou: "+e);
			fail(e);
		}

	}
}