package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Utility {

    private static final Logger log = LogManager.getLogger(MyAccountPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement myAccountPageTile;

    public String getMyAccountPageTitle() {
        log.info("get my account page title ");
        return getTextFromElement(myAccountPageTile);
    }
}
