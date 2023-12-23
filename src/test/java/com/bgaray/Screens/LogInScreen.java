package com.bgaray.Screens;

import com.bgaray.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LogInScreen extends BaseScreen {
    public static final String LOGIN_TITLE = "new UiSelector().description(\"button-login-container\")";
    private static final String LOGIN_FORM = "new UiSelector().text(\"Login\")";
    private static final String EMAIL_INPUT_ID = "input-email";
    private static final String PASSWORD_INPUT_ID = "input-password";
    private static final String LOGIN_BUTTON_ID = "button-LOGIN";
    private static final String LOGIN_SUCCESS_MESSAGE = "new UiSelector().text(\"You are logged in!\")";
    private static final String LOGIN_OK_BUTTON = "new UiSelector().text(\"OK\")";

    @AndroidFindBy(uiAutomator = LOGIN_TITLE)
    private WebElement loginTitle;
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

    public void fillLoginForm(String email, String password) {
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

    public void clearLoginFormFields() {
        clearTextField(emailInput);
        clearTextField(passwordInput);
    }

    public void logIn(String email, String password) {
        openLoginForm();
        fillLoginForm(email, password);
        Assert.assertTrue(isLoginSuccessful(), "Login was not successful");
        clickOkButton();
        clearLoginFormFields();
    }

    public void loginScreenElementsAssertion() {
        openLoginForm();
        assertElementVisibility(loginTitle, "Login Title");
        assertElementVisibility(loginForm, "Login Form");
        assertElementVisibility(emailInput, "Email Input");
        assertElementVisibility(passwordInput, "Password Input");
        assertElementVisibility(loginButton, "Login Button");
    }

    private void assertElementVisibility(WebElement element, String elementName) {
        waitForVisibilityOfElement(element);
        Assert.assertTrue(isElementDisplayed(element), elementName + " is not visible.");
    }
}