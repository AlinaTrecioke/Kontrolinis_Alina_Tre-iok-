package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class PrestaProductTest extends BaseTest {


    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/products.csv", numLinesToSkip = 1)
    void testAddToWishList(String product, String price, String discount, String size) {
        PrestaHomePage prestaHomePage = new PrestaHomePage(driver);
        prestaHomePage.enterProductNameToTheSearchField(product);
        PrestaSearchResultPage prestaSearchResultPage = new PrestaSearchResultPage(driver);
        prestaSearchResultPage.clickToOpenProductPage();
        PrestaProductPage prestaProductPage = new PrestaProductPage(driver);
        prestaProductPage.clickButtonAddToWishList();

        /////Assert that message is displayed/////
        Assertions.assertTrue(prestaProductPage.isMessageNeedToBeLogeInDisplayed());


        /////Assert that text of the message matches expected text/////
        String expectedTextOfTheAlert = "You need to be logged in to save products in your wishlist.";
        String actualTextOfTheAlert = prestaProductPage.getTextOfTheMessageNeedToBeLoggedIn();
        Assertions.assertEquals(expectedTextOfTheAlert, actualTextOfTheAlert, "Text of the alert should be the same as expected.");

        prestaProductPage.clickButtonCancel();
    }


    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/products.csv", numLinesToSkip = 1)
    void testAddToCart(String product, String price, String discount, String size) throws InterruptedException {
        PrestaHomePage prestaHomePage = new PrestaHomePage(driver);
        prestaHomePage.enterProductNameToTheSearchField(product);
        PrestaSearchResultPage prestaSearchResultPage = new PrestaSearchResultPage(driver);
        prestaSearchResultPage.clickToOpenProductPage();
        PrestaProductPage prestaProductPage = new PrestaProductPage(driver);
        prestaProductPage.selectSize(size);
        prestaProductPage.addToCart();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                        .pollingEvery(Duration.ofMillis(300));
        wait.until(d -> (prestaProductPage.isMessageSuccessfullyAddedToCartDisplayed()));


        /////Assert that success message is displayed/////
        Assertions.assertTrue(prestaProductPage.isMessageSuccessfullyAddedToCartDisplayed());

        /////Assert that text of the success message is as expected/////
        String expectedTextOfTheSuccessMessage = "Product successfully added to your shopping cart";
        String actualTextOfTheSuccessMessage = prestaProductPage.getTextOfTheMessageSuccessfullyAddedToCart();
        actualTextOfTheSuccessMessage = actualTextOfTheSuccessMessage.substring(1);
        Assertions.assertEquals(expectedTextOfTheSuccessMessage, actualTextOfTheSuccessMessage, "Text of the success message should be the same as expected.");
    }

}
