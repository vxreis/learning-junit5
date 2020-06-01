package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

	private WebDriver driver;
	
	private By name = By.className("h1");
	
	private By price = By.xpath("//div[@class='product-price h5 has-discount']//span[1]");

	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getName() {
		return driver.findElement(name).getText();
	}
	
	public String getPrice() {
		return driver.findElement(price).getText();
	}
}
