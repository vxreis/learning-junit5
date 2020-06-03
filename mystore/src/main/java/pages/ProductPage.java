package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

	private WebDriver driver;
	
	private By name = By.className("h1");
	
	private By price = By.cssSelector(".current-price span:nth-child(1)");
	
	private By size = By.id("group_1");
	
	private By amount = By.id("quantity_wanted");
	
	private By colorBlack = By.xpath("//ul[@id='group_2']//input[@value='11']");
	
	private By btnAddToCart = By.className("add-to-cart");
	
	private List<String> listSize;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getName() {
		return driver.findElement(name).getText();
	}
	
	public String getPrice() {
		return driver.findElement(price).getText().replace("$", "");
	}
	
	public Select findDropdownSize() {
		return new Select(driver.findElement(size));
	}
	
	public List<String> getListSize(){
		List<WebElement> listSizeSelected = findDropdownSize().getAllSelectedOptions();
		listSize = new ArrayList();
		for (WebElement element: listSizeSelected) {
			listSize.add(element.getText());
		}
		
		return listSize;
	}
	
	public void selectSize(String chosenSize) {
		findDropdownSize().selectByVisibleText(chosenSize);
	}
	
	public void selectBlackColor() {
		driver.findElement(colorBlack).click();
	}
	
	public void setAmount(int number) {
		driver.findElement(amount).clear();
		driver.findElement(amount).sendKeys(Integer.toString(number));
	}
	
	public ProductModalPage clickAddToCard() {
		driver.findElement(btnAddToCart).click();
		return new ProductModalPage(driver);
	}
}
