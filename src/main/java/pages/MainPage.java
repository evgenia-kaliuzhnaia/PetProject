package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends AbstractPage{

    @FindBy(xpath = "//*[@class='shopping_cart_link']")
    private WebElement cartButton;

    @FindBy(className = "inventory_item")
    private List<WebElement> items;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void pickItem(String textForXPath) {
        try {
            WebElement product = driver.findElement(By.xpath("//div[text()='"+ textForXPath +"']"));
            wait.until(ExpectedConditions.elementToBeClickable(product)).click();
        } catch (NoSuchElementException exception) {
            exception.getMessage();
            System.err.println("No such element by xpath - //div[text()='"+ textForXPath +"']");
        }

    }
    public void openCartPage() {
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
    }

    public void addItemToCart(String name) {
        for (int i = 0; i < items.size(); i++) {
            String nameOfProduct = items.get(i).findElement(By.className("inventory_item_name")).getText();
            WebElement buttonProduct = items.get(i).findElement(By.tagName("button"));
            if (nameOfProduct.equals(name)) {
                wait.until(ExpectedConditions.elementToBeClickable(buttonProduct)).click();
            }
        }
    }
}
