package saucedemo;

import java.io.IOException;

import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest {

    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);

        Thread.sleep(2000);

        // Get username and password from properties file
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        // Login
        loginPage.login(username, password);

        Thread.sleep(2000);

        // Get Products page title
        String actualTitle = productsPage.getProductsTitle();

        // Verify Products page
        if (actualTitle.equals("Products")) {
            System.out.println("Products page is displayed successfully.");
        } else {
            System.out.println("Products page is NOT displayed.");
        }

        Thread.sleep(2000);
    }

 @Test(priority = 2, dependsOnMethods = "loginTest")
    public void orderPlacementTest() throws IOException, InterruptedException {

        productsPage = new ProductsPage(driver);

        // Add Sauce Labs Backpack
        productsPage.addBackpack();

        Thread.sleep(2000);

        // Get cart count
        String cartCount = productsPage.getCartCount();

        // Verify cart contains 1 item
        if (cartCount.equals("1")) {
            System.out.println("Cart contains 1 item.");
        } else {
            System.out.println("Cart does NOT contain 1 item.");
        }

        Thread.sleep(2000);

        // Open cart
        productsPage.clickCart();

        Thread.sleep(2000);

        cartPage = new CartPage(driver);

        // Get product name from cart
        String productName = cartPage.getBackpackName();

        // Verify Backpack is displayed
        if (productName.equals("Sauce Labs Backpack")) {
            System.out.println("Sauce Labs Backpack is displayed.");
        } else {
            System.out.println("Sauce Labs Backpack is NOT displayed.");
        }

        Thread.sleep(2000);

        // Click Checkout
        cartPage.clickCheckout();

        Thread.sleep(2000);

        checkoutPage = new CheckoutPage(driver);

        // Read First Name from Excel
        String firstName =
                ExcelUtility.getData("Sheet1", 1, 0);

        // Read Last Name from Excel
        String lastName =
                ExcelUtility.getData("Sheet1", 1, 1);

        // Read Postal Code from Excel
        String postalCode =
                ExcelUtility.getData("Sheet1", 1, 2);

        // Enter First Name
        checkoutPage.enterFirstName(firstName);

        Thread.sleep(1000);

        // Enter Last Name
        checkoutPage.enterLastName(lastName);

        Thread.sleep(1000);

        // Enter Postal Code
        checkoutPage.enterPostalCode(postalCode);

        Thread.sleep(2000);

        // Click Continue
        checkoutPage.clickContinue();

        Thread.sleep(2000);

        // Get Overview page title
        String overviewTitle = checkoutPage.getOverviewTitle();

        // Verify Checkout Overview page
        if (overviewTitle.equals("Checkout: Overview")) {
            System.out.println("Checkout: Overview page is displayed.");
        } 
        else
        { System.out.println("Order was NOT completed successfully.");
        } 
        Thread.sleep(3000); 
        } 
 }
