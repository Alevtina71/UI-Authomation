package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class MainTest extends AbstractTest{

    @Test
    void ReviewBin() throws InterruptedException {
        new MainMenu (getWebDriver())
                .reviewBin();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://www.grekoliva.ru/"));
        Assertions.assertEquals("Ваша корзина пуста", getWebDriver().findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/p")).getText());
    }

    @Test
    void AddSomeItems() throws InterruptedException {
        new MainMenu(getWebDriver())
                .addSomeItems();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://www.grekoliva.ru/"));
        Assertions.assertEquals("5400 руб.", getWebDriver().findElement(By.cssSelector("#cart_block_total")).getText(), "Масло успешно добавлено в корзину");
    }

    @Test
    void AddPremiumOil() throws InterruptedException {
        new MainMenu(getWebDriver())
            .addPremiumOil();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://www.grekoliva.ru/"));
        //Assertions.assertEquals("Ваша корзина пуста", getWebDriver().findElement(By.xpath("//div[@id='subcategories']/ul/li/a[2]")).getText(), "PREMIUM ORGANIC");
    }
}
