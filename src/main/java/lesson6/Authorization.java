package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Authorization extends AbstractPage {

    @FindBy(css = "#qheader_login > a")
    private WebElement webElement;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordInputField;

    @FindBy(name = "SubmitLogin")
    private WebElement loginButton;

    public Authorization(WebDriver driver) {
        super(driver);
    }

    public Authorization input(){
        webElement.click();
        return this;
    }
    public Authorization setLogin(String login){
        this.emailInputField.click();
        this.emailInputField.sendKeys(login);
        return this;
    }

    public Authorization setPassword(String password){
        this.passwordInputField.click();
        this.passwordInputField.sendKeys(password);
        return this;
    }

    public void loginIn(String login, String password) throws InterruptedException {

        Actions loginIn = new Actions(getDriver());
        loginIn
                .click(this.webElement);
                Thread.sleep(1000);
                this.emailInputField.sendKeys(login);
                Thread.sleep(1000);
                this.passwordInputField.sendKeys(password);
                Thread.sleep(1000);
                loginButton.click();
    }
}