package homepage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.LoginPage;
import pages.ProductModalPage;
import pages.ProductPage;

public class HomePageTests extends BaseTests {
	
	LoginPage loginPage;
	ProductPage product;
	
	@Test
	public void test_givenOpenPage_thenShowEightProducts() {
		assertEquals(8, homePage.countProductsFromHome());
	}
	
	@Test
	public void test_givenOpenPage_thenShowCardEmpty() {
		assertEquals(0, homePage.numberOfItemsInTheCart());
	}
	
	@Test
	public void test_givenSelectProduct_thenInformationShouldBeEquals() {
		String nameFromHome = homePage.getProductName(0);
		String priceFromHome = homePage.getProductPrice(0);
		
		product = homePage.selectProduct(0);
		
		String nameFromDetail = product.getName();
		String priceFromDetail = product.getPrice();
		
		assertEquals(nameFromHome.toUpperCase(), nameFromDetail.toUpperCase());
		assertEquals(priceFromHome.toUpperCase(), priceFromDetail.toUpperCase());
	}
	
	@Test
	public void test_givenUserAndPasswodValid_thenUserLogged() {
		loginPage = homePage.clickBtnSignIn();
		loginPage.toSign("marcelo@teste.com", "marcelo");
		assertTrue(homePage.isLogged("Marcelo Bittencourt"));
	}
	
	@Test
	public void test_givenUserLoggedAndAddProductInTheCart_thenShowMessageSuccess() {
		String size = "M";
		int amount = 2;
		
		if (!homePage.isLogged("Marcelo Bittencourt")) {
			test_givenUserAndPasswodValid_thenUserLogged(); 
			loadPage();
		}
		
		product = homePage.selectProduct(0);
		product.selectSize(size);
		product.selectBlackColor();
		product.setAmount(amount);
		
		ProductModalPage productModalPage = product.clickAddToCard();
		
		assertTrue(productModalPage.getMsgAddToCart().endsWith("Product successfully added to your shopping cart"));
		assertEquals(size, productModalPage.getSize());
		assertEquals("Black", productModalPage.getColor());
		assertEquals(amount, productModalPage.getAmount());
	}
}
