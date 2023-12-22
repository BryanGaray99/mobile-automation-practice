package com.bgaray.Tests;

import com.bgaray.Menus.BottomMenu;
import com.bgaray.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bgaray.Screens.HomeScreen;

public class NavigationTest extends BaseTest {

    @BeforeMethod
    public void setupPreconditions() {
        BottomMenu bottomMenu = returBottomMenu();
        bottomMenu.navigateToHomeScreen();
    }
    @Test
    public void testNavigationOnBottomMenuBar() {
        HomeScreen homeScreen = returnHomeScreen();
        BottomMenu bottomMenu = returBottomMenu();

        Assert.assertEquals(homeScreen.getHomeScreenTitleText(), "WEBDRIVER", "Non expected title");
        Assert.assertEquals(homeScreen.getDescriptionText(), "Demo app for the appium-boilerplate",
                "Unexpected demo app description");
        Assert.assertEquals(homeScreen.getSupportText(), "Support", "Unexpected support text");

        bottomMenu.navigateToWebViewSection();

        bottomMenu.navigateToLoginSection();

        bottomMenu.navigateToFormsSection();

        bottomMenu.navigateToSwipeSection();

        bottomMenu.navigateToDragSection();
    }
}