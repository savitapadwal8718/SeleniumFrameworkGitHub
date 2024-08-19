package seleniumframework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CataloguePage extends Globalmethodspage {

	WebDriver driver;

	public CataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	public List<WebElement> getproductList() {
		return products;

	}

	By bnm = By.cssSelector(".mb-3");
	By btnclick = By.cssSelector(".card-body button:last-of-type");

	public WebElement getProductname(String name) {
		elementappearwait(bnm);
		WebElement prod = products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(name)).findFirst().orElse(null);
		return prod;

	}

	By cnm = By.id("toast-container");

	By dnm = By.cssSelector(".ng-tns-c31-8");
	@FindBy(css = ".ng-animating")
	WebElement cartwait;

	public void addtoCart(String pname) {

		WebElement prod1 = getProductname(pname);
		prod1.findElement(btnclick).click();
		elementappearwait(cnm);
		elementdisappearwait(cnm);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement Cartbtn;

	public CartPage naviatetocart() {

		Cartbtn.click();
		return new CartPage(driver);

	}

}
