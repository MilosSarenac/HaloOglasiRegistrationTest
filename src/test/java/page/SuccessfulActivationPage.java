package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessfulActivationPage extends BaseTest {
    public SuccessfulActivationPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[contains(@class,'regsitration-success')]")
    WebElement registrationSuccess;
    public boolean confirmationOfAccountActivationVisibility(){
       return wdWait.until(ExpectedConditions.visibilityOf(registrationSuccess)).isDisplayed();
    }
    public String confitmationOfAccountActivationText(){
        wdWait.until(ExpectedConditions.visibilityOf(registrationSuccess)).isDisplayed();
        return registrationSuccess.getText();
    }
    @FindBy(xpath = "//a[contains(text(),'Prijava')]")
    WebElement prijavaButton;
    public void prijavaButtonClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(prijavaButton)).click();
    }
}
