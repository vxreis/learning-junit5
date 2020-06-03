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
	
	private By productInfo = By.tagName("strong");
	
	public ProductModalPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getMsgAddToCart() {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(statusAddToCart));
		
		return driver.findElement(statusAddToCart).getText();
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
}
