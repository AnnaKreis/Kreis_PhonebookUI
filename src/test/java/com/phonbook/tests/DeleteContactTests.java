package com.phonbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {
    //preconditions
    @BeforeMethod
    public void preconditions() {
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("mekili4034@dpcos.com").setPassword("Aa!12345"));
        clickOnLoginButton();
        //add contact
        clickOnAddLink();
        fillContactForm(new Contact()
                .setName("Alla")
                .setLastName("Straus")
                .setPhone("01773458804")
                .setEmail("qa55@gmail.com")
                .setAddress("Berlin")
                .setDescription("QA"));
        clickOnSaveButton();
    }

    @Test
    public void deleteContactTest() {
        int sizeBefore = sizeOfContacts();
        deleteContact();
        pause(1000 );
        int sizeAfter = sizeOfContacts();
        //verify contact is deleted(by size)
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }


}
