package com.bgaray.Screens;

import com.bgaray.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SignUpScreen extends BaseScreen {
    public static final String SIGNUP_TITLE = "new UiSelector().description(\"button-login-container\")";
    private static final String SIGN_UP_FORM = "new UiSelector().text(\"Sign up\")";
    private static final String EMAIL_INPUT_ID = "input-email";
    private static final String PASSWORD_INPUT_ID = "input-password";
    private static final String CONFIRM_PASSWORD_INPUT_ID = "input-repeat-password";
    private static final String SIGN_UP_BUTTON_ID = "button-SIGN UP";
    private static final String SIGN_UP_SUCCESS_MESSAGE = "new UiSelector().text(\"You successfully signed up!\")";
    private static final String SIGN_UP_OK_BUTTON = "new UiSelector().text(\"OK\")";

    @AndroidFindBy(uiAutomator = SIGNUP_TITLE)
    private WebElement signupTitle;
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

    public void signUp(String email, String password) {
        openSignUpForm();
        fillSignUpForm(email, password);
        Assert.assertTrue(isSignUpSuccessful(), "SignUp was not successful");
        clickOkButton();
        clearSignUpFormFields();
    }

    public void signupScreenElementsAssertion() {
        openSignUpForm();
        assertElementVisibility(signupTitle, "Signup Title");
        assertElementVisibility(signUpForm, "Signup Form");
        assertElementVisibility(emailInput, "Email Input");
        assertElementVisibility(passwordInput, "Password Input");
        assertElementVisibility(confirmPasswordInput, "Confirm Password Input");
        assertElementVisibility(signUpButton, "Signup Button");
    }

    private void assertElementVisibility(WebElement element, String elementName) {
        waitForVisibilityOfElement(element);
        Assert.assertTrue(isElementDisplayed(element), elementName + " is not visible.");
    }
}