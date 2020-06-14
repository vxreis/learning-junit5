package homepage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductModalPage;
import pages.ProductPage;

public class HomePageTests extends BaseTests {
	
	// Pages
	LoginPage loginPage;
	ProductPage productPage;
	ProductModalPage productModalPage;
	
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
		
		productPage = homePage.selectProduct(0);
		
		String nameFromDetail = productPage.getName();
		String priceFromDetail = productPage.getPrice();
		
		assertEquals(nameFromHome.toUpperCase(), nameFromDetail.toUpperCase());
		assertEquals(priceFromHome.toUpperCase(), priceFromDetail.toUpperCase());
	}
	
	@Test
	public void test_givenUserLoggedAndAddProductInTheCart_thenShowMessageSuccess() {
		String size = "M";
		int amount = 2;
		
		productPage = homePage.selectProduct(0);
		productPage.selectSize(size);
		productPage.selectBlackColor();
		productPage.setAmount(amount);
		
		Double priceFromDetail = Double.parseDouble(productPage.getPrice());
		String nameProduct = productPage.getName().toUpperCase();
		Double price = Double.parseDouble(productPage.getPrice());
		
		productModalPage = productPage.clickAddToCard();
		
		assertTrue(productModalPage.getMsgAddToCart().endsWith("Product successfully added to your shopping cart"));
		
		assertEquals(nameProduct, productModalPage.getName().toUpperCase());
		assertEquals(priceFromDetail, Double.parseDouble(productModalPage.getPrice()));
		assertEquals(size, productModalPage.getSize());
		assertEquals("Black", productModalPage.getColor());
		assertEquals(amount, productModalPage.getAmount());
		
		Double subTotal = Double.parseDouble(productModalPage.getSubTotal());
		Double totalWithTax = Double.parseDouble(productModalPage.getTotal());
		Double totalWithoutTax = Double.parseDouble(productModalPage.geTtotalPriceWithoutTax());
		
		assertEquals(productModalPage.calcSubTotal(), subTotal);
		assertEquals(productModalPage.calcTotalWithTax(), totalWithTax);
		assertEquals(productModalPage.calcTotalWithoutTax(), totalWithoutTax);
	}
	
	/*@Test
	public void test_givenThatGoToTheCart_thenTheInformationMustPersist() {
		test_givenUserLoggedAndAddProductInTheCart_thenShowMessageSuccess();
		
		CartPage cartPage = productModalPage.clickCheckout();
		
		assertTrue(cartPage.isCartPage());
	}*/
}
