package com.bgaray.Screens;

import com.bgaray.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SwipeScreen extends BaseScreen {
    private static final String SWIPE_TITLE = "new UiSelector().text(\"Swipe horizontal\")";
    private static final String SWIPE_DESCRIPTION = "new UiSelector().text(\"Or swipe vertical to find what I'm hiding.\")";
    private static final String SLIDE_TEXT_CONTAINER = "slideTextContainer";
    public static final String CAROUSEL_CONTAINER = "Carousel";
    private static final String TEXT_VIEW_CLASS = "android.widget.TextView";
    private static final String VIEW_GROUP_CLASS = "android.view.ViewGroup";
    public static final String CARD_DOT_1 = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9).childSelector(new UiSelector().index(0)).childSelector(new UiSelector().className(\"android.view.ViewGroup\")))";
    public static final String CARD_DOT_2 = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9).childSelector(new UiSelector().index(1)).childSelector(new UiSelector().className(\"android.view.ViewGroup\")))";
    public static final String CARD_DOT_3 = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9).childSelector(new UiSelector().index(2)).childSelector(new UiSelector().className(\"android.view.ViewGroup\")))";
    public static final String CARD_DOT_4 = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9).childSelector(new UiSelector().index(3)).childSelector(new UiSelector().className(\"android.view.ViewGroup\")))";
    public static final String CARD_DOT_5 = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9).childSelector(new UiSelector().index(4)).childSelector(new UiSelector().className(\"android.view.ViewGroup\")))";
    public static final String CARD_DOT_6 = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9).childSelector(new UiSelector().index(5)).childSelector(new UiSelector().className(\"android.view.ViewGroup\")))";

    @AndroidFindBy(uiAutomator = SWIPE_TITLE)
    private WebElement swipeTitle;
    @AndroidFindBy(uiAutomator = SWIPE_DESCRIPTION)
    private WebElement swipeDescription;
    @AndroidFindBy(accessibility = CAROUSEL_CONTAINER)
    private WebElement carouselContainer;
    @AndroidFindBy(accessibility = SLIDE_TEXT_CONTAINER)
    private List<WebElement> cards;
    @AndroidFindBy(uiAutomator = CARD_DOT_1)
    private WebElement cardDot1;
    @AndroidFindBy(uiAutomator = CARD_DOT_2)
    private WebElement cardDot2;
    @AndroidFindBy(uiAutomator = CARD_DOT_3)
    private WebElement cardDot3;
    @AndroidFindBy(uiAutomator = CARD_DOT_4)
    private WebElement cardDot4;
    @AndroidFindBy(uiAutomator = CARD_DOT_5)
    private WebElement cardDot5;
    @AndroidFindBy(uiAutomator = CARD_DOT_6)
    private WebElement cardDot6;

    private static final String[] CARD_TEXTS = {"FULLY OPEN SOURCE", "GREAT COMMUNITY", "JS.FOUNDATION", "SUPPORT VIDEOS", "EXTENDABLE", "COMPATIBLE"};

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

        assertDotAndCardIndex();
    }

    public void swipeLeftAndVerifyCards() {
        swipe(getSwipeStartPosition(0.5, 0.65), getSwipeEndPosition(0.8, 0.65), Duration.ofMillis(1500));
        if (isOldCardPopulated()) {
            throw new AssertionError("The old card is not empty after swiping left");
        }

        if (isNewCardEmpty()) {
            throw new AssertionError("The new card is not populated after swiping left");
        }
        assertDotAndCardIndex();
    }

    private boolean isOldCardPopulated() {
        List<WebElement> children = (cards.size() == 2)
                ? cards.get(1).findElements(By.className(TEXT_VIEW_CLASS))
                : cards.get(0).findElements(By.className(TEXT_VIEW_CLASS));
        return !children.isEmpty();
    }

    private boolean isNewCardEmpty() {
        List<WebElement> children = (cards.size() == 2)
                ? cards.get(0).findElements(By.className(TEXT_VIEW_CLASS))
                : cards.get(1).findElements(By.className(TEXT_VIEW_CLASS));
        return children.isEmpty();
    }

    private int getSelectedDotIndex() {
        int maxIndex = -1;
        int maxWidth = 0;

        List<WebElement> cardDots = Arrays.asList(cardDot1, cardDot2, cardDot3, cardDot4, cardDot5, cardDot6);

        for (int i = 0; i < cardDots.size(); i++) {
            WebElement cardDot = cardDots.get(i);
            String bounds = cardDot.getAttribute("bounds");
            String[] boundsParts = bounds.replaceAll("\\D+", ",").replaceFirst("^,", "").split(",");
            int width = Integer.parseInt(boundsParts[2]) - Integer.parseInt(boundsParts[0]);

            if (width > maxWidth && width < 60) {
                maxWidth = width;
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    private void assertDotAndCardIndex() {
        int selectedDotIndex = getSelectedDotIndex();
        String cardText = getTextFromVisibleCard();

        int cardIndex = -1;
        for (int i = 0; i < CARD_TEXTS.length; i++) {
            if (CARD_TEXTS[i].equals(cardText)) {
                cardIndex = i;
                break;
            }
        }

        if (selectedDotIndex != cardIndex) {
            throw new AssertionError("The dot index does not match the text index in the card");
        }
    }

    private String getTextFromVisibleCard() {
        WebElement visibleCard = (cards.size() == 2) ? cards.get(0) : cards.get(1);
        List<WebElement> textViews = visibleCard.findElements(By.className(TEXT_VIEW_CLASS));
        return textViews.get(0).getText();
    }
}