package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = "//*[@id=\\\"center_column\\\"]/div[2]/div[1]/h5/a")
    private WebElement findOil;

    @FindBy(xpath = "//div[@id='subcategories']/ul/li/a[2]")
    private WebElement findPremiumOil;

    @FindBy(xpath = "//*[@id=\"product_list\"]/li[2]/div[2]/div/span[2]/a/img")
    private WebElement addPremiumOil;

    public MainMenu(WebDriver driver) {
        super(driver);
    }

    public void ReviewBin(){
        Actions actions = new Actions(getDriver());
        actions
                .click(webElement1)
                .click(webElement2)
                .build().
                perform();
    }

    public void AddSomeItems(){
        Actions actions = new Actions(getDriver());
        actions
                .click(findOlives)
                .pause(1000)
                .click(addOlives)
                .pause(1000)
                .click(addOils)
                .pause(1000)
                .click(addSomeOils)
                .pause(1000)
                .release(addSomeOils)
                .sendKeys(addSomeOils, "3")
                .click(addToBin)
                .click(addToBinOlives)
                .build()
                .perform();
    }

    public void AddPremiumOil(){
        Actions actions = new Actions(getDriver());
        actions
                .click(findOil)
                .pause(1000)
                .click(findPremiumOil)
                .pause(1000)
                .click(addPremiumOil)
                .build()
                .perform();
    }
}