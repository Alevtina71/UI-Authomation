package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddPremiumOil {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://grekoliva.ru");

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("grekoliva"));

        WebElement findOil = driver.findElement(By.xpath("//a[contains(text(),'Оливковое масло')]"));
        findOil.click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("olive-oil"));

        WebElement findPremiumOil = driver.findElement(By.xpath("//div[@id='subcategories']/ul/li/a[2]"));
        findPremiumOil.click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("oil-premium-organic"));

        WebElement addPremiumOil = driver.findElement(By.xpath("//*[@id=\"product_list\"]/li[2]/div[2]/div/span[2]/a/img"));
        addPremiumOil.click();

        WebElement webElement2 = driver.findElement(By.xpath("//p[@id='cart-buttons']/a"));
        webElement2.click();

    }
}
