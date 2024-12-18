package com.tutorialsninja.steps;

import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopAndNoteBookTestSteps {
    List<Double> originalProductsPrice = new ArrayList<>();

    @And("I select Product shorting menu {string}")
    public void iSelectProductShortingMenu(String shortingOption) {

        LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        for (WebElement e : laptopsAndNotebooksPage.getListsOfProductPrice()) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "").replaceAll("$", "")));
        }
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);

        new LaptopsAndNotebooksPage().selectSortByZToA(shortingOption);
    }

    @Then("I should view product arrange in price high to low order successfully")
    public void iShouldViewProductArrangeInPriceHighToLowOrderSuccessfully() {

        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        for (WebElement e : laptopsAndNotebooksPage.getListsOfProductPriceAfterFilter()) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "").replaceAll("$", "")));
        }
        System.out.println(afterSortByPrice);

        Assert.assertEquals(afterSortByPrice, originalProductsPrice,
                "Product not sorted by price High to Low");
    }

    @And("I change quantity {string} for product")
    public void iChangeQuantityForProduct(String qty) {
        new ShoppingCartPage().changeQuantity(qty);
    }

    @And("I click on update quantity")
    public void iClickOnUpdateQuantity() {
        new ShoppingCartPage().clickOnUpdateButton();
    }

    @And("I should view cart modified message")
    public void iShouldViewCartModifiedMessage() {
        Assert.assertTrue(new ShoppingCartPage().getProductUpdateSuccessMessage().contains("Success: You have modified your shopping cart!"),
                "Cart not modified");
    }
}
