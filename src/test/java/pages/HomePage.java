package pages;

import constants.locators.ZigzagHomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By signIn = By.className(ZigzagHomePageLocators.SIGN_BLOCK_CLASSNAME);
    private By catalogButton = By.className(ZigzagHomePageLocators.PAGE_CATALOG_CLASSNAME);
    private By listInner = By.className(ZigzagHomePageLocators.CATALOG_INNER_CLASSNAME);
    private By search = By.id(ZigzagHomePageLocators.SEARCH_ID);
    private By searchButton = By.xpath(ZigzagHomePageLocators.SEARCH_BUTTON_XPATH);
    private By pageInner = By.className(ZigzagHomePageLocators.RESULTS_PAGE_CLASSNAME);

    public HomePage(WebDriver driver) { this.driver = driver; }

    public void clickSignIn() {
        driver.findElement(signIn).click();
    }

    public void clickCatalogButton() {
        driver.findElement(catalogButton).click();
    }

    public String getCatalogItem() {
        return driver.findElement(listInner).getText();
    }

    public void fillSearch(String key) {
        driver.findElement(search).sendKeys(key);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public void searchItem(String key) {
        fillSearch(key);
        clickSearch();
    }

    public String getSearchResult() {
        return driver.findElement(pageInner).getText();
    }
}

