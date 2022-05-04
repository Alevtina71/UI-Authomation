package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class AuthorizationTest  extends AbstractTest{

    @Test
    void test() throws Exception {
        getDriver().get("https://grekoliva.ru");
        WebElement webElement = getDriver().findElement(By.cssSelector("#qheader_login > a"));
        Assertions.assertEquals("вход / регистрация",webElement.getText(),"Успешная авторизация");
        webElement.click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement emailInputField = getDriver().findElement(By.xpath("//input[@id='email']"));
        emailInputField.click();
        emailInputField.sendKeys("gnocco@rambler.ru");

        WebElement passwordInputField = getDriver().findElement(By.xpath("//input[@id='passwd']"));
        passwordInputField.click();
        passwordInputField.sendKeys("381038");

        WebElement loginButton = getDriver().findElement(By.name("SubmitLogin"));
        loginButton.click();
        /*try {
            getDriver().findElement(By.xpath(".//textarea")).click();
        } catch (ElementNotInteractableException e){
            System.out.println(e.getSupportUrl());
        }*/

        Thread.sleep(10000);
    }
}
