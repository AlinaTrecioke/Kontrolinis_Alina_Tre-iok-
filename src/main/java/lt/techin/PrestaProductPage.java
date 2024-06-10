package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PrestaProductPage extends BasePage {

    @FindBy(css = ".wishlist-button-product .material-icons")
    private WebElement buttonAddToWishList;

    @FindBy(css = ".show .modal-content")
    private WebElement messageNeedToBeLoogedIn;


    @FindBy(css = ".modal-text")
    private WebElement textOfTheMessageNeedToBeLoggedIn;

    @FindBy(css = ".show .btn-secondary")
    private WebElement buttonCancel;


    @FindBy(css = "[aria-label='Size']")
    private WebElement selectionSize;

    @FindBy(css = ".add-to-cart.btn.btn-primary")
    private WebElement buttonAddToCart;


    @FindBy(css = "#product > [tabindex] .modal-content")
    private WebElement messageSuccessfullyAddedToCart;

    @FindBy(css = "#myModalLabel")
    private WebElement textOfTheMessageSuccessfullyAddedToCart;


    @FindBy (css = ".cart-content-btn .btn-primary")
    private WebElement buttonCheckOut;



    public PrestaProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonAddToWishList() {
        buttonAddToWishList.click();
    }


    public boolean isMessageNeedToBeLogeInDisplayed() {
        return messageNeedToBeLoogedIn.isDisplayed();
    }

    public String getTextOfTheMessageNeedToBeLoggedIn() {
        return textOfTheMessageNeedToBeLoggedIn.getText();
    }

    public void clickButtonCancel() {

        buttonCancel.click();
    }


    public void selectSize(String size) {
        selectionSize.click();
        Select drpdwnByVisibleText = new Select(driver.findElement(By.cssSelector("[aria-label='Size']")));
        drpdwnByVisibleText.selectByVisibleText(size);
    }

    public void addToCart() {
        buttonAddToCart.click();
    }

    public boolean isMessageSuccessfullyAddedToCartDisplayed() {
        return messageSuccessfullyAddedToCart.isDisplayed();
    }

    public String getTextOfTheMessageSuccessfullyAddedToCart() {
        return textOfTheMessageSuccessfullyAddedToCart.getText();
    }

    public void clickButtonCheckOut(){
        buttonCheckOut.click();
    }


}
