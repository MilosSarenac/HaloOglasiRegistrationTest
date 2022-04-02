package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.*;

import java.util.Random;

public class RegistrationTest extends BaseTest {
    HaloOglasiHomePage haloOglasiHomePage;
    UlogujSePage logInPage;
    RegistracijaPage registrationPage;
    SuccessfulRegistrationPage successfulRegistrationPage;
    MailinatorHomePage mailinatorHomePage;
    MailinatorEmailPage mailinatorEmailPage;
    SuccessfulActivationPage successfulActivationPage;
    HaloOglasiProfilePage haloOglasiProfilePage;

    Random random = new Random();
    int randomint = random.nextInt(999999);
    String username = "testtestts" + randomint;
    String email = username + "@mailinator.com";
    String password = "password1234";
    String registrationPageAssertText = "Registracija je uspela!\n" + "Kako bi Vaš nalog postao aktivan, neophodno je da kliknite na link u mejlu koji Vam je poslat na : ";
    String activationPageAssertText = "Vaš nalog je uspešno aktiviran!\n" + "Produžite na stranicu za logovanje kako biste pristupili našem portalu. Prijava";

    @Before
    public void setUpTest(){
        haloOglasiHomePage = new HaloOglasiHomePage();
        logInPage = new UlogujSePage();
        registrationPage = new RegistracijaPage();
        successfulRegistrationPage = new SuccessfulRegistrationPage();
        mailinatorHomePage = new MailinatorHomePage();
        mailinatorEmailPage = new MailinatorEmailPage();
        successfulActivationPage = new SuccessfulActivationPage();
        haloOglasiProfilePage = new HaloOglasiProfilePage();
    }

    @Test
    public void RegistrationPageMessageConfirmation(){
    haloOglasiHomePage.logInButtonClick();
    logInPage.registrationButtonClick();
    registrationPage.fizickoLiceButtonCheck();
    registrationPage.userNameInputFieldSendKeys(username);
    registrationPage.emailInputFiledSendKey(email);
    registrationPage.passwordInputFieldSendKeys(password);
    registrationPage.confirmationPasswordInputFieldSendKeys(password);
    registrationPage.registrationButtonClick();
    Assert.assertTrue(successfulRegistrationPage.confirmationRegistrationMessageVisibility());
    Assert.assertEquals(successfulRegistrationPage.confirmatioRegistrationMessageText(),registrationPageAssertText + email + " !");
    driver.get("https://www.mailinator.com/");
    mailinatorHomePage.mailinatorInputFieldSendEmail(username);
    mailinatorEmailPage.emailMessageInMailinatorClick();
    mailinatorEmailPage.iFrameClickAktivirajNalog();
    mailinatorEmailPage.switchToNewTab();
    Assert.assertTrue(successfulActivationPage.confirmationOfAccountActivationVisibility());
    Assert.assertEquals(successfulActivationPage.confitmationOfAccountActivationText(),activationPageAssertText);
    successfulActivationPage.prijavaButtonClick();
    logInPage.emailInputFieldSendkeys(email);
    logInPage.passwordInputFieldSendKeys(password);
    logInPage.ulogujMeButtonClick();
    haloOglasiProfilePage.mojProfilDropDownHover();
    Assert.assertTrue(haloOglasiProfilePage.emailProfilePageVisibility());
    Assert.assertEquals(haloOglasiProfilePage.emailProfilePageText(),"email: " + email);
    Assert.assertTrue(haloOglasiProfilePage.usernameProfilePageVisibility());
    Assert.assertEquals(haloOglasiProfilePage.usernameProfilePageText(),"korisničko ime: " + username);

    }

}
