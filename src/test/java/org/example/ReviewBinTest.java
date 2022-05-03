package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReviewBinTest extends AbstractTest{
    @Test
    void test() throws Exception {
        getDriver().get("https://grekoliva.ru");
        WebElement webElement = getDriver().findElement(By.xpath("//p[@id='cart-buttons']/a"));
        webElement.click();
        /* try {
            WebElement webElementError = driver.findElement(By.name("error"));
        } catch (NoSuchElementException e){
            System.out.println(e.getSupportUrl());
        } */
    }
}
