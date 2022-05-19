package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class MainTest extends AbstractTest{

    @Test
    void ReviewBin(){
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu.ReviewBin();
        Assertions.assertEquals("Ваша корзина пуста", getWebDriver().findElement(By.xpath("//p[@id='cart-buttons']/a")).getText());
    }

    @Test
    void AddSomeItems() {
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu.AddSomeItems();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://www.grekoliva.ru/"));
        Assertions.assertEquals("Оливковое масло", getWebDriver().findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/div[1]/h5/a")).getText());
        Assertions.assertEquals("Оливковое масло Olivi Platinum нефильтрованное, Греция, ст.бут., 500мл", getWebDriver().findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/a[2]")).getText());
        Assertions.assertEquals("5 400 руб.", getWebDriver().findElement(By.xpath("//*[@id=\"cart_block_total\"]")).getText(), "Масло успешно добавлено в корзину");
    }

    @Test
    void AddPremiumOil(){
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu.AddPremiumOil();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://www.grekoliva.ru/"));
        Assertions.assertEquals("Оливковое масло", getWebDriver().findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/div[1]/h5/a")).getText());
        Assertions.assertEquals("Ваша корзина пуста", getWebDriver().findElement(By.xpath("//div[@id='subcategories']/ul/li/a[2]")).getText(), "PREMIUM ORGANIC");
    }
}
