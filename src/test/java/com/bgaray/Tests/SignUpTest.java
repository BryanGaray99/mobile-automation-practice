package com.bgaray.Tests;

import com.bgaray.utils.DataProvider.DataProvider;
import com.bgaray.utils.screens.BottomMenu;
import com.bgaray.Screens.SignUpScreen;
import com.bgaray.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    private final String randomEmail = DataProvider.generateRandomEmail();
    private final String randomPassword = DataProvider.generateRandomPassword();
    @BeforeMethod
    public void setupPreconditions() {
        BottomMenu bottomMenu = returBottomMenu();
        bottomMenu.navigateToLoginSection();
    }

    @Test
    public void testSignUp() {
        SignUpScreen signUpScreen = returnSignUpScreen();
        signUpScreen.openSignUpForm();
        signUpScreen.fillSignUpForm(randomEmail, randomPassword);
        Assert.assertTrue(signUpScreen.isSignUpSuccessful(), "SignUp was not successful");
        signUpScreen.clickOkButton();
        signUpScreen.clearSignUpFormFields();
    }
}
