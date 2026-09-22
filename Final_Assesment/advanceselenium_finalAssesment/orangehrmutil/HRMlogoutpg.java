package orangehrmutil;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HRMlogoutpg {

    WebDriver driver;
    WebDriverWait wait;
    public HRMlogoutpg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    WebElement userDropdown;
    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutLink;
    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(userDropdown));
        userDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
        System.out.println("Successfully logged out");
    }
}