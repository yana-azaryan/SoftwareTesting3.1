package pages;

import constants.locators.ZigzagLoginLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userNameFiled = By.id(ZigzagLoginLocators.EMAIL_ID);
    private By userPassFiled = By.id(ZigzagLoginLocators.PASSWORD_ID);
    private By sendButtonFiled = By.id(ZigzagLoginLocators.SEND_BUTTON_ID);
    private By emailError = By.id(ZigzagLoginLocators.EMAIL_ERROR_ID);
    private By passwordError = By.id(ZigzagLoginLocators.PASSWORD_ERROR_ID);
    private By authenticationPopup = By.id(ZigzagLoginLocators.AUTHENTICATION_POPUP_ID);

    public LoginPage(WebDriver driver) { this.driver = driver; }

    public void setUserNameFiled(String userName) {
        driver.findElement(userNameFiled).sendKeys(userName);
    }

    public void setUserPassFiledFiled(String password) {
        driver.findElement(userPassFiled).sendKeys(password);
    }

    public void clickSendButton() {
        driver.findElement(sendButtonFiled).click();
    }

    public void sendLoginData(String userName, String password) {
        setUserNameFiled(userName);
        setUserPassFiledFiled(password);
        clickSendButton();
    }

    public String getEmailError() {
        return driver.findElement(emailError).getText();
    }

    public String getPasswordError() {
        return driver.findElement(passwordError).getText();
    }

    public String getAuthenticationPopupText() {
        return driver.findElement(authenticationPopup).getText();
    }
}
