package com.phonbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("mekili4034@dpcos.com").setPassword("Aa!12345"));
        clickOnLoginButton();
        //verify SingOut button is displayed
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setPassword("Aa!12345"));
        clickOnLoginButton();
        //verify SingOut button is displayed
        Assert.assertTrue(istAlertDisplayed());
    }
}
