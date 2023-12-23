package com.bgaray.Screens;

import com.bgaray.utils.screens.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

public class DragScreen extends BaseScreen {
    public static final String DRAG_TITLE = "new UiSelector().text(\"Drag and Drop\")";
    private static final String DROP_SELECTOR = "new UiSelector().description(\"drop-";
    private static final String DRAG_SELECTOR = "new UiSelector().description(\"drag-";
    private static final String RENEW_BTN_SELECTOR = "new UiSelector().description(\"renew\")";
    private static final String RETRY_BTN_SELECTOR = "button-Retry";
    @AndroidFindBy(uiAutomator = DRAG_TITLE)
    private WebElement dragTitle;
    @AndroidFindBy(uiAutomator = DROP_SELECTOR + "l1\")")
    private WebElement drop1;
    @AndroidFindBy(uiAutomator = DROP_SELECTOR + "c1\")")
    private WebElement drop2;
    @AndroidFindBy(uiAutomator = DROP_SELECTOR + "r1\")")
    private WebElement drop3;
    @AndroidFindBy(uiAutomator = DROP_SELECTOR + "l2\")")
    private WebElement drop4;
    @AndroidFindBy(uiAutomator = DROP_SELECTOR + "c2\")")
    private WebElement drop5;
    @AndroidFindBy(uiAutomator = DROP_SELECTOR + "r2\")")
    private WebElement drop6;
    @AndroidFindBy(uiAutomator = DROP_SELECTOR + "l3\")")
    private WebElement drop7;
    @AndroidFindBy(uiAutomator = DROP_SELECTOR + "c3\")")
    private WebElement drop8;
    @AndroidFindBy(uiAutomator = DROP_SELECTOR + "r3\")")
    private WebElement drop9;
    @AndroidFindBy(uiAutomator = RENEW_BTN_SELECTOR)
    private WebElement renewBtn;
    @AndroidFindBy(uiAutomator = DRAG_SELECTOR + "l1\")")
    private WebElement drag1;
    @AndroidFindBy(uiAutomator = DRAG_SELECTOR + "r3\")")
    private WebElement drag2;
    @AndroidFindBy(uiAutomator = DRAG_SELECTOR + "r1\")")
    private WebElement drag3;
    @AndroidFindBy(uiAutomator = DRAG_SELECTOR + "c1\")")
    private WebElement drag4;
    @AndroidFindBy(uiAutomator = DRAG_SELECTOR + "c3\")")
    private WebElement drag5;
    @AndroidFindBy(uiAutomator = DRAG_SELECTOR + "r2\")")
    private WebElement drag6;
    @AndroidFindBy(uiAutomator = DRAG_SELECTOR + "c2\")")
    private WebElement drag7;
    @AndroidFindBy(uiAutomator = DRAG_SELECTOR + "l1\")")
    private WebElement drag8;
    @AndroidFindBy(uiAutomator = DRAG_SELECTOR + "l3\")")
    private WebElement drag9;
    @AndroidFindBy(accessibility = RETRY_BTN_SELECTOR)
    private WebElement retryButton;

    public DragScreen(AndroidDriver driver) {
        super(driver);
    }

    public void dragScreenElementsAssertion() {
        assertElementVisibility(dragTitle, "Drag Title");
        assertElementVisibility(drop1, "Drop 1");
        assertElementVisibility(drop2, "Drop 2");
        assertElementVisibility(drop3, "Drop 3");
        assertElementVisibility(drop4, "Drop 4");
        assertElementVisibility(drop5, "Drop 5");
        assertElementVisibility(drop6, "Drop 6");
        assertElementVisibility(drop7, "Drop 7");
        assertElementVisibility(drop8, "Drop 8");
        assertElementVisibility(drop9, "Drop 9");
        assertElementVisibility(renewBtn, "Renew Button");
        assertElementVisibility(drag1, "Drag 1");
        assertElementVisibility(drag2, "Drag 2");
        assertElementVisibility(drag3, "Drag 3");
        assertElementVisibility(drag4, "Drag 4");
        assertElementVisibility(drag5, "Drag 5");
        assertElementVisibility(drag6, "Drag 6");
        assertElementVisibility(drag7, "Drag 7");
        assertElementVisibility(drag8, "Drag 8");
        assertElementVisibility(drag9, "Drag 9");
        solvePuzzle();
        assertElementVisibility(retryButton, "Retry Button");
        clickOnElement(retryButton);
    }
    private void assertElementVisibility(WebElement element, String elementName) {
        waitForVisibilityOfElement(element);
        Assert.assertTrue(isElementDisplayed(element), elementName + " is not visible.");
    }

    public void solvePuzzle() {
        clickOnElement(renewBtn);
        dragAndDropByPercentage(0.17, 0.766, 0.289, 0.367, Duration.ofMillis(1000));
        dragAndDropByPercentage(0.345, 0.766, 0.713, 0.474, Duration.ofMillis(1000));
        dragAndDropByPercentage(0.503, 0.766, 0.694, 0.27   , Duration.ofMillis(1000));
        dragAndDropByPercentage(0.656, 0.766, 0.488, 0.261, Duration.ofMillis(1000));
        dragAndDropByPercentage(0.814, 0.766, 0.499, 0.467, Duration.ofMillis(1000));
        dragAndDropByPercentage(0.229, 0.85, 0.717, 0.368, Duration.ofMillis(1000));
        dragAndDropByPercentage(0.40, 0.85, 0.465, 0.367, Duration.ofMillis(1000));
        dragAndDropByPercentage(0.574, 0.85, 0.27, 0.268, Duration.ofMillis(1000));
        dragAndDropByPercentage(0.74, 0.85, 0.296, 0.469, Duration.ofMillis(1000));
    }
}
