package com.phonbook.tests;

import com.phonbook.models.Contact;
import com.phonbook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {
    //preconditions
    @BeforeMethod
    public void preconditions() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail("mekili4034@dpcos.com").setPassword("Aa!12345"));
        app.getUser().clickOnLoginButton();
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("Alla")
                .setLastName("Straus")
                .setPhone("01773458804")
                .setEmail("qa55@gmail.com")
                .setAddress("Berlin")
                .setDescription("QA"));
        app.getContact().clickOnSaveButton();
    }

    @Test
    public void deleteContactTest() {
        int sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().deleteContact();
        app.getContact().pause(1000 );
        int sizeAfter = app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }


}
