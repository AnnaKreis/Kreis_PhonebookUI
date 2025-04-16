package com.phonbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase {
    //login
    @BeforeMethod
    public void preconditions() {
        clickOnLoginLink();
        fillRegisterLoginForm("mekili4034@dpcos.com", "Aa!12345");
        clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        //click on Add link
        clickOnAddLink();

        fillContactForm("Alla", "Straus", "01773458804", "qa55@gmail.com", "Berlin", "QA");
        //click save button
        click(By.cssSelector(".add_form__2rsm2 button"));

        //verify contact is added
        Assert.assertTrue(isContactAdded("Alla"));


    }

    public void fillContactForm(String name, String lastName, String phone, String email, String address, String description) {
        //enter name
        type(By.cssSelector("input[placeholder='Name']"), name);
        //enter lastname
        type(By.cssSelector("input[placeholder='Last Name']"), lastName);
        //enter phone
        type(By.cssSelector("input[placeholder='Phone']"), phone);
        //enter email
        type(By.cssSelector("input[placeholder='email']"), email);
        //enter address
        type(By.cssSelector("input[placeholder='Address']"), address);
        //enter description
        type(By.cssSelector("input[placeholder='description']"), description);
    }

    public void clickOnAddLink() {
        click(By.cssSelector("[href='/add']"));
    }

    public boolean isContactAdded(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element : contacts) {
            if(element.getText().contains(text))
                return true;
        }
        return false;
    }
    @AfterMethod
    public void postCondition() {
        driver.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
        driver.findElement(By.xpath("//button[.='Remove']")).click();

    }

}
