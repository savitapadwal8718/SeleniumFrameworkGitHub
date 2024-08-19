package seleniumframework.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

public class ConfirmationPage extends Globalmethodspage{

	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

		
//	String cnt="Ind";
//	
//	
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//	
//	driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
//			
//	
//	driver.findElement(By.cssSelector(".action__submit")).click();
//	String conf=driver.findElement(By.cssSelector(".hero-primary")).getText();
//
//	Assert.assertTrue(conf.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	//driver.close();
	
	By results=By.cssSelector(".ta-results");
	
	@FindBy(css=".form-group input")
	WebElement cntadd;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement cntselect;
	
	@FindBy(css=".action__submit")
	WebElement actbtn;
	
	@FindBy(css=".hero-primary")
	WebElement cnfmsg;
	
	public void confirmorder(String cnt)
	{
		
		Actions a= new Actions(driver);
		a.sendKeys(cntadd, cnt).build().perform();
		elementappearwait(results);
		cntselect.click();
		actbtn.click();
		
		
//		String msg=cnfmsg.getText();
//		
//		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	
	
			
		
			
	public String checkMessage() {
		
		
		String msg=cnfmsg.getText();
	
		return msg;
	}
		
	
	
	
	
		
		
	}
	
	
	
	
	
	

