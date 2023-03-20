package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutOverview extends AbstractPage {

    @FindBy(xpath = "//*[@id='finish']")
    private WebElement finishButton;

    @FindBy(xpath = "//*[@id='cancel']")
    private WebElement cancelButton;

    public CheckoutOverview(WebDriver driver) {
        super(driver);
    }

    public void clickFinish() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }

    public void clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
    }
}
