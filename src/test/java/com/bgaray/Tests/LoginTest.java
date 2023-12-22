package com.bgaray.Tests;

import com.bgaray.utils.DataProvider.DataProvider;
import com.bgaray.utils.screens.BottomMenu;
import com.bgaray.Screens.LogInScreen;
import com.bgaray.Screens.SignUpScreen;
import com.bgaray.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private final String randomEmail = DataProvider.generateRandomEmail();
    private final String randomPassword = DataProvider.generateRandomPassword();
    @BeforeMethod
    public void setupPreconditions() {
        BottomMenu bottomMenu = returBottomMenu();
        bottomMenu.navigateToLoginSection();

        SignUpScreen signUpScreen = returnSignUpScreen();
        signUpScreen.openSignUpForm();
        signUpScreen.fillSignUpForm(randomEmail, randomPassword);
        Assert.assertTrue(signUpScreen.isSignUpSuccessful(), "SignUp was not successful");
        signUpScreen.clickOkButton();
        signUpScreen.clearSignUpFormFields();
    }

    @Test
    public void testSignUp() {
        LogInScreen logInScreen = returnLogInScreen();
        logInScreen.openLoginForm();
        logInScreen.fillSignUpForm(randomEmail, randomPassword);
        Assert.assertTrue(logInScreen.isLoginSuccessful(), "Login was not successful");
        logInScreen.clickOkButton();
        logInScreen.clearSignUpFormFields();
    }
}
