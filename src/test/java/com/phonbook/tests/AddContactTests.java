package com.phonbook.tests;

import com.phonbook.models.Contact;
import com.phonbook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {
    //login
    @BeforeMethod
    public void preconditions() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail("mekili4034@dpcos.com").setPassword("Aa!12345"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("Alla")
                .setLastName("Straus")
                .setPhone("01773458804")
                .setEmail("qa55@gmail.com")
                .setAddress("Berlin")
                .setDescription("QA"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded("Alla"));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().deleteContact();

    }

}
