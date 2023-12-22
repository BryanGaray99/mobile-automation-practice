package com.bgaray.Screens;

import com.bgaray.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class SwipeScreen extends BaseScreen {
    private static final String SWIPE_TITLE = "new UiSelector().text(\"Swipe horizontal\")";
    private static final String SWIPE_DESCRIPTION = "new UiSelector().text(\"Or swipe vertical to find what I'm hiding.\")";
    private static final String SLIDE_TEXT_CONTAINER = "slideTextContainer";
    public static final String CAROUSEL_CONTAINER = "Carousel";
    private static final String TEXT_VIEW_CLASS = "android.widget.TextView";
    private static final String VIEW_GROUP_CLASS = "android.view.ViewGroup";


    @AndroidFindBy(uiAutomator = SWIPE_TITLE)
    private WebElement swipeTitle;
    @AndroidFindBy(uiAutomator = SWIPE_DESCRIPTION)
    private WebElement swipeDescription;
    @AndroidFindBy(accessibility = CAROUSEL_CONTAINER)
    private WebElement carouselContainer;
    @AndroidFindBy(accessibility = SLIDE_TEXT_CONTAINER)
    private List<WebElement> cards;

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }
    public void areSwipeElementsDisplayed() {
        waitForVisibilityOfElement(swipeTitle);
        waitForVisibilityOfElement(swipeDescription);
        isElementDisplayed(swipeTitle);
        isElementDisplayed(swipeDescription);
    }

    public void swipeRightAndVerifyCards() {
        swipe(getSwipeStartPosition(0.5, 0.65), getSwipeEndPosition(0.2, 0.65), Duration.ofMillis(1500));
        if (isOldCardPopulated()) {
            throw new AssertionError("The old card is not empty after swiping right");
        }

        if (isNewCardEmpty()) {
            throw new AssertionError("The new card is not populated after swiping right");
        }
    }
    public void swipeLeftAndVerifyCards() {
        swipe(getSwipeStartPosition(0.5, 0.65), getSwipeEndPosition(0.8, 0.65), Duration.ofMillis(1500));
        if (isOldCardPopulated()) {
            throw new AssertionError("The old card is not empty after swiping left");
        }

        if (isNewCardEmpty()) {
            throw new AssertionError("The new card is not populated after swiping left");
        }
    }

    public boolean isOldCardPopulated() {
        if (cards.size() == 2) {
            List<WebElement> children = cards.get(1).findElements(By.className(TEXT_VIEW_CLASS));
            return !children.isEmpty();
        } else {
            List<WebElement> children = cards.get(0).findElements(By.className(TEXT_VIEW_CLASS));
            return !children.isEmpty();
        }
    }

    public boolean isNewCardEmpty() {
        if (cards.size() == 2) {
            List<WebElement> children = cards.get(0).findElements(By.className(TEXT_VIEW_CLASS));
            return children.isEmpty();
        } else {
            List<WebElement> children = cards.get(1).findElements(By.className(TEXT_VIEW_CLASS));
            return children.isEmpty();
        }
    }

    private void assertDotPosition(int expectedIndex) {
        WebElement cardDotContainer = carouselContainer.findElement(By.className(VIEW_GROUP_CLASS));
        List<WebElement> dotContainers = cardDotContainer.findElements(By.className(VIEW_GROUP_CLASS));
    }

}
