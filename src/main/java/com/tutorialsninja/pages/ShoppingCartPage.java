package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {
    private static final Logger log = LogManager.getLogger(ShoppingCartPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "(//h1)[2]")
    WebElement pageTitle;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement productModel;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalPrice;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement changeQuantity;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement updateBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement messageOfProductUpdate;

    public String getShoppingCartPageTitle() {
        log.info("get shopping cart page title");
        return getTextFromElement(pageTitle);
    }

    public String getProductName() {
        log.info("Get Product Name : "+ productName);
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() {
        return getTextFromElement(deliveryDate);
    }

    public String getProductModel() {
        log.info("Get Product model : "+ productModel);
        return getTextFromElement(productModel);
    }

    public String getProductTotalPrise() {
        log.info("Get Product total price : "+ totalPrice);
        return getTextFromElement(totalPrice);
    }

    public void changeQuantity(String qty) {
        log.info("Change product quantity : " +qty);
        sendTextToElementWithClearText(changeQuantity, qty);
    }

    public void clickOnUpdateButton() {
        log.info("Click On Update Button");
        clickOnElement(updateBtn);
    }

    public String getProductUpdateSuccessMessage() {
        log.info("Get Product Update Success Message");
        return getTextFromElement(messageOfProductUpdate);
    }

}
