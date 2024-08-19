package seleniumframework;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import seleniumframework.pageobjects.CartPage;
import seleniumframework.pageobjects.CataloguePage;
import seleniumframework.pageobjects.ConfirmationPage;
import seleniumframework.pageobjects.LandingPage;

public class TestForFramework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		
		String p1="ZARA COAT 3";
		String p2="IPHONE 13 PRO";
		
		LandingPage lp= new LandingPage(driver);
		lp.goToUrl();
		CataloguePage cp= lp.logintoApp("skp123@gmail.com", "Skp@1234");
		cp.addtoCart(p1);
		cp.addtoCart(p2);
		
		CartPage cc= cp.naviatetocart();
		ConfirmationPage cd= cc.checkout();
		
		cd.confirmorder("Ind");
		
	}

}
