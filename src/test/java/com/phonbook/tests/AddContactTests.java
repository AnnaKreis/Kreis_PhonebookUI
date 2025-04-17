package com.phonbook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {
    //login
    @BeforeMethod
    public void preconditions() {
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("mekili4034@dpcos.com").setPassword("Aa!12345"));
        clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        //click on Add link
        clickOnAddLink();
        fillContactForm(new Contact()
                .setName("Alla")
                .setLastName("Straus")
                .setPhone("01773458804")
                .setEmail("qa55@gmail.com")
                .setAddress("Berlin")
                .setDescription("QA"));
        //click save button
        clickOnSaveButton();
        //verify contact is added
        Assert.assertTrue(isContactAdded("Alla"));
    }

    @AfterMethod
    public void postCondition() {
        deleteContact();

    }

}
