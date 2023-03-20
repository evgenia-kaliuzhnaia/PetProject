package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthorizationPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='user-name']")
    private WebElement login;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//*[@id='login-button']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//*[@data-test='error']")
    private WebElement errorMessage;


    //constructor
    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    // methods
    public void openPage() {
        super.openPage("https://www.saucedemo.com/");
    }

    public void setLogin(String inputLogin) {
        wait.until(ExpectedConditions.visibilityOf(login)).sendKeys(inputLogin);
    }

    public void setPassword(String inputPassword) {
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(inputPassword);
    }

    public void signIn() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonLogin)).click();
    }

    public boolean errorMessageDisplay() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed();
    }

    public String errorTextMessage() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
    }

    public void logIn(String inputLogIn, String inputPassword) {
        setLogin(inputLogIn);
        setPassword(inputPassword);
        signIn();
    }
}