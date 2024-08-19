package seleniumframework;


import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class EndtoEndTest {

	public static void main(String[] args) {
		
		//WebDriverManager.chromedriver().setup();
	
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String name="ZARA COAT 3";
		
		driver.findElement(By.id("userEmail")).sendKeys("skp123@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Skp@1234");
		driver.findElement(By.id("login")).click();
		
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));		
	
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod= products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(name)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));
		
		WebElement prod1= products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);
		
		prod1.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-tns-c31-8")));
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".toast-container")));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartproduct= driver.findElements(By.cssSelector(".cartSection  h3"));
		
		Boolean test= cartproduct.stream().anyMatch(product->product.getText().equals(name));
		
		Assert.assertTrue(test);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		
//		driver.findElement(By.cssSelector(".form-group input")).sendKeys(cnt);
//		List<WebElement> cntname=driver.findElements(By.cssSelector(".ta-item"));
//		cntname.get(1).click();
		String cnt="Ind";
		Actions a= new Actions(driver);
		//a.sendKeys(cnt).build().perform();
		
		a.sendKeys(driver.findElement(By.cssSelector(".form-group input")), cnt).build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
				
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		String conf=driver.findElement(By.cssSelector(".hero-primary")).getText();
	
		Assert.assertTrue(conf.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//driver.close();
		
		
				

	}

}
