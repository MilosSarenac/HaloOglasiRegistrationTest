package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistracijaPage extends BaseTest {
    public RegistracijaPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Fizičkog lica')]")
    WebElement fizickoLiceButton;


    public void fizickoLiceButtonCheck(){
        wdWait.until(ExpectedConditions.visibilityOf(fizickoLiceButton));
        if (!fizickoLiceButton.isSelected()){
            fizickoLiceButton.click();
        }
    }
    @FindBy(id = "UserName")
    WebElement userNameInputField;
    public void userNameInputFieldSendKeys(String username){
        wdWait.until(ExpectedConditions.visibilityOf(userNameInputField)).sendKeys(username);
    }
    @FindBy(id = "Email")
    WebElement emailInputField;
    public void emailInputFiledSendKey(String email){
        wdWait.until(ExpectedConditions.visibilityOf(emailInputField)).sendKeys(email);
    }
    @FindBy(id = "Password")
    WebElement passwordInputField;
    public void passwordInputFieldSendKeys(String password){
        wdWait.until(ExpectedConditions.visibilityOf(passwordInputField)).sendKeys(password);
    }
    @FindBy(id = "ConfirmPassword")
    WebElement confirmationPasswordInputField;
    public void confirmationPasswordInputFieldSendKeys(String confirmPassword){
        wdWait.until(ExpectedConditions.visibilityOf(confirmationPasswordInputField)).sendKeys(confirmPassword);
    }
    @FindBy(css = ".button-reg.save.save-entity")
    WebElement registrationButton;
    public void registrationButtonClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(registrationButton)).click();
    }
}
