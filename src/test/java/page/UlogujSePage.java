package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UlogujSePage extends BaseTest {
    public UlogujSePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".no-account-reg-link")
    WebElement registrationButton;
    public void registrationButtonClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(registrationButton)).click();
    }
    @FindBy(id = "EMailOrUsername")
    WebElement emailInputField;
    public void emailInputFieldSendkeys(String email){
        wdWait.until(ExpectedConditions.visibilityOf(emailInputField)).sendKeys(email);
    }
    @FindBy(id = "Password")
    WebElement passwordInputField;
    public void passwordInputFieldSendKeys(String password){
        wdWait.until(ExpectedConditions.visibilityOf(passwordInputField)).sendKeys(password);
    }
    @FindBy(css = ".btn-main")
    WebElement ulogujMeButton;
    public void ulogujMeButtonClick(){
        wdWait.until(ExpectedConditions.visibilityOf(ulogujMeButton)).click();
    }
}
