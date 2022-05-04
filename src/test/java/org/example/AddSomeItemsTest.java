package org.example;

import org.example.lesson3.MyException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddSomeItemsTest extends AbstractTest {
    @Test
    public void test() throws MyException, InterruptedException {
        getDriver().get("https://grekoliva.ru");

        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("grekoliva"));

        WebElement findOlives = getDriver().findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/div[1]/h5/a"));
        System.out.println("то что есть на самом деле - "+ findOlives.getText());
        Assertions.assertEquals("Оливковое масло", findOlives.getText());
        findOlives.click();
        Thread.sleep(1000);

        WebElement addOlives = getDriver().findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/a[2]"));
        System.out.println("то что есть на самом деле - "+ addOlives.getText());
        Assertions.assertEquals("PREMIUM ORGANIC", addOlives.getText());
        addOlives.click();
        Thread.sleep(1000);

        WebElement addOils = getDriver().findElement(By.xpath("//*[@id=\"product_list\"]/li[1]/div[1]/h3/a"));
        System.out.println("то что есть на самом деле - "+ addOils.getText());
        Assertions.assertEquals("Оливковое масло Olivi Platinum нефильтрованное, Греция, ст.бут., 500мл", addOils.getText());
        addOils.click();
        Thread.sleep(1000);

        WebElement addSomeOils = getDriver().findElement(By.xpath("//*[@id=\"quantity_wanted\"]"));
        addSomeOils.click();
        addSomeOils.clear();
        addSomeOils.sendKeys("3");
        Thread.sleep(1000);

        WebElement addToBin = getDriver().findElement(By.xpath("//*[@id=\"add_to_cart\"]/input"));
        addToBin.click();
        Thread.sleep(3000);

        WebElement addToBinOlives = getDriver().findElement(By.xpath("//*[@id=\"cart_block_total\"]"));
        System.out.println("то что есть на самом деле - "+ addToBinOlives.getText());
        Assertions.assertEquals("5 400 руб.", addToBinOlives.getText());
    }
}
