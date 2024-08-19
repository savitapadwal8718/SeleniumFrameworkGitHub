package seleniumframework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage extends Globalmethodspage {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".cartSection  h3")
	List<WebElement> cartproducts;

	public Boolean checkProducts(String snm) {
		Boolean test = cartproducts.stream().anyMatch(product -> product.getText().equals(snm));
		return test;

	}

	@FindBy(xpath = "//li[@class='totalRow'] /button")
	WebElement chkbtn;

	public ConfirmationPage checkout() {

		elementnewwait(chkbtn);
		chkbtn.click();
		return new ConfirmationPage(driver);

	}

}
