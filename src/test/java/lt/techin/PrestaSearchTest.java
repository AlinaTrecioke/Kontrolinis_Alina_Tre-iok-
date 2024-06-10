package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class PrestaSearchTest extends BaseTest{

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/products.csv", numLinesToSkip = 1)
    void testSearch(String product, String price, String discount, String size) {
        PrestaHomePage prestaHomePage = new PrestaHomePage(driver);
        prestaHomePage.enterProductNameToTheSearchField(product);
        PrestaSearchResultPage prestaSearchResultPage = new PrestaSearchResultPage(driver);
        String expectedProductName = product.toLowerCase();
        String actualProductName = prestaSearchResultPage.getSearchedProductName().toLowerCase();

        /////Assert that names matches/////
        Assertions.assertEquals(expectedProductName, actualProductName, "Product names does not match.");

        /////Assert that product is displayed/////
        Assertions.assertTrue(prestaSearchResultPage.isSearchedProductDispalyed());
    }


}
