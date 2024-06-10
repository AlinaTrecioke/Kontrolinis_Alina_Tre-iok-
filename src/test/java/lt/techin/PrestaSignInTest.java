package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrestaSignInTest extends BaseTest{


    @Test
    void testLogin() {
        PrestaHomePage prestaHomePage = new PrestaHomePage(driver);
        prestaHomePage.clickSignInButton();

        PrestaSignInPage prestaSignInPage = new PrestaSignInPage(driver);
        String email = "testas@testas.com";
        prestaSignInPage.enterEmail(email);
        String password = "Testas+testas123";
        prestaSignInPage.enterPassword(password);
        prestaSignInPage.clickSignIn();

        /////First Assertion/////
        Assertions.assertTrue(prestaHomePage.isSignOutDisplayed());

        /////Second Assertion/////
        prestaHomePage.goToMyAccount();
        String expectedPageTitle = "My account";
        String actualPageTitle = driver.getTitle();
        Assertions.assertEquals(expectedPageTitle, actualPageTitle, "Page title is not the same as expected.");
    }



}
