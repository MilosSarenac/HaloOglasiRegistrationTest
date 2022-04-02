package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessfulRegistrationPage extends BaseTest {
    public SuccessfulRegistrationPage (){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".regsitration-success")
    WebElement successfulRegistrationMessage1;
    public String confirmatioRegistrationMessageText(){
        wdWait.until(ExpectedConditions.visibilityOf(successfulRegistrationMessage1));
        return successfulRegistrationMessage1.getText();
    }
    public boolean confirmationRegistrationMessageVisibility(){
        return wdWait.until(ExpectedConditions.visibilityOf(successfulRegistrationMessage1)).isDisplayed();
    }

}
