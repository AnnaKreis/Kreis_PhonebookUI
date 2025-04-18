package com.phonbook.tests;

import com.phonbook.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail("mekili4034@dpcos.com").setPassword("Aa!12345"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setPassword("Aa!12345"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().istAlertDisplayed());
    }
}
