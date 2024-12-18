package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {
    private static final Logger log = LogManager.getLogger(LaptopsAndNotebooksPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement LaptopAndNotBook;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> listOfProductPrice;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> listOfProductAfterFilter;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement productSorting;

    public String getTitleOfLaptopAndNotBookPage() {
        log.info("Get Title Of Laptop And NotBook Page");
        return getTextFromElement(LaptopAndNotBook);
    }

    public List<WebElement> getListsOfProductPrice() {
        log.info("get list of product price : "+listOfProductPrice.toString());
        return listOfProductPrice;
    }

    public List<WebElement> getListsOfProductPriceAfterFilter() {
        log.info("get list of product price after filter : "+listOfProductAfterFilter.toString());
        return listOfProductAfterFilter;
    }

    public void selectSortByZToA(String option) {
        log.info("Product sorting by Z to A");
        selectByVisibleTextFromDropDown(productSorting, option);
    }

    public void clickOnYourSelectedProduct(String productName) {
        log.info("Click on : "+productName);
        log.info("Click on : "+productName);
        clickOnElement(By.linkText(productName));
    }

}
