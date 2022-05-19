package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddPremiumOilTest extends AbstractTest{
    @Test
    void test() throws InterruptedException {
        getDriver().get("https://grekoliva.ru");
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("grekoliva"));

        WebElement findOil = getDriver().findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/div[1]/h5/a"));
        System.out.println("то что есть на самом деле - "+ findOil.getText());
        Assertions.assertEquals("Оливковое масло", findOil.getText());
        findOil.click();

        WebElement findPremiumOil = getDriver().findElement(By.xpath("//div[@id='subcategories']/ul/li/a[2]"));
        Assertions.assertEquals("PREMIUM ORGANIC", findPremiumOil.getText());
        findPremiumOil.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("oil-premium-organic"));
        Thread.sleep(1000);
        WebElement addPremiumOil = getDriver().findElement(By.xpath("//*[@id=\"product_list\"]/li[2]/div[2]/div/span[2]/a/img"));
        addPremiumOil.click();

        /*WebElement webElement1 = getDriver().findElement(By.xpath("//*[@id=\"cart_block_total\"]"));
        Assertions.assertEquals("0 руб.", webElement1.getText());
        findPremiumOil.click();*/
    }
}
