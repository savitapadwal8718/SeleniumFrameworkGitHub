package seleniumframework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import seleniumframework.pageobjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	LandingPage lp;

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\test\\java\\seleniumframework\\testObjects\\GlobalData.properties");
		prop.load(fis);

		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		}

		return driver;

	}

	@BeforeMethod (alwaysRun=true)
	public LandingPage launchApp() throws IOException {

		driver = initializeDriver();
		lp = new LandingPage(driver);
		lp.goToUrl();

		return lp;
		
	}
	
	
	public String getScreenshot(String tcname, WebDriver driver) throws IOException {
		
		TakesScreenshot ts= ((TakesScreenshot) driver);
		File src= ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir") + "\\report\\" + tcname + ".png");
		FileUtils.copyFile(src, target);
				
		return System.getProperty("user.dir") + "\\report\\" + tcname + ".png";
		
			
		
	}
	
	

	
	public List<HashMap<String, String>> getJsondata() throws IOException
	{
		String jsonRead= FileUtils.readFileToString(new File(System.getProperty("user.dir")+
				"//src//test//java//seleniumframework//dataProviderJson//readJson.json"), StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		
		List<HashMap<String, String>> data= mapper.readValue(jsonRead, 
				new TypeReference <List<HashMap<String,String>>>(){});
 
		return data;
		
 
		
	}
	
	
	
	

	@AfterMethod
	public void closedriver() {
		driver.close();

	}

}
