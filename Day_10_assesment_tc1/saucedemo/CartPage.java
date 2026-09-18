
package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBackpackName() {
        return driver.findElement(
                By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']")
        ).getText();
    }

    public void clickCheckout() {
        driver.findElement(By.id("checkout")).click();
    }
}
