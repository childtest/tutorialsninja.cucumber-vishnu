package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement loginPageTile;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement btnLogin;

    public String getLoginPageTitle() {
        log.info("get login page title");
        return getTextFromElement(loginPageTile);
    }

    public void enterEmail(String mail) {
        log.info("Enter email : " + mail);
        sendTextToElement(email, mail);
    }

    public void enterPassword(String pass) {
        log.info("Enter password : " + pass);
        sendTextToElement(password, pass);
    }

    public void clickOnLogInButton() {
        log.info("Click on log in button");
        clickOnElement(btnLogin);
    }
}
