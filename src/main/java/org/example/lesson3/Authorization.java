package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit; */

public class Authorization {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://grekoliva.ru");

        //WebElement webElement1 = driver.findElement(By.name("q"));
        WebElement webElement2 = driver.findElement(By.cssSelector("#qheader_login > a"));

        /* try {
            WebElement webElementError = driver.findElement(By.name("error"));
        } catch (NoSuchElementException e){
            System.out.println(e.getSupportUrl());
        } */

        webElement2.click();

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("authentication"));

        WebElement emailInputField = driver.findElement(By.xpath("//input[@id='email']"));
        emailInputField.click();
        emailInputField.sendKeys("gnocco@rambler.ru");

        WebElement passwordInputField = driver.findElement(By.xpath("//input[@id='passwd']"));
        passwordInputField.click();
        passwordInputField.sendKeys("381038");

        WebElement loginButton = driver.findElement(By.name("SubmitLogin"));
        loginButton.click();

        /*try {
            webElement1.sendKeys("New search");
        } catch (StaleElementReferenceException e){
            System.out.println(e.getSupportUrl());
        }*/

        try {
            driver.findElement(By.xpath(".//textarea")).click();
        } catch (ElementNotInteractableException e){
            System.out.println(e.getSupportUrl());
        }
    }
}