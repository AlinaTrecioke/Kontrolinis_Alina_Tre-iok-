package lt.techin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrestaHomePage extends BasePage {


    @FindBy(css = ".user-info .hidden-sm-down")
    private WebElement buttonSignIn;

    @FindBy(css = "[title] .hidden-sm-down")
    private WebElement loggedInAccountsName;

    @FindBy(css = ".hidden-sm-down.logout")
    private WebElement buttonSignOut;


    @FindBy (css = "input[name='s']")
    private WebElement inputSearch;



    public PrestaHomePage(WebDriver driver) {
        super(driver);
    }


    public void clickSignInButton() {
        buttonSignIn.click();
    }

    public String getloggedInAccountsName() {
        return loggedInAccountsName.getText();
    }

    public boolean isSignOutDisplayed() {
        return buttonSignOut.isDisplayed();
    }

    public void signOut() {
        buttonSignOut.click();
    }

    public void goToMyAccount() {
        loggedInAccountsName.click();
    }

    public void enterProductNameToTheSearchField(String productName){
        inputSearch.sendKeys(productName);
        inputSearch.sendKeys(Keys.ENTER);
    }

}
