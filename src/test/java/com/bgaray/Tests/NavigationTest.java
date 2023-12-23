package com.bgaray.Tests;

import com.bgaray.Screens.*;
import com.bgaray.utils.screens.BottomMenu;
import com.bgaray.utils.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {
    @BeforeMethod
    public void setupPreconditions() {
        BottomMenu bottomMenu = returBottomMenu();
        bottomMenu.navigateToHomeScreen();
    }
    @Test
    public void navigationAndPresenceOfElements() {
        BottomMenu bottomMenu = returBottomMenu();
        HomeScreen homeScreen = returnHomeScreen();
        homeScreen.homeScreenElementsAssertion();

        bottomMenu.navigateToWebViewSection();
        WebviewScreen webviewScreen = returnWebviewScreen();
        webviewScreen.webviewScreenElementsAssertion();

        bottomMenu.navigateToLoginSection();
        LogInScreen logInScreen = returnLogInScreen();
        logInScreen.loginScreenElementsAssertion();

        SignUpScreen signUpScreen = returnSignUpScreen();
        signUpScreen.signupScreenElementsAssertion();

        bottomMenu.navigateToFormsSection();
        FormsScreen formsScreen = returnFormsScreen();
        formsScreen.formsScreenElementsAssertion();

        bottomMenu.navigateToSwipeSection();
        SwipeScreen swipeScreen = returnSwipeScreen();
        swipeScreen.swipeScreenElementsAssertion();

        bottomMenu.navigateToDragSection();
        DragScreen dragScreen = returnDragScreen();
        dragScreen.dragScreenElementsAssertion();
    }
}