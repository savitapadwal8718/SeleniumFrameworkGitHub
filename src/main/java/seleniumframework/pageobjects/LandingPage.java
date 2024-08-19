package seleniumframework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends Globalmethodspage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void goToUrl() {
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();

	}

	@FindBy(id = "userEmail")
	WebElement email;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement submitbtn;

	@FindBy(css = "[class*=flyInOut]")
	WebElement ErrorText;

	public CataloguePage logintoApp(String mail, String pwd) {
		email.sendKeys(mail);
		password.sendKeys(pwd);
		submitbtn.click();
		return new CataloguePage(driver);

	}


	
	
	public String getErrorText() {

		elementnewwait(ErrorText);
		return ErrorText.getText();

	}

}
