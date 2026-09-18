
package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String user) {
        driver.findElement(By.id("user-name")).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(By.id("password")).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }
}

