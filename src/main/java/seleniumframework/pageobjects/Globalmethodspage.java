package seleniumframework.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Globalmethodspage {

	WebDriver driver;
	
	public Globalmethodspage(WebDriver driver) {
		this.driver=driver;
		}
	
	public void elementappearwait(By bnm)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(bnm));
				
	}

	
	public void elementdisappearwait(By cnm)
	{
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(cnm));
				
	}
	
	
	public void elementnewwait(WebElement cartwait)
	{
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(cartwait));
				
	}
	
	@FindBy(css="[routerlink*='/dashboard/myorders']")
	WebElement orderbtn;	
	
	public OrderPage getOrders()
	{
		orderbtn.click();
		return new OrderPage(driver);
		
		
	}
	
	
}



