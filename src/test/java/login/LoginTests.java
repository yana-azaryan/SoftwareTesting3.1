package login;
import base.BaseTest;
import constants.locators.ZigzagAccountPageLocators;
import constants.variables.ZigzagAccountPageVariables;
import constants.messages.LoginErrorMessages;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.AccountPage;

public class LoginTests extends BaseTest {
    @Test
    public void zigzagWrongSignInInputFormatTest() {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.clickSignIn();
        loginPage.sendLoginData("tom", "");

        softAssert.assertTrue(loginPage.getEmailError().contains(LoginErrorMessages.LOGIN_EMAIL_ERROR));
        softAssert.assertTrue(loginPage.getPasswordError().contains(LoginErrorMessages.LOGIN_REQUIRED_FIELD_ERROR));
    }

    @Test
    public void zigzagFailedSignInTest() {
        SoftAssert softAssert = new SoftAssert();

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.clickSignIn();
        loginPage.sendLoginData("brown@gmail.com", "SuperSecretPassword");

        softAssert.assertTrue(loginPage.getAuthenticationPopupText().contains(LoginErrorMessages.LOGIN_AUTHENTICATION_POPUP));
    }

    @Test
    public void zigzagSuccessfulSignInTest() {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AccountPage accountPage = new AccountPage(driver);

        homePage.clickSignIn();
        loginPage.sendLoginData("yana_azaryan@edu.aua.am", "SuperSecretPassword!");

        softAssert.assertTrue(accountPage.getLoggedInPage().contains(ZigzagAccountPageVariables.ACCOUNT_TEXT));
    }
}
