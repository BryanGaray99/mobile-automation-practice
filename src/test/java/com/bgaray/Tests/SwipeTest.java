package com.bgaray.Tests;

import com.bgaray.Menus.BottomMenu;
import com.bgaray.Screens.SwipeScreen;
import com.bgaray.utils.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwipeTest extends BaseTest {
    @BeforeMethod
    public void setupPreconditions() {
        BottomMenu bottomMenu = returBottomMenu();
        bottomMenu.navigateToSwipeSection();
    }

    @Test
    public void testSwipeCarousel() {
        SwipeScreen swipeScreen = returnSwipeScreen();
        swipeScreen.areSwipeElementsDisplayed();
        swipeScreen.swipeRightAndVerifyCards();
        swipeScreen.swipeLeftAndVerifyCards();
    }
}
