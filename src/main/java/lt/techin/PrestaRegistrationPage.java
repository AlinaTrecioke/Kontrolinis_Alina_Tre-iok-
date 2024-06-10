package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrestaRegistrationPage extends BasePage {

    @FindBy(css = "[for='field-id_gender-2'] [type]")
    private WebElement radioSocialTitleMrs;


    @FindBy(css = "input#field-firstname")
    private WebElement inputFirstName;


    @FindBy(css = "input#field-lastname")
    private WebElement inputLastName;


    @FindBy(css = "input#field-email")
    private WebElement inputEmail;

    @FindBy (css = "input#field-password")
    private WebElement inputPassword;

    @FindBy (css = "input#field-birthday")
    private WebElement inputBirthdate;


    @FindBy (css = "input[name='psgdpr']")
    private WebElement checkButtonAgreeWithTermsAndConditions;

    @FindBy (css = "input[name='customer_privacy']")
    private WebElement checkButtonCustomerDataPrivacy;

    @FindBy (css = ".btn.btn-primary.float-xs-right.form-control-submit")
    private WebElement buttonSave;



    public PrestaRegistrationPage(WebDriver driver) {
        super(driver);
    }


    public void selectSocialTitle() {
        radioSocialTitleMrs.click();
    }

    public void enterFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        inputLastName.sendKeys(lastName);
    }

    public void enterEmail(String email){
        inputEmail.sendKeys(email);
    }

    public void enterPassword(String password){
        inputPassword.sendKeys(password);
    }

    public void enterBirthdate(String birthdate){
        inputBirthdate.sendKeys(birthdate);
    }

    public void checkRequiredCheckBoxes(){
        checkButtonAgreeWithTermsAndConditions.click();
        checkButtonCustomerDataPrivacy.click();
    }

public void clickSaveButton(){
        buttonSave.click();
}

}
