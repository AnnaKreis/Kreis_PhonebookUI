package com.phonbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        //click on Login Link
        clickOnLoginLink();
        //enter Email to mail field
        fillRegisterLoginForm("mekili4034@dpcos.com", "Aa!12345");
        //click on Login button
        clickOnLoginButton();
        //verify SingOut button is displayed
        Assert.assertTrue(isSignOutButtonPresent());
    }
}
