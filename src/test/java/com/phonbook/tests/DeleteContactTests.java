package com.phonbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {
    //preconditions
    @BeforeMethod
    public void preconditions() {
        //login
        clickOnLoginLink();
        fillRegisterLoginForm("mekili4034@dpcos.com", "Aa!12345");
        clickOnLoginButton();

        //add contact
        click(By.cssSelector("[href='/add']"));
        type(By.cssSelector("input[placeholder='Name']"), "Alla");
        type(By.cssSelector("input[placeholder='Last Name']"), "Straus");
        type(By.cssSelector("input[placeholder='Phone']"), "01773458804");
        type(By.cssSelector("input[placeholder='email']"), "qa55@gmail.com");
        type(By.cssSelector("input[placeholder='Address']"), "Berlin");
        type(By.cssSelector("input[placeholder='description']"), "QA");
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    @Test
    public void deleteContactTest() {
        int sizeBefore = sizeOfContacts();
        //click on the card
        driver.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
        //click on the remove button
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        pause(1000 );
        int sizeAfter = sizeOfContacts();
        //verify contact is deleted(by size)
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }

    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;

    }
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
