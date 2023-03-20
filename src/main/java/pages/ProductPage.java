package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='inventory_details_img']")
    private WebElement image;

    @FindBy(xpath = "//*[@class='inventory_details_name large_size']")
    private WebElement title;

    @FindBy(xpath = "//*[@class='inventory_details_desc large_size']")
    private WebElement description;

    @FindBy(xpath = "//*[@class='inventory_details_price']")
    private WebElement price;

    @FindBy(xpath = "//*[@class='btn btn_primary btn_small btn_inventory']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id='back-to-products']")
    private WebElement backButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public void backToShopping() {
        wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();
    }
}
