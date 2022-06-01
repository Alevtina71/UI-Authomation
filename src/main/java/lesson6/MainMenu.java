package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenu extends AbstractPage {

    @FindBy(xpath = "//p[@id='cart-buttons']/a")
    private WebElement webElement1;

    @FindBy(xpath = "//*[@id='center_column']/p")
    private WebElement webElement2;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[2]/div[1]/h5/a")
    private WebElement findOlives;

    @FindBy(xpath = "//*[@id=\"subcategories\"]/ul/li[1]/a[2]")
    private WebElement addOlives;

    @FindBy(xpath = "//*[@id=\"product_list\"]/li[1]/div[1]/h3/a")
    private WebElement addOils;

    @FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
    private WebElement addSomeOils;

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/input")
    private WebElement addToBin;

    @FindBy(xpath = "//*[@id=\"cart_block_total\"]")
    private WebElement addToBinOlives;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[2]/div[1]/h5/a")
    private WebElement findOil;

    @FindBy(xpath = "//div[@id='subcategories']/ul/li/a[2]")
    private WebElement findPremiumOil;

    @FindBy(xpath = "//*[@id=\"product_list\"]/li[2]/div[2]/div/span[2]/a/img")
    private WebElement addPremiumOil;

    public MainMenu(WebDriver driver) {
        super(driver);
    }

    public MainMenu reviewBin() throws InterruptedException {
        webElement1.click();
        Thread.sleep(1000);
        return this;
    }

    public MainMenu addSomeItems() throws InterruptedException {
        findOlives.click();
        Thread.sleep(500);
        addOlives.click();
        Thread.sleep(500);
        addOils.click();
        Thread.sleep(500);
        addSomeOils.click();
        Thread.sleep(500);
        addSomeOils.clear();
        addSomeOils.sendKeys("3");
        addToBin.click();
        addToBinOlives.click();
        return this;
    }


    public MainMenu addPremiumOil() throws InterruptedException {
                findOil.click();
                Thread.sleep(500);
                findPremiumOil.click();
                Thread.sleep(500);
                addPremiumOil.click();
                Thread.sleep(500);
                return this;
    }
}