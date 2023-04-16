package pages;

import constants.locators.ZigzagAccountPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver driver;
    private By accountOpened = By.tagName("h1");
    private By accountFavourite = By.className(ZigzagAccountPageLocators.ACCOUNT_FAVOURITE_CLASSNAME);
    private By favouriteItem = By.cssSelector(ZigzagAccountPageLocators.FAVOURITE_ITEM_SELECTOR);
    private By privateAccount = By.className(ZigzagAccountPageLocators.PERSONAL_ACCOUNT_CLASSNAME);
    private By userFirstName = By.id(ZigzagAccountPageLocators.FIRSTNAME_ID);
    private By saveChanges = By.cssSelector(ZigzagAccountPageLocators.SAVE_CHANGED_BUTTON_SELECTOR);
    private By userName =  By.className(ZigzagAccountPageLocators.USER_NAME_CLASSNAME);

    public AccountPage(WebDriver driver) { this.driver = driver; }

    public String getLoggedInPage() {
        return driver.findElement(accountOpened).getText();
    }

    public void goToAccountFavourites() {
        driver.findElement(accountFavourite).click();
    }

    public String getFavouriteItem() {
        return driver.findElement(favouriteItem).getText();
    }

    public void goToAccountDetails() {
        driver.findElement(privateAccount).click();
    }

    public void changeUserFirstname(String firstname) {
        driver.findElement(userFirstName).sendKeys(firstname);
    }

    public void saveUserChanges() {
        driver.findElement(saveChanges).click();
    }

    public String getUserName() {
        return driver.findElement(userName).getText();
    }
}
