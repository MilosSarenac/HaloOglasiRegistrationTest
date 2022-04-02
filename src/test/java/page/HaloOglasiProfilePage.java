package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HaloOglasiProfilePage extends BaseTest {
    public HaloOglasiProfilePage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".logged-in-icon")
    WebElement mojProfilDropDown;
    public void mojProfilDropDownHover(){
        wdWait.until(ExpectedConditions.elementToBeClickable(mojProfilDropDown));
        action.moveToElement(mojProfilDropDown).perform();
    }
    @FindBy(css = ".user-email")
    WebElement emailProfilePage;
    public boolean emailProfilePageVisibility(){
        return wdWait.until(ExpectedConditions.visibilityOf(emailProfilePage)).isDisplayed();
    }
    public String emailProfilePageText(){
        wdWait.until(ExpectedConditions.visibilityOf(emailProfilePage)).isDisplayed();
        return emailProfilePage.getText();
    }
    @FindBy(css = ".user-username")
    WebElement usernameProfilePage;
    public boolean usernameProfilePageVisibility(){
        return wdWait.until(ExpectedConditions.visibilityOf(usernameProfilePage)).isDisplayed();
    }
    public String usernameProfilePageText() {
        wdWait.until(ExpectedConditions.visibilityOf(usernameProfilePage)).isDisplayed();
        return usernameProfilePage.getText();
    }
}
