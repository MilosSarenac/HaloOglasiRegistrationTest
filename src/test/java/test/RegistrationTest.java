package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.*;

import java.util.Random;

public class RegistrationTest extends BaseTest {
    HomePage homePage;
    UlogujSePage logInPage;
    RegistracijaPage registrationPage;
    SuccessfulRegistrationPage successfulRegistrationPage;
    MailinatorHomePage mailinatorHomePage;
    MailinatorEmailPage mailinatorEmailPage;
    SuccessfulActivationPage successfulActivationPage;

    Random random = new Random();
    int randomint = random.nextInt(999999);
    String ime = "testtestts" + randomint;
    String email = ime + "@mailinator.com";
    String password = "password1234";

    @Before
    public void setUpTest(){
        homePage = new HomePage();
        logInPage = new UlogujSePage();
        registrationPage = new RegistracijaPage();
        successfulRegistrationPage = new SuccessfulRegistrationPage();
        mailinatorHomePage = new MailinatorHomePage();
        mailinatorEmailPage = new MailinatorEmailPage();
        successfulActivationPage = new SuccessfulActivationPage();
    }

    @Test
    public void RegistrationPageMessageConfirmation(){
    homePage.logInButtonClick();
    logInPage.registrationButtonClick();
    registrationPage.fizickoLiceButtonCheck();
    registrationPage.userNameInputFieldSendKeys(ime);
    registrationPage.emailInputFiledSendKey(email);
    registrationPage.passwordInputFieldSendKeys(password);
    registrationPage.confirmationPasswordInputFieldSendKeys(password);
    registrationPage.registrationButtonClick();
    Assert.assertTrue(successfulRegistrationPage.confirmationRegistrationMessageVisibility());
    Assert.assertEquals(successfulRegistrationPage.confirmatioRegistrationMessageText(),"Registracija je uspela!\n" +
            "Kako bi Vaš nalog postao aktivan, neophodno je da kliknite na link u mejlu koji Vam je poslat na : " + email + " !");
    driver.get("https://www.mailinator.com/");
    mailinatorHomePage.mailinatorInputFieldSendEmail(ime);
    mailinatorEmailPage.emailMessageInMailinatorClick();
    mailinatorEmailPage.iFrameClickAktivirajNalog();
    mailinatorEmailPage.switchToNewTab();
    Assert.assertTrue(successfulActivationPage.confirmationOfAccountActivationVisibility());
    Assert.assertEquals(successfulActivationPage.confitmationOfAccountActivationText(),"Vaš nalog je uspešno aktiviran!\n" +
            "Produžite na stranicu za logovanje kako biste pristupili našem portalu. Prijava");
    successfulActivationPage.prijavaButtonClick();
    logInPage.emailInputFieldSendkeys(email);
    logInPage.passwordInputFieldSendKeys(password);
    logInPage.ulogujMeButtonClick();

    }

}
