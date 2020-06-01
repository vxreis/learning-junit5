package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	
	private By btnSignIn = By.xpath("//span[contains(text(),'Sign in')]");
	
	private By userLogged =  By.xpath("//a[@class='account']//span[@class='hidden-sm-down']");
	
	private By listProducts = By.className("thumbnail-container");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage clickBtnSignIn() {
		driver.findElement(btnSignIn).click();
		return new LoginPage(driver);
	}
	
	public boolean isLogged(String name) {
		return name.contentEquals(driver.findElement(userLogged).getText());
	}
}
