package homepage;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.LoginPage;

public class LoginPageTests extends BaseTests {
	
	@Test
	public void test_givenUserAndPasswodValid_thenUserLogged() {
		LoginPage loginPage = homePage.clickBtnSignIn();
		loginPage.fillEmail("marcelo@teste.com");
		loginPage.fillPassword("marcelo");
		loginPage.clickBtnSignIn();
		assertTrue(homePage.isLogged("Marcelo Bittencourt"));
	}
}
