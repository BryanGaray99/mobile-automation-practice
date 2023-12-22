package com.bgaray.utils.screens;

import com.bgaray.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class BottomMenu extends BaseScreen {
    private static final String ACCESSIBILITY_HOME = "Home";
    private static final String ACCESSIBILITY_WEBVIEW = "Webview";
    private static final String ACCESSIBILITY_LOGIN = "Login";
    private static final String ACCESSIBILITY_FORMS = "Forms";
    private static final String ACCESSIBILITY_SWIPE = "Swipe";
    private static final String ACCESSIBILITY_DRAG = "Drag";

    @AndroidFindBy(accessibility = ACCESSIBILITY_HOME)
    private WebElement homeButton;

    @AndroidFindBy(accessibility = ACCESSIBILITY_WEBVIEW)
    private WebElement webViewButton;

    @AndroidFindBy(accessibility = ACCESSIBILITY_LOGIN)
    private WebElement loginButton;

    @AndroidFindBy(accessibility = ACCESSIBILITY_FORMS)
    private WebElement formsButton;

    @AndroidFindBy(accessibility = ACCESSIBILITY_SWIPE)
    private WebElement swipeButton;

    @AndroidFindBy(accessibility = ACCESSIBILITY_DRAG)
    private WebElement dragButton;

    public BottomMenu(AndroidDriver driver) {
        super(driver);
    }

    public void navigateToHomeScreen() {
        clickOnElement(homeButton);
    }

    public void navigateToWebViewSection() {
        clickOnElement(webViewButton);
    }

    public void navigateToLoginSection() {
        clickOnElement(loginButton);
    }

    public void navigateToFormsSection() {
        clickOnElement(formsButton);
    }

    public void navigateToSwipeSection() {
        clickOnElement(swipeButton);
    }

    public void navigateToDragSection() {
        clickOnElement(dragButton);
    }
}
