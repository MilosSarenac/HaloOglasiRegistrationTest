package page;

import base.BaseTest;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailinatorHomePage extends BaseTest {
    public MailinatorHomePage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "search")
    WebElement mailinatorInputField;
    public void mailinatorInputFieldSendEmail(String email){
        wdWait.until(ExpectedConditions.visibilityOf(mailinatorInputField)).sendKeys(email);
        mailinatorInputField.sendKeys(Keys.ENTER);
    }
}
