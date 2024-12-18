package com.tutorialsninja.steps;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.pages.RegisterAccountPage;
import com.tutorialsninja.utility.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class MyAccountTestSteps extends Utility {

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = new HomePage().getListOfMyAccountOption();
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = new HomePage().getListOfMyAccountOption();
        }
    }

    @When("I click on my account link")
    public void iClickOnMyAccountLink() {
        new HomePage().clickOnMyAccount();
    }

    @And("I call the method selectMyAccountOptions method and pass the parameter {string}")
    public void iCallTheMethodSelectMyAccountOptionsMethodAndPassTheParameter(String option) {
        selectMyAccountOptions(option);
    }

    @Then("I should see text register account")
    public void iShouldSeeTextRegisterAccount() {
        Assert.assertEquals(new RegisterAccountPage().getRegisterAccountTitle(), "Register Account",
                "Register page not displayed");
    }

    @Then("I should see text returning customer")
    public void iShouldSeeTextReturningCustomer() {
        Assert.assertEquals(new LoginPage().getLoginPageTitle(), "Returning Customer",
                "Login page not displayed");
    }

    @And("I enter First Name {string}")
    public void iEnterFirstName(String fName) {
        new RegisterAccountPage().enterFirstName(fName + generateRandomNumber());
    }

    @And("I enter Last Name {string}")
    public void iEnterLastName(String lName) {
        new RegisterAccountPage().enterLastName(lName + generateRandomNumber());
    }

    @And("I enter Email {string}")
    public void iEnterEmail(String email) {
        new RegisterAccountPage().enterEmail(email + generateRandomNumber() + "@gmail.com");
    }

    @And("I enter Telephone {string}")
    public void iEnterTelephone(String phone) {
        new RegisterAccountPage().enterPhoneNumber(phone);
    }

    @And("I enter Password {string}")
    public void iEnterPassword(String pass) {
        new RegisterAccountPage().enterPassword(pass);
    }

    @And("I enter Confirm Password {string}")
    public void iEnterConfirmPassword(String cPass) {
        new RegisterAccountPage().enterConfirmPassword(cPass);
    }

    @And("I select Subscribe {string} radio button")
    public void iSelectSubscribeRadioButton(String option) {
        new RegisterAccountPage().selectSubscribe(option);
    }

    @And("I click on Privacy Policy check box")
    public void iClickOnPrivacyPolicyCheckBox() {
        new RegisterAccountPage().clickOnPrivacyPolicyCheckBox();
    }

    @And("I click on Continue button for registration")
    public void iClickOnContinueButtonForRegistration() {
        new RegisterAccountPage().clickOnContinueButton();
    }

    @And("I should see the message Your Account Has Been Created!")
    public void iShouldSeeTheMessageYourAccountHasBeenCreated() {
        Assert.assertEquals(new RegisterAccountPage().getAccountRegistrationConformationMessage(),
                "Your Account Has Been Created!", "Your Account Not Created!");
    }

    @And("I click on Continue button")
    public void iClickOnContinueButton() {
        new RegisterAccountPage().clickOnContinueWithConfirmation();
    }

    @And("I should see the text Account Logout")
    public void iShouldSeeTheTextAccountLogout() {
        Assert.assertEquals(new HomePage().getConfirmationMessageOfLogout(),
                "Account Logout", "Not logged out");
    }

    @Then("I click on Continue button after logout")
    public void iClickOnContinueButtonAfterLogout() {
        new HomePage().clickOnContinueButton();
    }

    @And("I enter Email {string} on login page")
    public void iEnterEmailOnLoginPage(String email) {
        new LoginPage().enterEmail(email);
    }

    @And("I enter password {string} on login page")
    public void iEnterPasswordOnLoginPage(String pass) {
        new LoginPage().enterPassword(pass);
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        new LoginPage().clickOnLogInButton();
    }

    @And("I should see My Account text")
    public void iShouldSeeMyAccountText() {
        Assert.assertEquals(new MyAccountPage().getMyAccountPageTitle(), "My Account",
                "My Account Is not Matched!");
    }
}
