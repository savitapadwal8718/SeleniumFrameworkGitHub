package seleniumframework;

import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumframework.pageobjects.CartPage;
import seleniumframework.pageobjects.CataloguePage;
import seleniumframework.pageobjects.OrderPage;

public class ErrorValidationTest extends BaseTest {


	@Test
		public void LoginCheck() 
	{
		lp.logintoApp("skp123@gmail.com", "Skp@1234");
		Assert.assertEquals("Login Successfully........", lp.getErrorText());
		
				
	}

	@Test(retryAnalyzer=RetryTest.class)
	public void checkProductinCart() {
	String pnm="ZAR COAT 3";
	CataloguePage cp = lp.logintoApp("skp123@gmail.com", "Skp@1234");
	cp.addtoCart(pnm);
	CartPage cc = cp.naviatetocart();

	Boolean pdcheck = cc.checkProducts("ZARA COAT 3");
	Assert.assertTrue(pdcheck);


	}
	

	
	
	
}
