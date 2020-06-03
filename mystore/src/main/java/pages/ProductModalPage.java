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
	
	private By size = By.xpath("//span[1]//strong[1]");
	
	private By color = By.xpath("//span[2]//strong[1]");
	
	private By amount = By.xpath("//span[3]//strong[1]");
	
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
		return driver.findElement(size).getText();
	}
	
	public String getColor() {
		return driver.findElement(color).getText();
	}
	
	public String getAmount() {
		return driver.findElement(amount).getText();
	}
}
