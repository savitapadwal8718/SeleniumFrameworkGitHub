package seleniumframework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends Globalmethodspage{
	
	
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		
	}

	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderitems;
	
	
	public Boolean orderCheck(String p1) {
		
		Boolean result= orderitems.stream().anyMatch(product->product.getText().equalsIgnoreCase(p1));
		return result;
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
