package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class MailinatorEmailPage extends BaseTest {
    public MailinatorEmailPage () {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//td[contains(text(),'Halo Oglasi')]")
    WebElement emailMessageInMailinator;
    public void emailMessageInMailinatorClick(){
        wdWait.until(ExpectedConditions.visibilityOf(emailMessageInMailinator)).click();
    }
    @FindBy(xpath = "//strong [contains(text(),'Aktiviraj nalog')]")
    WebElement iFrame;
    public void iFrameClickAktivirajNalog(){
        driver.switchTo().frame("html_msg_body");
        js.executeScript("window.scrollBy(0,250)");
        wdWait.until(ExpectedConditions.visibilityOf(iFrame)).click();
        driver.switchTo().defaultContent();
    }
    public void switchToNewTab(){
        wdWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> numbersOfTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(numbersOfTabs.get(1));
    }
}
