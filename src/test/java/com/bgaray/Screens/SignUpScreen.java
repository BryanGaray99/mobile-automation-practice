package com.bgaray.Screens;

import com.bgaray.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SignUpScreen extends BaseScreen {
    private static final String SIGN_UP_FORM = "new UiSelector().text(\"Sign up\")";
    private static final String EMAIL_INPUT_ID = "input-email";
    private static final String PASSWORD_INPUT_ID = "input-password";
    private static final String CONFIRM_PASSWORD_INPUT_ID = "input-repeat-password";
    private static final String SIGN_UP_BUTTON_ID = "button-SIGN UP";
    private static final String SIGN_UP_SUCCESS_MESSAGE = "new UiSelector().text(\"You successfully signed up!\")";
    private static final String SIGN_UP_OK_BUTTON = "new UiSelector().text(\"OK\")";

    @AndroidFindBy(uiAutomator = SIGN_UP_FORM)
    private WebElement signUpForm;
    @AndroidFindBy(accessibility = EMAIL_INPUT_ID)
    private WebElement emailInput;
    @AndroidFindBy(accessibility = PASSWORD_INPUT_ID)
    private WebElement passwordInput;
    @AndroidFindBy(accessibility = CONFIRM_PASSWORD_INPUT_ID)
    private WebElement confirmPasswordInput;
    @AndroidFindBy(accessibility = SIGN_UP_BUTTON_ID)
    private WebElement signUpButton;
    @AndroidFindBy(uiAutomator = SIGN_UP_SUCCESS_MESSAGE)
    private WebElement signUpSuccessMessage;
    @AndroidFindBy(uiAutomator = SIGN_UP_OK_BUTTON)
    private WebElement signUpOkButton;

    public SignUpScreen(AndroidDriver driver) {
        super(driver);
    }

    public void openSignUpForm() {
        clickOnElement(signUpForm);
    }

    public void fillSignUpForm(String email, String password) {
        setText(emailInput, email);
        setText(passwordInput, password);
        setText(confirmPasswordInput, password);
        clickOnElement(signUpButton);
    }

    public boolean isSignUpSuccessful() {
        waitForVisibilityOfElement(signUpSuccessMessage);
        return isElementDisplayed(signUpSuccessMessage);
    }

    public void clickOkButton() {
        clickOnElement(signUpOkButton);
    }

    public void clearSignUpFormFields() {
        clearTextField(emailInput);
        clearTextField(passwordInput);
        clearTextField(confirmPasswordInput);
    }
}