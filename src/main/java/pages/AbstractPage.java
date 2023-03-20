package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    //fields
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected int WAIT_FOR_ELEMENTS_SECONDS = 10;


    //constructor
    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENTS_SECONDS));
        PageFactory.initElements(this.driver, this);
    }

    //methods
    public void openPage(String url) {
        driver.get(url);
    }
}
