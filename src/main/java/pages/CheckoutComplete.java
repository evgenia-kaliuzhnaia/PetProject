package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutComplete extends AbstractPage {

    @FindBy(xpath = "//*[@id='back-to-products']")
    private WebElement backHomeButton;

    public CheckoutComplete(WebDriver driver) {
        super(driver);
    }

    public void clickBackHome() {
        wait.until(ExpectedConditions.elementToBeClickable(backHomeButton)).click();
    }
}
