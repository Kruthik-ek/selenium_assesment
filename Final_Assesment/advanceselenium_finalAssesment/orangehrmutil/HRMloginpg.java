package orangehrmutil;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HRMloginpg {

    WebDriver driver;
    WebDriverWait wait;

    public HRMloginpg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @FindBy(name = "username")
    WebElement usernameTF;

    @FindBy(name = "password")
    WebElement passwordTF;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameTF));
        usernameTF.clear();
        usernameTF.sendKeys(username);
    }
    public void enterPassword(String password) {
        passwordTF.clear();
        passwordTF.sendKeys(password);
    }
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }
}