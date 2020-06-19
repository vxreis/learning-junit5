package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver driver;
	
	private By btnSignIn = By.xpath("//span[contains(text(),'Sign in')]");
	
	private By userLogged =  By.xpath("//a[@class='account']//span[@class='hidden-sm-down']");
	
	private By products = By.className("thumbnail-container");
	
	private By numberInTheCart = By.className("cart-products-count");
	
	private By productsName = By.cssSelector(".product-description a");
	
	private By productsPrice = By.className("price");
	
	private By btnLogout = By.cssSelector("a.logout");
	
	List<WebElement> listProducts = new ArrayList<WebElement>();
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage clickBtnSignIn() {
		driver.findElement(btnSignIn).click();
		return new LoginPage(driver);
	}
	
	public boolean isLogged(String name) {
		try {
			return name.contentEquals(driver.findElement(userLogged).getText());
		} catch (NoSuchMethodError e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	private void loadListProducts() {
		listProducts = driver.findElements(products);
	}
	
	public int countProductsFromHome() {
		loadListProducts();
		return listProducts.size();
	}
	
	public int numberOfItemsInTheCart() {
		String number = driver.findElement(numberInTheCart).getText()
				.replace("(", "").replace(")", "");
		return Integer.parseInt(number);
	}
	
	public String getProductName(int index) {
		return driver.findElements(productsName).get(index).getText();
	}
	
	public String getProductPrice(int index) {
		return driver.findElements(productsPrice).get(index).getText();
	}
	
	public ProductPage selectProduct(int index) {
		driver.findElements(productsName).get(index).click();
		return new ProductPage(driver);
	}
	
	public void getClickLogout() {
		driver.findElement(btnLogout).click();
	}
}
