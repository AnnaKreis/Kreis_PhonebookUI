package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        if (!app.getHome().isHomeComponentPresent()) {
            app.getHome().clickOnHomeLink();
        }
    }

    @Test
    public void isHomeComponentPresentTests() {
//        driver.findElement(By.cssSelector("div:nth-child(2)>div>div>h1")); xpath -> //div[2]/div/div>h1
//        System.out.println("Home component " + isHomeComponentPresent());
        Assert.assertTrue(app.getHome().isHomeComponentPresent());
    }

}
