package homepage;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import base.BaseTests;
import pages.LoginPage;

public class LoginPageTests extends BaseTests {
	
	@Test
	public void test_givenUserAndPasswodValid_thenUserLogged() {
		LoginPage loginPage = homePage.clickBtnSignIn();
		loginPage.toSign("marcelo@teste.com", "marcelo");
		assertTrue(homePage.isLogged("Marcelo Bittencourt"));
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/login.csv", numLinesToSkip = 1, delimiter = ';')
	public void test_givenUserAndPasswod(String testName, String user, String password, String fullName, String result_) {
		Boolean result = Boolean.parseBoolean(result_);
		
		LoginPage loginPage = homePage.clickBtnSignIn();
		loginPage.toSign(user, password);
		
		if (result) {
			assertTrue(homePage.isLogged(fullName));
			homePage.getClickLogout();
		}
		else {
			assertTrue(loginPage.getAlertLoginFailed());
		}
		
	}
}
