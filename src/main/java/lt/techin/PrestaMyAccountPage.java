package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrestaMyAccountPage extends BasePage{
    @FindBy(css = "a#identity-link  .material-icons")
    private WebElement fieldInformation;

    @FindBy (css = "input#field-email")
    private WebElement inputEmail;

    @FindBy (css = "input#field-password")
    private WebElement inputPassword;

    @FindBy (css = "input[name='psgdpr']")
    private WebElement checkboxAgreeTerms;

    @FindBy (css = "input[name='psgdpr']")
    private WebElement checkboxCustomerDataPrivacy;

@FindBy (css = ".btn.btn-primary.float-xs-right.form-control-submit")
private WebElement buttonSave;


    public PrestaMyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickFieldInformation(){
        fieldInformation.click();
    }

    public void changeEmail(String updatedEmail){
        inputEmail.clear();
        inputEmail.sendKeys(updatedEmail);
    }

    public void enterPassword(String password){
        inputPassword.sendKeys(password);
    }

public void clickToAgreeWithRequiredConditions(){
        checkboxAgreeTerms.click();
        checkboxCustomerDataPrivacy.click();
}

public void saveChanges(){
        buttonSave.click();
}

}
