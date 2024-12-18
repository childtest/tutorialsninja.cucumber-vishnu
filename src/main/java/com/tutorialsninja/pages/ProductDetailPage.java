package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductDetailPage extends Utility {
    private static final Logger log = LogManager.getLogger(ProductDetailPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "(//h1)[2]")
    WebElement pageTitle;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement dateButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthAndYear;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement nextButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
    List<WebElement> allDates;

    @CacheLookup
    @FindBy(name = "quantity")
    WebElement quantity;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement btnAddCart;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement productAddMsg;

    @CacheLookup
    @FindBy(linkText = "shopping cart")
    WebElement shoppingCart;


    public String getPageTitle() {
        log.info("get shopping cart page title");
        return getTextFromElement(pageTitle);
    }

    public void selectDeliveryDate(String year, String month, String date) {
        selectDateFromDatePicker(year, month, date, dateButton, monthAndYear, nextButton, allDates);
    }

    public void enterQuantity(String qty) {
        log.info("get enter quantity : "+qty);
        sendTextToElementWithClearText(quantity, qty);
    }

    public void clickOnAddToCartButton() {
        log.info("Click On Add To Cart Button");
       // clickOnElement(btnAddCart);
        mouseHoverToElementAndClick(btnAddCart);
    }

    public String getProductAddToCartSuccessMessage() {
        log.info("Get Product Add To Cart Success Message");
        // return waitUntilVisibilityOfElementLocated(productAddMsg, 5).getText();
        return getTextFromElement(productAddMsg);
    }

    public void clickOnShoppingCartLink() {
        log.info("Click on shopping cart");
        // clickOnElement(waitUntilVisibilityOfElementLocated(shoppingCart ,2));
        //clickOnElement(shoppingCart);
        mouseHoverToElementAndClick(shoppingCart);
    }

}
