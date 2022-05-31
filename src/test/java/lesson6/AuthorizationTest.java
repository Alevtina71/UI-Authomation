package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AuthorizationTest extends AbstractTest {

    @Test
    void loginIn() throws InterruptedException {
        new Authorization(getWebDriver())
                .setLogin("gnocco@rambler.ru")
                .setPassword("381038")
                .loginIn();
        Assertions.assertEquals("вход / регистрация", getWebDriver().findElement(By.cssSelector("#qheader_login > a")).getText(), "Успешная авторизация");
    }
}