package homepage;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.LoginPage;

public class LoginPageTests extends BaseTests {
	
	@Test
	public void test_givenUserAndPasswodValid_thenUserLogged() {
		LoginPage loginPage = homePage.clickBtnSignIn();
		loginPage.toSign("marcelo@teste.com", "marcelo");
		assertTrue(homePage.isLogged("Marcelo Bittencourt"));
	}
}
