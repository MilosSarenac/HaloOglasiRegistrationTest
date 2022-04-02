package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.*;

public class RegistrationTest extends BaseTest {
    HomePage homePage;
    UlogujSePage logInPage;
    RegistracijaPage registrationPage;
    SuccessfulRegistrationPage successfulRegistrationPage;
    MailinatorHomePage mailinatorHomePage;
    MailinatorEmailPage mailinatorEmailPage;
    SuccessfulActivationPage successfulActivationPage;

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
    registrationPage.userNameInputFieldSendKeys("qweasdzxc12345");
    registrationPage.emailInputFiledSendKey("qweasdzxc12345@mailinator.com");
    registrationPage.passwordInputFieldSendKeys("password123");
    registrationPage.confirmationPasswordInputFieldSendKeys("password123");
    registrationPage.registrationButtonClick();
    Assert.assertTrue(successfulRegistrationPage.confirmationRegistrationMessageVisibility());
    Assert.assertEquals(successfulRegistrationPage.confirmatioRegistrationMessageText(),"Registracija je uspela!\n" +
            "Kako bi Vaš nalog postao aktivan, neophodno je da kliknite na link u mejlu koji Vam je poslat na : qweasdzxc12345@mailinator.com !");
    driver.get("https://www.mailinator.com/");
    mailinatorHomePage.mailinatorInputFieldSendEmail("qweasdzxc12345");
    mailinatorEmailPage.emailMessageInMailinatorClick();
    mailinatorEmailPage.iFrameClickAktivirajNalog();
    driver.close();
    Assert.assertTrue(successfulActivationPage.confirmationOfAccountActivationVisibility());
    Assert.assertEquals(successfulActivationPage.confitmationOfAccountActivationText(),"Vaš nalog je uspešno aktiviran! Produžite na stranicu za logovanje kako biste pristupili našem portalu. ");
    successfulActivationPage.prijavaButtonClick();
    logInPage.emailInputFieldSendkeys("qweasdzxc12345@mailinator.com");
    logInPage.passwordInputFieldSendKeys("password123");
    logInPage.ulogujMeButtonClick();
    successfulActivationPage.prijavaButtonClick();
    }

}
