package home;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import constants.locators.ZigzagHomePageLocators;
import constants.variables.ZigzagHomePageVariables;

public class HomeTest extends BaseTest {
    @Test
    public void zigzagCatalogTest() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);

        homePage.clickCatalogButton();

        softAssert.assertTrue(homePage.getCatalogItem().contains(ZigzagHomePageVariables.CATALOG_SECTION_NAME));
    }

    @Test
    public void zigzagSearchTest() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);

        homePage.searchItem("Dyson");

        softAssert.assertTrue(homePage.getSearchResult().contains(ZigzagHomePageVariables.SEARCH_RESULTS));
    }
}
