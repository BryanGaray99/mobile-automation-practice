package com.bgaray.Screens;

import com.bgaray.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FormsScreen extends BaseScreen {

    private static final String FORMS_SCREEN_SELECTOR = "new UiSelector().description(\"Forms-screen\")";
    private static final String FORMS_MAIN_CONTENT_SELECTOR = "new UiSelector().description(\"Forms-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().className(\"android.view.ViewGroup\")))";
    private static final String FORM_INPUT_TEXT_LABEL_SELECTOR = "new UiSelector().text(\"Input field:\")";
    private static final String FORM_INPUT_TEXT_SELECTOR = "new UiSelector().description(\"text-input\")";
    private static final String FORM_TYPED_LABEL_SELECTOR = "new UiSelector().text(\"You have typed:\")";
    private static final String FORM_TEXT_RESULT_SELECTOR = "new UiSelector().description(\"input-text-result\")";
    private static final String FORM_SWITCH_LABEL_SELECTOR = "new UiSelector().text(\"Switch:\")";
    private static final String FORM_SWITCH_SELECTOR = "new UiSelector().description(\"switch\")";
    private static final String FORM_SWITCH_STATUS_SELECTOR = "new UiSelector().description(\"switch-text\")";
    private static final String FORM_DROPDOWN_LABEL_SELECTOR = "new UiSelector().text(\"Dropdown:\")";
    private static final String FORM_DROPDOWN_SELECTOR = "new UiSelector().description(\"Dropdown\")";
    private static final String FORM_DROPDOWN_IMG_SELECTOR = "new UiSelector().resourceId(\"icon_container\")";
    private static final String FORM_BUTTONS_LABEL_SELECTOR = "new UiSelector().text(\"Buttons\")";
    private static final String FORM_BUTTON_ACTIVE_SELECTOR = "new UiSelector().description(\"button-Active\")";
    private static final String FORM_BUTTON_INACTIVE_SELECTOR = "new UiSelector().description(\"button-Inactive\")";

    @AndroidFindBy(uiAutomator = FORMS_SCREEN_SELECTOR)
    private WebElement formsScreenElement;

    @AndroidFindBy(uiAutomator = FORMS_MAIN_CONTENT_SELECTOR)
    private WebElement formsMainContentElement;

    @AndroidFindBy(uiAutomator = FORM_INPUT_TEXT_LABEL_SELECTOR)
    private WebElement formInputTextLabelElement;

    @AndroidFindBy(uiAutomator = FORM_INPUT_TEXT_SELECTOR)
    private WebElement formInputTextElement;

    @AndroidFindBy(uiAutomator = FORM_TYPED_LABEL_SELECTOR)
    private WebElement formTypedLabelElement;

    @AndroidFindBy(uiAutomator = FORM_TEXT_RESULT_SELECTOR)
    private WebElement formTextResultElement;

    @AndroidFindBy(uiAutomator = FORM_SWITCH_LABEL_SELECTOR)
    private WebElement formSwitchLabelElement;

    @AndroidFindBy(uiAutomator = FORM_SWITCH_SELECTOR)
    private WebElement formSwitchElement;

    @AndroidFindBy(uiAutomator = FORM_SWITCH_STATUS_SELECTOR)
    private WebElement formSwitchStatusElement;

    @AndroidFindBy(uiAutomator = FORM_DROPDOWN_LABEL_SELECTOR)
    private WebElement formDropdownLabelElement;

    @AndroidFindBy(uiAutomator = FORM_DROPDOWN_SELECTOR)
    private WebElement formDropdownElement;

    @AndroidFindBy(uiAutomator = FORM_DROPDOWN_IMG_SELECTOR)
    private WebElement formDropdownImgElement;

    @AndroidFindBy(uiAutomator = FORM_BUTTONS_LABEL_SELECTOR)
    private WebElement formButtonsLabelElement;

    @AndroidFindBy(uiAutomator = FORM_BUTTON_ACTIVE_SELECTOR)
    private WebElement formButtonActiveElement;

    @AndroidFindBy(uiAutomator = FORM_BUTTON_INACTIVE_SELECTOR)
    private WebElement formButtonInactiveElement;

    public FormsScreen(AndroidDriver driver) {
        super(driver);
    }

    public void formsScreenElementsAssertion() {
        assertElementVisibility(formsScreenElement, "Forms Screen Element");
        assertElementVisibility(formsMainContentElement, "Forms Main Content Element");
        assertElementVisibility(formInputTextLabelElement, "Form Input Text Label Element");
        assertElementVisibility(formInputTextElement, "Form Input Text Element");
        assertElementVisibility(formTypedLabelElement, "Form Typed Label Element");
        assertElementVisibility(formTextResultElement, "Form Text Result Element");
        assertElementVisibility(formSwitchLabelElement, "Form Switch Label Element");
        assertElementVisibility(formSwitchElement, "Form Switch Element");
        assertElementVisibility(formSwitchStatusElement, "Form Switch Status Element");
        assertElementVisibility(formDropdownLabelElement, "Form Dropdown Label Element");
        assertElementVisibility(formDropdownElement, "Form Dropdown Element");
        assertElementVisibility(formDropdownImgElement, "Form Dropdown Img Element");
        assertElementVisibility(formButtonsLabelElement, "Form Buttons Label Element");
        assertElementVisibility(formButtonActiveElement, "Form Button Active Element");
        assertElementVisibility(formButtonInactiveElement, "Form Button Inactive Element");
    }

    private void assertElementVisibility(WebElement element, String elementName) {
        waitForVisibilityOfElement(element);
        Assert.assertTrue(isElementDisplayed(element), elementName + " is not visible.");
    }
}
