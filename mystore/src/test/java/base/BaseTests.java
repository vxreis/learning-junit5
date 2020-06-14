package base;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;

public class BaseTests {
	private static WebDriver driver;
	protected HomePage homePage;
	
	@BeforeAll
	public static void initWebDriver() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\webdrivers\\chromedriver\\83\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // Espera implícita
	}
	
	@BeforeEach
	public void loadPage() {
		driver.get("https://marcelodebittencourt.com/demoprestashop/");
		homePage = new HomePage(driver);
	}
	
	@AfterAll
	public static void quit() {
		driver.quit();
	}
}
