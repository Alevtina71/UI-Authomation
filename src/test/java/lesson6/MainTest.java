package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class MainTest extends AbstractTest{

    @Test
    void ReviewBin(){
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu.ReviewBin();

        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//p[@id='cart-buttons']/a")).getText().equals("Ваша корзина пуста"), "Успешно");
    }

    @Test
    void AddSomeItems() {
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu.AddSomeItems();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://www.grekoliva.ru/"));
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/div[1]/h5/a")).getText().equals("Оливковое масло"));
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/a[2]")).getText().equals("Оливковое масло Olivi Platinum нефильтрованное, Греция, ст.бут., 500мл"));
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//*[@id=\"cart_block_total\"]")).getText().equals("5 400 руб."), "Масло успешно добавлено в корзину");
    }

    @Test
    void AddPremiumOil(){
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu.AddPremiumOil();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://www.grekoliva.ru/"));
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/div[1]/h5/a")).getText().equals("Оливковое масло"));
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//div[@id='subcategories']/ul/li/a[2]")).getText().equals("Ваша корзина пуста"), "PREMIUM ORGANIC");
    }
}
