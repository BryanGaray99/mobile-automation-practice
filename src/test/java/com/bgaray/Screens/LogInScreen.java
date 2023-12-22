package com.bgaray.Screens;

import com.bgaray.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LogInScreen extends BaseScreen {
    private static final String LOGIN_FORM = "new UiSelector().text(\"Login\")";
    private static final String EMAIL_INPUT_ID = "input-email";
    private static final String PASSWORD_INPUT_ID = "input-password";
    private static final String LOGIN_BUTTON_ID = "button-LOGIN";
    private static final String LOGIN_SUCCESS_MESSAGE = "new UiSelector().text(\"You are logged in!\")";
    private static final String LOGIN_OK_BUTTON = "new UiSelector().text(\"OK\")";

    @AndroidFindBy(uiAutomator = LOGIN_FORM)
    private WebElement loginForm;
    @AndroidFindBy(accessibility = EMAIL_INPUT_ID)
    private WebElement emailInput;
    @AndroidFindBy(accessibility = PASSWORD_INPUT_ID)
    private WebElement passwordInput;
    @AndroidFindBy(accessibility = LOGIN_BUTTON_ID)
    private WebElement loginButton;
    @AndroidFindBy(uiAutomator = LOGIN_SUCCESS_MESSAGE)
    private WebElement loginSuccessMessage;
    @AndroidFindBy(uiAutomator = LOGIN_OK_BUTTON)
    private WebElement loginOkButton;

    public LogInScreen(AndroidDriver driver) {
        super(driver);
    }

    public void openLoginForm() {
        clickOnElement(loginForm);
    }

    public void fillSignUpForm(String email, String password) {
        setText(emailInput, email);
        setText(passwordInput, password);
        clickOnElement(loginButton);
    }

    public boolean isLoginSuccessful() {
        waitForVisibilityOfElement(loginSuccessMessage);
        return isElementDisplayed(loginSuccessMessage);
    }

    public void clickOkButton() {
        clickOnElement(loginOkButton);
    }

    public void clearSignUpFormFields() {
        clearTextField(emailInput);
        clearTextField(passwordInput);
    }

}