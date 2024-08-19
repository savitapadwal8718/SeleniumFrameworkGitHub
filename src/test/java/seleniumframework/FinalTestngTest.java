package seleniumframework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import seleniumframework.pageobjects.CartPage;
import seleniumframework.pageobjects.CataloguePage;
import seleniumframework.pageobjects.ConfirmationPage;
import seleniumframework.pageobjects.LandingPage;
import seleniumframework.pageobjects.OrderPage;

public class FinalTestngTest extends BaseTest {
	
	@Test (dataProvider="getData")
	public void submitOrder(HashMap<String,String> input) throws IOException {

		
		
		CataloguePage cp = lp.logintoApp(input.get("email"),input.get("pwd"));
		cp.addtoCart(input.get("product"));
		

		CartPage cc = cp.naviatetocart();

		ConfirmationPage cd = cc.checkout();
		cd.confirmorder("Ind");
		String msg = cd.checkMessage();
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

@Test (dependsOnMethods= {"submitOrder"})
	public void OrderHistorycheck()
	{
		String p1="ZARA COAT 3";
		CataloguePage cp = lp.logintoApp("skp123@gmail.com", "Skp@1234");
		
		OrderPage op= cp.getOrders();
		Boolean t1=op.orderCheck(p1);
		Assert.assertTrue(t1);
		
	}
	
//	@DataProvider
//	public Object[][] getData()
//	{
//		return new Object[][] {{"skp123@gmail.com", "Skp@1234", "ZARA COAT 3"},{"apeksha@gmail.com","Apeksha@2024", "IPHONE 13 PRO"}};
//		
//			
//	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String, String> map=new HashMap<String, String>();
//		map.put("email","skp123@gmail.com");
//		map.put("pwd","Skp@1234");
//		map.put("product","ZARA COAT 3");
//		
//		HashMap<String, String> map1=new HashMap<String, String>();
//		map1.put("email","apeksha@gmail.com");
//		map1.put("pwd","Apeksha@2024");
//		map1.put("product","IPHONE 13 PRO");
		
		
		List<HashMap<String, String>> newdata= getJsondata();
		
		
		return new Object[][] {{newdata.get(0)}, {newdata.get(1)}};
		
		
		
				
		
		
		
		
	}
	

	
	
}
