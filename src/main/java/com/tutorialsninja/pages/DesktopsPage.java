package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DesktopsPage extends Utility {
    private static final Logger log = LogManager.getLogger(DesktopsPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Desktops']")
    WebElement desktopTitle;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProduct;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProductAfterFilter;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement productSorting;

    public String getDesktopPageTitle() {
        log.info("get desktop page title");
        return getTextFromElement(desktopTitle);
    }

    public List<WebElement> getListsOfProduct() {
        log.info("get get list od products : "+listOfProduct.toString());
        return listOfProduct ;
    }

    public List<WebElement> getListsOfProductAfterFilter() {
        log.info("get get list od products : "+listOfProductAfterFilter.toString());
        return listOfProductAfterFilter ;
    }

    public void selectSortByZToA(String option) {
        log.info(" product sorting by : "+option);
        selectByVisibleTextFromDropDown(productSorting, option);
    }

    public void clickOnYourSelectedProduct(String productName) {
        log.info("Click on : "+productName);
        clickOnElement(By.linkText(productName));
    }
}
