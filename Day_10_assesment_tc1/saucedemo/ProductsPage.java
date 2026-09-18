package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {


    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductsTitle() {
        return driver.findElement(By.className("title")).getText();
    }

    public void addBackpack() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    public String getCartCount() {
        return driver.findElement(By.className("shopping_cart_badge")).getText();
    }

    public void clickCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}