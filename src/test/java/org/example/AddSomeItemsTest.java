package org.example;

import org.example.lesson3.MyException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddSomeItemsTest extends AbstractTest {
    @Test
    public void test() throws MyException {
        getDriver().get("https://grekoliva.ru");

        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("grekoliva"));

        WebElement findOlives = getDriver().findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/div[1]/h5/a"));
        findOlives.click();
        System.out.println("то что есть на самом деле"+ findOlives.getText());
        //Assertions.assertEquals("Оливковое масло", findOlives.getText());
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("olives-and-pastes"));

        WebElement addOlives = getDriver().findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/a[2]"));
        addOlives.click();
        Assertions.assertEquals("PREMIUM", addOlives.getText());
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("olives-olive-oil"));

        WebElement addFirstOlives = getDriver().findElement(By.xpath("//input[@id='quantity_wanted_229']"));
        addFirstOlives.click();
        addFirstOlives.clear();
        addFirstOlives.sendKeys("3");

        WebElement addToBinOlives = getDriver().findElement(By.xpath("//*[@id=\"product_list\"]/li[1]/div[2]/div/span[2]/a/img"));
        addToBinOlives.click();
    }
}
