package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;

public class PrestaSearchResultPage extends BasePage{


    @FindBy (css = "h2 > a")
    private WebElement searchedProductName;


    public PrestaSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickToOpenProductPage(){
        searchedProductName.click();
    }

    public String getSearchedProductName(){
        return searchedProductName.getText();
    }

    public boolean isSearchedProductDispalyed(){
        return searchedProductName.isDisplayed();
    }


}
