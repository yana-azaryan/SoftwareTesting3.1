package account;

import base.BaseTest;
import constants.locators.ZigzagAccountPageLocators;
import constants.variables.ZigzagAccountPageVariables;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class AccountTest extends BaseTest {
    @Test
    public void zigzagBasketTest() {
        SoftAssert softAssert = new SoftAssert();
        AccountPage accountPage = new AccountPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.clickSignIn();
        loginPage.sendLoginData("yana_azaryan@edu.aua.am", "SuperSecretPassword!");
        accountPage.goToAccountFavourites();

        softAssert.assertTrue(accountPage.getFavouriteItem().contains(ZigzagAccountPageVariables.FAVOURITE_ITEM_NAME));
    }

    @Test
    public void zigzagUserDetailsTest() {
        SoftAssert softAssert = new SoftAssert();
        AccountPage accountPage = new AccountPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.clickSignIn();
        loginPage.sendLoginData("yana_azaryan@edu.aua.am", "SuperSecretPassword!");
        accountPage.goToAccountDetails();
        accountPage.changeUserFirstname(ZigzagAccountPageVariables.USER_NAME);
        accountPage.saveUserChanges();

        softAssert.assertTrue(accountPage.getUserName().contains(ZigzagAccountPageVariables.USER_NAME));
    }
}
