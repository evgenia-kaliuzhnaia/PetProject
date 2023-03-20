package scripts;

import browser.BrowserSetup;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import java.util.List;

public class CartPageTest extends BrowserSetup {

    // adding items to cart
    @Test
    public void addItemsToCartViaProductPage() throws InterruptedException {

        // open authorization page
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.openPage();

        // log in
        authorizationPage.logIn(properties.getProperty("correct.login"), properties.getProperty("correct.password"));

        // open main page
        MainPage mainPage = new MainPage(driver);

        // select an item
        mainPage.pickItem(properties.getProperty("item1"));

        // open product page
        ProductPage productPage = new ProductPage(driver);

        // add item to cart
        Thread.sleep(5000);
        productPage.addToCart();

        // go back to the main page
        productPage.backToShopping();

        // select another item
        mainPage.pickItem(properties.getProperty("item2"));

        // add item to cart
        productPage.addToCart();

        // click the cart icon
        mainPage.openCartPage();

        // open cart page
        CartPage cartPage = new CartPage(driver);
        List<WebElement> itemsInCart = cartPage.getProductCards();

        // verify that cart contains several items
        Assert.assertTrue(itemsInCart.size() > 1);
    }

    // proceeding to checkout
    @Test
    public void proceedToCheckout() {

        // open authorization page
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.openPage();

        // log in
        authorizationPage.logIn(properties.getProperty("correct.login"), properties.getProperty("correct.password"));

        // open main page
        MainPage mainPage = new MainPage(driver);

        // click  the cart icon
        mainPage.openCartPage();

        // open cart page
        CartPage cartPage = new CartPage(driver);

        // click checkout button
        cartPage.clickCheckout();

        // open checkout page
        CheckoutPersonalInfo personalInfo = new CheckoutPersonalInfo(driver);

        // enter personal info
        personalInfo.fillInInputs();

        // click continue button
        personalInfo.clickContinue();

        // open checkout overview page
        CheckoutOverview checkoutOverview = new CheckoutOverview(driver);

        // click finish button
        checkoutOverview.clickFinish();

        // open checkout complete page
        CheckoutComplete checkoutComplete = new CheckoutComplete(driver);

        // click back home button
        checkoutComplete.clickBackHome();

        // verify that main page is open
        Assert.assertEquals(driver.getCurrentUrl(), properties.getProperty("expected.value"));
    }

    // continuing shopping
    @Test
    public void goBackToShoppingFromTheCart() {

        // open authorization page
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.openPage();

        // log in
        authorizationPage.logIn(properties.getProperty("correct.login"), properties.getProperty("correct.password"));

        // open main page
        MainPage mainPage = new MainPage(driver);

        // click the cart icon
        mainPage.openCartPage();

        // open the cart page
        CartPage cartPage = new CartPage(driver);

        // click the continue shopping button
        cartPage.clickContinue();

        // verify that the main page is open
        Assert.assertEquals(driver.getCurrentUrl(), properties.getProperty("expected.value"));
    }

    // adding items to cart from the main page
    @Test
    public void addItemsToCartByNameViaMainPage() {
        // open authorization page
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.openPage();

        // log in
        authorizationPage.logIn(properties.getProperty("correct.login"), properties.getProperty("correct.password"));

        // open main page
        MainPage mainPage = new MainPage(driver);

        // add items to cart
        mainPage.addItemToCart(properties.getProperty("item1"));
        mainPage.addItemToCart(properties.getProperty("item2"));
        mainPage.addItemToCart(properties.getProperty("item3"));

        // click the cart icon
        mainPage.openCartPage();

        // open cart page
        CartPage cartPage = new CartPage(driver);
        List<WebElement> itemsInCart = cartPage.getProductCards();

        // verify that cart contains several items
        Assert.assertTrue(itemsInCart.size() > 1);
    }
}