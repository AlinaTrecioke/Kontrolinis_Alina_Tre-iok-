package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class PrestaShoppingCartTest extends BaseTest{

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/products.csv", numLinesToSkip = 1)
    void testCheckOut(String product, String price, String discount, String size) throws InterruptedException {
        PrestaHomePage prestaHomePage = new PrestaHomePage(driver);
        prestaHomePage.enterProductNameToTheSearchField(product);
        PrestaSearchResultPage prestaSearchResultPage = new PrestaSearchResultPage(driver);
        prestaSearchResultPage.clickToOpenProductPage();
        PrestaProductPage prestaProductPage = new PrestaProductPage(driver);
        prestaProductPage.selectSize(size);
        prestaProductPage.addToCart();
        prestaProductPage.clickButtonCheckOut();
        PrestaShoppingCartPage prestaShoppingCartPage = new PrestaShoppingCartPage(driver);

        /////Assert that product names are the same/////
        String expectedProductNameAddedToCart = product.toLowerCase();
        String actualProductNameAddedToCart = prestaShoppingCartPage.getProductName().toLowerCase();
        Assertions.assertEquals(expectedProductNameAddedToCart, actualProductNameAddedToCart, "Product in the cart should be the same as expected.");

        /////Assert that size is as selected/////
        String expectedSize = size;
        String actualSize = prestaShoppingCartPage.getSizeSelected();
        Assertions.assertEquals(expectedSize, actualSize, "Size in shopping cart should be the same as expected.");

        /////Assert that discount is correct/////
        String expectedDiscount = discount;
        String actualDiscount = prestaShoppingCartPage.getDiscountSize().replaceFirst("-", "").replaceAll("%", "");
        Assertions.assertEquals(expectedDiscount, actualDiscount, "Discount should be applied as expected.");

    }

}
