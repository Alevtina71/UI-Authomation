package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReviewBinTest extends AbstractTest{
    @Test
    void test() throws Exception {
        getDriver().get("https://grekoliva.ru");
        WebElement webElement1 = getDriver().findElement(By.xpath("//p[@id='cart-buttons']/a"));
        webElement1.click();
        WebElement webElement2 = getDriver().findElement(By.xpath("//*[@id='center_column']/p"));
        System.out.println("то что есть на самом деле - "+ webElement2.getText());
        Assertions.assertEquals("Ваша корзина пуста", webElement2.getText());
    }
}
