package homepage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.ProductPage;

public class HomePageTests extends BaseTests {
	
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
		
		ProductPage product = homePage.selectProduct(0);
		
		String nameFromDetail = product.getName();
		String priceFromDetail = product.getPrice();
		
		assertEquals(nameFromHome.toUpperCase(), nameFromDetail.toUpperCase());
		assertEquals(priceFromHome.toUpperCase(), priceFromDetail.toUpperCase());
	}
}
