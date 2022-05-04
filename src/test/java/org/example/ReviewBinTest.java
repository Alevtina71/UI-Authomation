package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReviewBinTest extends AbstractTest{
    @Test
    void test() throws Exception {
        getDriver().get("https://grekoliva.ru");
        WebElement webElement = getDriver().findElement(By.xpath("//p[@id='cart-buttons']/a"));
        webElement.click();
        WebElement webElement1 = getDriver().findElement(By.xpath("//*[@id='center_column']/p"));
        System.out.println("то что есть на самом деле - "+ webElement1.getText());
        Assertions.assertEquals("Ваша корзина пуста", webElement1.getText());
    }
}
