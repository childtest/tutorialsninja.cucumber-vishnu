package com.tutorialsninja.steps;

import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ProductDetailPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;

public class DesktopTestStesps {

    ArrayList<String> originalProductsName = new ArrayList<>();

    @And("I select product sort by {string}")
    public void iSelectProductSortBy(String shortingOption) {

        DesktopsPage desktopsPage = new DesktopsPage();
        for (WebElement e : desktopsPage.getListsOfProduct()) {
            originalProductsName.add(e.getText());
        }
        Collections.reverse(originalProductsName);
        new DesktopsPage().selectSortByZToA(shortingOption);
    }

    @Then("I should see product arrange in alphabetical order successfully")
    public void iShouldSeeProductArrangeInAlphabeticalOrderSuccessfully() {
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        DesktopsPage desktopsPage = new DesktopsPage();
        for (WebElement e : desktopsPage.getListsOfProductAfterFilter()) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);

        Assert.assertEquals(afterSortByZToAProductsName, originalProductsName,
                "Product not sorted");
    }

    @When("I mouse hover and click on currency dropdown")
    public void iMouseHoverAndClickOnCurrencyDropdown() {
        new HomePage().mouseHoverOnCurrencyAndClickOn();
    }

    @And("I mouse hover and click on  {string}")
    public void iMouseHoverAndClickOn(String currencyOption) {
        new HomePage().selectCurrencyAsAPound(currencyOption);
    }

    @And("I select product {string}")
    public void iSelectProduct(String productName) {
        new DesktopsPage().clickOnYourSelectedProduct(productName);
    }

    @And("I should view product text {string}")
    public void iShouldViewProductText(String productName) {
        Assert.assertTrue(new ProductDetailPage().getPageTitle()
                .contains(productName));
    }

    @And("I enter qty {int}")
    public void iEnterQty(int qty) {
        new ProductDetailPage().enterQuantity(String.valueOf(qty));
    }

    @And("I click on add to cart button")
    public void iClickOnAddToCartButton() throws InterruptedException {
        new ProductDetailPage().clickOnAddToCartButton();
        Thread.sleep(2000);
    }

    @And("I should view the message Success: You have added {string} to your shopping cart!")
    public void iShouldViewTheMessageSuccessYouHaveAddedToYourShoppingCart(String productName) throws InterruptedException {
        Assert.assertTrue(new ProductDetailPage().getProductAddToCartSuccessMessage()
                        .contains("Success: You have added " + productName + " to your shopping cart!"),
                "Product not added to cart");
        Thread.sleep(2000);
    }

    @And("I click on shopping cart link into success message")
    public void iClickOnShoppingCartLinkIntoSuccessMessage() {
        new ProductDetailPage().clickOnShoppingCartLink();
    }

    @And("I should view the shopping cart title")
    public void iShouldViewTheShoppingCartTitle() {
        Assert.assertTrue(new ShoppingCartPage().getShoppingCartPageTitle().contains("Shopping Cart"));
    }

    @And("I should view the product name {string}")
    public void iShouldViewTheProductName(String productName) {
        Assert.assertTrue(new ShoppingCartPage().getProductName().equalsIgnoreCase(productName),
                "Product name not matched");
    }

    @And("I should view the model {string}")
    public void iShouldViewTheModel(String pModel) {
        Assert.assertTrue(new ShoppingCartPage().getProductModel().equalsIgnoreCase(pModel),
                "Model not matched");
    }

    @Then("I should view the total {string}")
    public void iShouldViewTheTotal(String total) {
        Assert.assertEquals(new ShoppingCartPage().getProductTotalPrise(), total,
                "Total not matched");
    }


}
