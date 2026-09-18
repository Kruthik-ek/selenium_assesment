
package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String name) {
        driver.findElement(By.id("first-name")).sendKeys(name);
    }

    public void enterLastName(String name) {
        driver.findElement(By.id("last-name")).sendKeys(name);
    }

    public void enterPostalCode(String code) {
        driver.findElement(By.id("postal-code")).sendKeys(code);
    }

    public void clickContinue() {
        driver.findElement(By.id("continue")).click();
    }

    public String getOverviewTitle() {
        return driver.findElement(By.className("title")).getText();
    }

    public void clickFinish() {
        driver.findElement(By.id("finish")).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(By.className("complete-header")).getText();
    }
}
