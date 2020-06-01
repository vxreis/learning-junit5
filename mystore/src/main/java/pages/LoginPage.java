package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By txtEmail = By.name("email");
	
	private By txtPassword = By.name("password");
	
	private By btnSignIn = By.id("submit-login");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillEmail(String email) {
		driver.findElement(txtEmail).sendKeys(email);
	}
	
	public void fillPassword(String password) {
		driver.findElement(txtPassword).sendKeys(password);
	}
	
	public void clickBtnSignIn() {
		driver.findElement(btnSignIn).click();
	}
}
