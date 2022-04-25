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

public class AddSomeItems {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://grekoliva.ru");

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("grekoliva"));

        WebElement findOlives = driver.findElement(By.linkText("Оливки и пасты"));
        findOlives.click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("olives-and-pastes"));

        WebElement addOlives = driver.findElement(By.xpath("//td[2]/a"));
        addOlives.click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("olives-olive-oil"));

        WebElement addFirstOlives = driver.findElement(By.xpath("//input[@id='quantity_wanted_229']"));
        addFirstOlives.click();
        addFirstOlives.clear();
        addFirstOlives.sendKeys("3");
        //addFirstOlives.submit();

        WebElement addToBinOlives = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/ul/li[1]/div[2]/div/span[2]/a/img"));
        addToBinOlives.click();

    }
}
