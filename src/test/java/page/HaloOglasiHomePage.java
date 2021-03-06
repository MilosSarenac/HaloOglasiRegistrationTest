package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HaloOglasiHomePage extends BaseTest {

    public HaloOglasiHomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Uloguj se')]")
    WebElement logInButton;

    public void logInButtonClick() {
        wdWait.until(ExpectedConditions.visibilityOf(logInButton)).click();
    }
}
