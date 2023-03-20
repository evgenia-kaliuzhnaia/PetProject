package scripts;

import browser.BrowserSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthorizationPage;

public class AuthorizationTest extends BrowserSetup {

    // correct login and password test
    @Test
    public void positiveLogin() {

        // open authorization page
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.openPage();

        // enter login and password
        authorizationPage.setLogin(properties.getProperty("correct.login"));
        authorizationPage.setPassword(properties.getProperty("correct.password"));

        // click the sign-in button
        authorizationPage.signIn();

        // verify that login process is successful
        Assert.assertEquals(driver.getCurrentUrl(), properties.getProperty("expected.value"));
    }

    // incorrect password test
    @Test
    public void negativeLogin() {

        // open authorization page
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.openPage();

        // enter correct login
        authorizationPage.setLogin(properties.getProperty("correct.login"));

        // enter wrong password
        authorizationPage.setPassword(properties.getProperty("wrong.password"));

        // click the sign-in button
        authorizationPage.signIn();

        // verify that error message is displayed
        Assert.assertTrue(authorizationPage.errorMessageDisplay());
    }

    // no username typed in test
    @Test
    public void noUsername() {

        // open authorization page
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.openPage();

        // enter password, leave login field empty
        authorizationPage.setPassword(properties.getProperty("correct.password"));

        // click the sign-in button
        authorizationPage.signIn();

        // verify that error message is displayed
        Assert.assertEquals(authorizationPage.errorTextMessage(), properties.getProperty("error.message.username.required"));
    }

    // no password typed in test
    @Test
    public void noPassword() {

        // open authorization page
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.openPage();

        // enter login, leave password field empty
        authorizationPage.setLogin(properties.getProperty("correct.login"));

        // click the sign-in button
        authorizationPage.signIn();

        // verify that error message is displayed
        Assert.assertEquals(authorizationPage.errorTextMessage(), properties.getProperty("error.message.password.required"));
    }
}