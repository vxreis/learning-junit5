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
	
	private By totalPriceWithoutTax = By.xpath("//p[4]//span[2]");
	
	private By btnCheckout = By.cssSelector("div.cart-content-btn a");
	
	public ProductModalPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private void waitElement(By element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public String getMsgAddToCart() {
		/* Espera explícita
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(statusAddToCart)); */
		
		waitElement(statusAddToCart);  // Espera customizada
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
		//return UtilFunctions.removeDollarSign(driver.findElements(totalPrice).get(0).getText());
		return driver.findElements(totalPrice).get(0).getText().replace("$", "");
	}
	
	public String getShipping() {
		return driver.findElements(totalPrice).get(1).getText().replace("$", "");
	}
	
	public String getTotal() {
		return driver.findElements(totalPrice).get(2).getText().replace("$", "");
	}
	
	public String getTaxes() {
		return driver.findElements(totalPrice).get(3).getText().replace("$", "");
	}
	
	public String geTtotalPriceWithoutTax() {
		return driver.findElement(totalPriceWithoutTax).getText().replace("$", "");
	}
	
	public Double calcSubTotal() {
		Double priceInDouble = Double.parseDouble(getPrice());
		return priceInDouble * getAmount();
	}
	
	public Double calcTotalWithTax() {
		return calcSubTotal() + Double.parseDouble(getShipping()) + Double.parseDouble(getTaxes());
	}
	
	public Double calcTotalWithoutTax() {
		return calcSubTotal() + Double.parseDouble(getShipping());
	}
	
	public CartPage clickCheckout() {
		driver.findElement(btnCheckout).click();
		return new CartPage(driver);
	}
}
