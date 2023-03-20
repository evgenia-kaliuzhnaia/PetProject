package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.RandomString;

public class CheckoutPersonalInfo extends AbstractPage {

    @FindBy(xpath = "//*[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id='cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//*[@id='first-name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//*[@id='last-name']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//*[@id='postal-code']")
    private WebElement postalCodeInput;

    public CheckoutPersonalInfo(WebDriver driver) {
        super(driver);
    }

    public void clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void fillInInputs() {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput)).sendKeys(RandomString.getRandomString());
        wait.until(ExpectedConditions.visibilityOf(lastNameInput)).sendKeys(RandomString.getRandomString());
        wait.until(ExpectedConditions.visibilityOf(postalCodeInput)).sendKeys(RandomString.getRandomString());
    }
}
