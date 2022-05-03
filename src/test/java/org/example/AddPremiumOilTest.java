package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddPremiumOilTest extends AbstractTest{
    @Test
    void test() throws Exception {
        getDriver().get("https://grekoliva.ru");
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("grekoliva"));

        WebElement findOil = getDriver().findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/div[1]/h5/a"));
        findOil.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("olive-oil"));

        WebElement findPremiumOil = getDriver().findElement(By.xpath("//div[@id='subcategories']/ul/li/a[2]"));
        findPremiumOil.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("oil-premium-organic"));

        WebElement addPremiumOil = getDriver().findElement(By.xpath("//*[@id=\"product_list\"]/li[2]/div[2]/div/span[2]/a/img"));
        addPremiumOil.click();

        WebElement webElement2 = getDriver().findElement(By.xpath("//p[@id='cart-buttons']/a"));
        webElement2.click();
    }
}
