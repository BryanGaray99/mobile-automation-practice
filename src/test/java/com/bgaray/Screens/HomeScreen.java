package com.bgaray.Screens;

import com.bgaray.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

    private static final String HOME_TITLE_SELECTOR = "new UiSelector().text(\"WEBDRIVER\")";
    private static final String HOME_DESCRIPTION_SELECTOR = "new UiSelector().text(\"Demo app for the appium-boilerplate\")";
    private static final String HOME_SUPPORT_SELECTOR = "new UiSelector().text(\"Support\")";

    //TODO: Images
    public static final String HOME_IMAGE_ROBOT = "";
    private static final String HOME_ICON_IO = "";
    private static final String HOME_ICON_APPLE = "";
    private static final String HOME_ICON_ANDROID = "";

    @AndroidFindBy(uiAutomator = HOME_TITLE_SELECTOR)
    private WebElement homeScreenTitle;

    @AndroidFindBy(uiAutomator = HOME_DESCRIPTION_SELECTOR)
    private WebElement demoAppDescription;

    @AndroidFindBy(uiAutomator = HOME_SUPPORT_SELECTOR)
    private WebElement supportTextView;


    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    public String getHomeScreenTitleText() {
        waitForVisibilityOfElement(homeScreenTitle);
        return homeScreenTitle.getText();
    }

    public String getDescriptionText() {
        waitForVisibilityOfElement(demoAppDescription);
        return demoAppDescription.getText();
    }

    public String getSupportText() {
        waitForVisibilityOfElement(supportTextView);
        return supportTextView.getText();
    }
}
