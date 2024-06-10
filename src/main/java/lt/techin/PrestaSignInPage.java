package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrestaSignInPage extends BasePage{


    @FindBy (css = "[data-link-action='display-register-form']")
    private WebElement buttonCreateAccount;

    @FindBy (css = "input#field-email")
    private WebElement inputEmail;

    @FindBy (css = "input#field-password")
    private WebElement inputPassword;

    @FindBy (css = "button#submit-login")
    private WebElement buttonSignIn;


    public PrestaSignInPage(WebDriver driver) {
        super(driver);
    }


    public void clickToCreateAccount(){
        buttonCreateAccount.click();
    }

    public void enterEmail(String email){
        inputEmail.sendKeys(email);
    }

    public void enterPassword(String password){
        inputPassword.sendKeys(password);
    }

    public void clickSignIn(){
        buttonSignIn.click();
    }

}
