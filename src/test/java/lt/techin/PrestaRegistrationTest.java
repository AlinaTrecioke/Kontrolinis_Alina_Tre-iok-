package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PrestaRegistrationTest extends BaseTest {

    @Test
    void testRegistration() throws InterruptedException {
        PrestaHomePage prestaHomePage = new PrestaHomePage(driver);
        prestaHomePage.clickSignInButton();
        PrestaSignInPage prestaSignInPage = new PrestaSignInPage(driver);
        prestaSignInPage.clickToCreateAccount();
        PrestaRegistrationPage prestaRegistrationPage = new PrestaRegistrationPage(driver);
        prestaRegistrationPage.selectSocialTitle();
        String firstName = "Testas";
        prestaRegistrationPage.enterFirstName(firstName);
        String lastName = "Testas";
        prestaRegistrationPage.enterLastName(lastName);
        String email = "ppp5@ppp.com";
        prestaRegistrationPage.enterEmail(email);
        String password = "ppp+ppp123";
        prestaRegistrationPage.enterPassword(password);
        String birthdate = "01/01/2000";
        prestaRegistrationPage.enterBirthdate(birthdate);
        prestaRegistrationPage.checkRequiredCheckBoxes();
        prestaRegistrationPage.clickSaveButton();

        /////First Assertion/////
        String loggedInAccount = prestaHomePage.getloggedInAccountsName();
        List<String> loggedInAccountFirstAndLastName = List.of(loggedInAccount.split(" "));
        String actualFirstName = loggedInAccountFirstAndLastName.get(0);
        String actualLastName = loggedInAccountFirstAndLastName.get(1);
        Assertions.assertEquals(firstName, actualFirstName, "Actual First Name should be the same as name provided in the input.");
        Assertions.assertEquals(lastName, actualLastName, "Actual Last Name should be the same as name provided in the input.");
        System.out.println(actualLastName + " " + actualLastName);

        /////Second Assertion/////
        Assertions.assertTrue(prestaHomePage.isSignOutDisplayed());

////////////////////////////////////////////////////
//        prestaHomePage.goToMyAccount();
//        PrestaMyAccountPage prestaMyAccountPage = new PrestaMyAccountPage(driver);
//        prestaMyAccountPage.clickFieldInformation();
//        prestaMyAccountPage.changeEmail("qqq1@qqq.com");
//        prestaMyAccountPage.enterPassword(password);
//        prestaMyAccountPage.clickToAgreeWithRequiredConditions();
//        prestaMyAccountPage.saveChanges();

        ////////////////////////////////////////////////////////////

        prestaHomePage.signOut();

    }


}

