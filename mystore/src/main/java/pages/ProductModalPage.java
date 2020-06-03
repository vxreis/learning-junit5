package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class ProductModalPage {
	
	private WebDriver driver;
	
	private By statusAddToCart = By.id("myModalLabel");
	
	private By name = By.xpath("//h6[@class='h6 product-name']");
	
	private By price = By.xpath("//p[@class='product-price']");
	
	private By productInfo = By.tagName("strong");
	
	private By totalPrice = By.cssSelector("div p span.value");
	
	public ProductModalPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private void waitElement(By element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public String getMsgAddToCart() {
		waitElement(statusAddToCart);
		return driver.findElement(statusAddToCart).getText();
	}
	
	public String getName() {
		return driver.findElement(name).getText();
	}
	
	public String getPrice() {
		return driver.findElement(price).getText().replace("$", "");
	}
	
	public String getSize() {
		return driver.findElements(productInfo).get(0).getText();
	}
	
	public String getColor() {
		return driver.findElements(productInfo).get(1).getText();
	}
	
	public int getAmount() {
		return Integer.parseInt(driver.findElements(productInfo).get(2).getText());
	}
	
	public String getSubTotal() {
		return driver.findElements(totalPrice).get(0).getText().replace("$", "");
	}
	
	public String getSipping() {
		return driver.findElements(totalPrice).get(1).getText().replace("$", "");
	}
	
	public String getTotal() {
		return driver.findElements(totalPrice).get(2).getText().replace("$", "");
	}
}
