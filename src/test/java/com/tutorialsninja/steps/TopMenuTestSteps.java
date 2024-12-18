package com.tutorialsninja.steps;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TopMenuTestSteps {

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = new HomePage().getTopMenuList();
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = new HomePage().getTopMenuList();
        }

        //  homePage.clickOnMenuOption(menu);

    }

    @When("I mouse hover and click on desktop tab")
    public void iMouseHoverAndClickOnDesktopTab() {
        new HomePage().mouseHoverOnDesktop();

    }

    @And("I select menu {string}")
    public void iSelectMenu(String menuName) {
        selectMenu(menuName);
    }

    @Then("I should navigate to desktop page successfully")
    public void iShouldNavigateToDesktopPageSuccessfully() {
        Assert.assertEquals(new DesktopsPage().getDesktopPageTitle(), "Desktops",
                "Not navigate to Desktop page");
    }

    @When("I mouse hover and click on laptop and notebook tab")
    public void iMouseHoverAndClickOnLaptopAndNotebookTab() {
        new HomePage().mouseHoverOnLaptopAndNotBook();
    }

    @Then("I should navigate to laptop and notebook page successfully")
    public void iShouldNavigateToLaptopAndNotebookPageSuccessfully() {
        Assert.assertEquals(new LaptopsAndNotebooksPage().getTitleOfLaptopAndNotBookPage(),
                "Laptops & Notebooks", "Not navigate to Laptops and Notebooks page");
    }

    @When("I mouse hover and click on component tab")
    public void iMouseHoverAndClickOnComponentTab() {
        new HomePage().mouseHoverOnComponents();
    }

    @Then("I should navigate to component page successfully")
    public void iShouldNavigateToComponentPageSuccessfully() {
        Assert.assertEquals(new ComponentsPage().getPageTitleOfComponents(), "Components",
                "Not navigate to Components page");
    }
}
