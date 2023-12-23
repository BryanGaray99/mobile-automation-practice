package com.bgaray.Screens;

import com.bgaray.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomeScreen extends BaseScreen {

    private static final String HOME_TITLE_SELECTOR = "new UiSelector().text(\"WEBDRIVER\")";
    private static final String HOME_DESCRIPTION_SELECTOR = "new UiSelector().text(\"Demo app for the appium-boilerplate\")";
    private static final String HOME_SUPPORT_SELECTOR = "new UiSelector().text(\"Support\")";
    private static final String ROBOT_IMG_SELECTOR = "new UiSelector().description(\"Home-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().index(0)))";
    private static final String WEBDRIVER_IMG_SELECTOR = "new UiSelector().description(\"Home-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().index(2)))";
    private static final String APPLE_LOGO_IMG_SELECTOR = "new UiSelector().description(\"Home-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().index(4)))";
    private static final String ANDROID_LOGO_IMG_SELECTOR = "new UiSelector().description(\"Home-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().index(5)))";

    @AndroidFindBy(uiAutomator = HOME_TITLE_SELECTOR)
    private WebElement homeScreenTitle;

    @AndroidFindBy(uiAutomator = HOME_DESCRIPTION_SELECTOR)
    private WebElement demoAppDescription;

    @AndroidFindBy(uiAutomator = HOME_SUPPORT_SELECTOR)
    private WebElement supportTextView;

    @AndroidFindBy(uiAutomator = ROBOT_IMG_SELECTOR)
    private WebElement robotImage;

    @AndroidFindBy(uiAutomator = WEBDRIVER_IMG_SELECTOR)
    private WebElement webDriverImage;

    @AndroidFindBy(uiAutomator = APPLE_LOGO_IMG_SELECTOR)
    private WebElement appleLogoImage;

    @AndroidFindBy(uiAutomator = ANDROID_LOGO_IMG_SELECTOR)
    private WebElement androidLogoImage;

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    public void homeScreenElementsAssertion() {
        assertElementVisibility(homeScreenTitle, "Home Screen Title");
        assertElementVisibility(demoAppDescription, "Demo App Description");
        assertElementVisibility(supportTextView, "Support Text View");
        assertElementVisibility(robotImage, "Robot Image");
        assertElementVisibility(webDriverImage, "WebDriver Image");
        assertElementVisibility(appleLogoImage, "Apple Logo Image");
        assertElementVisibility(androidLogoImage, "Android Logo Image");
    }

    private void assertElementVisibility(WebElement element, String elementName) {
        waitForVisibilityOfElement(element);
        Assert.assertTrue(isElementDisplayed(element), elementName + " is not visible.");
    }

}
