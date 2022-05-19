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

    public void loginIn() throws InterruptedException {
        this.webElement.click();
        Thread.sleep(1000);
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

    public void loginIn(String login, String password){

        Actions loginIn = new Actions(getDriver());
        loginIn
                .sendKeys(this.emailInputField,login)
                .click(this.passwordInputField)
                .sendKeys(password)
                .click(this.loginButton)
                .build()
                .perform();
    }
}