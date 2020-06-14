package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	
	private WebDriver driver;
	
	private By pageName = By.className("h1");
	
	private By name = By.linkText("Hummingbird printed t-shirt");
	
	private By price = By.className("price");
	
	private By infoSizeAndColor = By.cssSelector("div.product-line-info span.value");
	
	private By amount = By.name("product-quantity-spin");
	
	private By productPrice = By.tagName("strong");
	
	private By cart = By.cssSelector("div.card-block span.value");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public Boolean isCartPage() {
		String txt = driver.findElement(pageName).getText().toLowerCase();
		return txt.equals("shopping cart");
	}
	
	public String getName() {
		return driver.findElement(name).getText();
	}

	public String getPrice() {
		return driver.findElement(price).getText();
	}
	
	public String getSize() {
		return driver.findElements(infoSizeAndColor).get(0).getText();
	}
	
	public String getColor() {
		return driver.findElements(infoSizeAndColor).get(1).getText();
	}
	
	public int getAmount() {
		return Integer.parseInt(driver.findElement(amount).getText());
	}
			            
	public String get_productPrice() {
		return driver.findElement(productPrice).getText();
	}
	
	public String getSubTotal() {
		return driver.findElements(cart).get(0).getText();
	}
	
	public String getShipping() {
		return driver.findElements(cart).get(1).getText();
	}
	
	public String getTotal() {
		return driver.findElements(cart).get(3).getText();
	}
	
	public String getTotalWithoutTax() {
		return driver.findElements(cart).get(2).getText();
	}
	
	public String getTaxes() {
		return driver.findElements(cart).get(4).getText();
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
}
