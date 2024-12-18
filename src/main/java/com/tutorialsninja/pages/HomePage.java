package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(xpath = "//nav[@id='menu']//li//a")
    List<WebElement> topMenuList;

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktop;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopAndNotBook;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement components;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currency;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='£Pound Sterling']")
    WebElement btnPound;

    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li")
    WebElement selectPound;

    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    List<WebElement> listOfAccountOption;


    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccount;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccountForLogOut;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement confirmationMsgOfLogOut;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement btnContinue;


    public List<WebElement> getTopMenuList() {
        log.info("get top menu list : " + topMenuList.toString());
        
        return topMenuList;
    }

    public void clickOnMenuOption(String name) {
        log.info("click on : " + name);
        clickOnElement(By.linkText(name));
    }

    public void mouseHoverOnDesktop() {
       log.info("mouse hover on desktop");
        mouseHoverToElement(desktop);
    }

    public void mouseHoverOnLaptopAndNotBook() {
       log.info("mouse hover on laptop and not book");
        mouseHoverToElement(laptopAndNotBook);
    }

    public void mouseHoverOnComponents() {
       log.info("mouse hover on components");
        mouseHoverToElement(components);
    }

    public void mouseHoverOnCurrencyAndClickOn() {
       log.info("Mouse Hover On Currency And Click On that");
        mouseHoverToElementAndClick(currency);
    }

    public void selectCurrencyAsAPound(String option) {
       log.info("Select Currency As APound");
        // selectByContainsTextFromDropDown(selectPound, option);
        clickOnElement(btnPound);
    }

    public List<WebElement> getListOfMyAccountOption() {
       log.info("get list of my account option : " + listOfAccountOption);
        return listOfAccountOption;
    }

    public void clickOnMyAccount() {
       log.info("Click on may account");
        clickOnElement(myAccount);
    }

    public void clickOnMyAccountForLogOut() {
       log.info("Click on may account");
        clickOnElement(myAccountForLogOut);
    }

    public void clickOnLogOut(String txt) {
       log.info("Click on log out");
        driver.findElement(By.linkText(txt)).click();
    }

    public String getConfirmationMessageOfLogout() {
       log.info("get log out confirmation message");
        return getTextFromElement(confirmationMsgOfLogOut);
    }

    public void clickOnContinueButton() {
       log.info("Click on continue button");
        clickOnElement(btnContinue);
    }

}
