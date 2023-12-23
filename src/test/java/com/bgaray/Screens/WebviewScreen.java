package com.bgaray.Screens;

import com.bgaray.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebviewScreen extends BaseScreen {
    private static final String WEBVIEW_SELECTOR = "new UiSelector().resourceId(\"__docusaurus\")";
    private static final String SUPPORT_MESSAGE_SELECTOR = "new UiSelector().resourceId(\"__docusaurus\").childSelector(new UiSelector().className(\"android.view.View\"))";
    private static final String BAR_MENU_SELECTOR = "new UiSelector().resourceId(\"__docusaurus\").childSelector(new UiSelector().text(\"Main\"))";
    private static final String MAIN_CONTENT_WEBVIEW_SELECTOR = "new UiSelector().resourceId(\"__docusaurus_skipToContent_fallback\").childSelector(new UiSelector().className(\"android.view.View\"))";
    private static final String ROBOT_IMAGE_SELECTOR = "new UiSelector().resourceId(\"__docusaurus_skipToContent_fallback\").childSelector(new UiSelector().className(\"android.view.View\")).childSelector(new UiSelector().index(0))";
    private static final String TEXT_WEBVIEW_SELECTOR = "new UiSelector().resourceId(\"__docusaurus_skipToContent_fallback\").childSelector(new UiSelector().className(\"android.view.View\")).childSelector(new UiSelector().text(\"Next-gen browser and mobile automation test framework for Node.js\"))";
    private static final String FLOATING_ACTION_BUTTON_SELECTOR = "new UiSelector().resourceId(\"__docusaurus\").childSelector(new UiSelector().resourceId(\"ms-floating-button\"))";

    @AndroidFindBy(uiAutomator = WEBVIEW_SELECTOR)
    private WebElement webViewElement;

    @AndroidFindBy(uiAutomator = SUPPORT_MESSAGE_SELECTOR)
    private WebElement supportMessageElement;

    @AndroidFindBy(uiAutomator = BAR_MENU_SELECTOR)
    private WebElement barMenuElement;

    @AndroidFindBy(uiAutomator = MAIN_CONTENT_WEBVIEW_SELECTOR)
    private WebElement mainContentWebviewElement;

    @AndroidFindBy(uiAutomator = ROBOT_IMAGE_SELECTOR)
    private WebElement robotImageElement;

    @AndroidFindBy(uiAutomator = TEXT_WEBVIEW_SELECTOR)
    private WebElement textWebviewElement;

    @AndroidFindBy(uiAutomator = FLOATING_ACTION_BUTTON_SELECTOR)
    private WebElement floatingActionButtonElement;

    public WebviewScreen(AndroidDriver driver) {
        super(driver);
    }

    public void webviewScreenElementsAssertion() {
        assertElementVisibility(webViewElement, "Webview Element");
        assertElementVisibility(supportMessageElement, "Support Message Element");
        assertElementVisibility(barMenuElement, "Bar Menu Element");
        assertElementVisibility(mainContentWebviewElement, "Main Content Webview Element");
        assertElementVisibility(robotImageElement, "Robot Image Element");
        assertElementVisibility(textWebviewElement, "Text Webview Element");
        assertElementVisibility(floatingActionButtonElement, "Floating Action Button Element");
    }

    private void assertElementVisibility(WebElement element, String elementName) {
        waitForVisibilityOfElement(element);
        Assert.assertTrue(isElementDisplayed(element), elementName + " is not visible.");
    }
}
