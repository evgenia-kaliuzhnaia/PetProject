package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='cart_item']")
    private List<WebElement> productCards;

    @FindBy(xpath = "//*[@id='continue-shopping']")
    private WebElement buttonContinue;

    @FindBy(xpath = "//*[@id='checkout']")
    private WebElement buttonCheckout;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getProductCards() {
        return this.productCards;
    }

    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonCheckout)).click();
    }

    public void clickContinue(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonContinue)).click();
    }
}
