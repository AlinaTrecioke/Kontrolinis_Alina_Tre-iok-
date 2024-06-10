package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrestaShoppingCartPage extends BasePage{


    @FindBy (css = "[class] .product-line-info:nth-of-type(1)")
    private WebElement productName;


    @FindBy (css = ".size .value")
    private WebElement sizeSelected;



    @FindBy (css = ".js-cart-detailed-actions .btn-primary")
    private WebElement buttonProceedToCheckOut;


    @FindBy (css = ".discount.discount-percentage")
    private WebElement discountField;

    public PrestaShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){
        return productName.getText();
    }

    public String getSizeSelected(){
        return sizeSelected.getText();
    }

public String getDiscountSize(){
        return discountField.getText();
}

public void clickButtonProceedToCheckOut(){
        buttonProceedToCheckOut.click();
}

}
