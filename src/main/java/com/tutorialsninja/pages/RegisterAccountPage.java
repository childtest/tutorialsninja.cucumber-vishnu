package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegisterAccountPage extends Utility {
    private static final Logger log = LogManager.getLogger(RegisterAccountPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement pageTitle;

    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement phoneNumber;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(xpath = "//fieldset[3]//input")
    List<WebElement> subScribe;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicy;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement btnContinue;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement confirmationMessage;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueConfirmation;


    public String getRegisterAccountTitle() {
        log.info("get register account page title");
        return getTextFromElement(pageTitle);
    }

    public void enterFirstName(String fName) {
        log.info("Enter first name : "+ fName);
        sendTextToElement(firstName, fName);
    }

    public void enterLastName(String lNmae) {
        log.info("Enter last name : "+ lNmae);
        sendTextToElement(lastName, lNmae);
    }

    public void enterEmail(String mail) {
        log.info("Enter email : "+ mail);
        sendTextToElement(email, mail);
    }

    public void enterPhoneNumber(String number) {
        log.info("Enter phone number : "+ number);
        sendTextToElement(phoneNumber, number);
    }

    public void enterPassword(String pass) {
        log.info("Enter password : "+ pass);
        sendTextToElement(password, pass);
    }

    public void enterConfirmPassword(String cPass) {
        log.info("Enter confirm password : "+ cPass);
        sendTextToElement(confirmPassword, cPass);
    }

    public void selectSubscribe(String option) {
        log.info("select Subscribe as : "+option);
        selectByContainsTextFromListOfElements(subScribe, option);
    }

    public void clickOnPrivacyPolicyCheckBox() {
        log.info("Click On Privacy Policy CheckBox");
        clickOnElement(privacyPolicy);
    }

    public void clickOnContinueButton() {
        log.info("Click On Continue Button");
        clickOnElement(btnContinue);
    }

    public String getAccountRegistrationConformationMessage() {
        log.info("Get Account Registration Conformation Message");
        return getTextFromElement(confirmationMessage);
    }

    public void clickOnContinueWithConfirmation() {
        log.info("Click On Continue button With Confirmation");
        clickOnElement(continueConfirmation);
    }

}
