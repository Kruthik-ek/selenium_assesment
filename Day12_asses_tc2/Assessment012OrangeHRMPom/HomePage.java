package Assessment012OrangeHRMPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]")
    private WebElement profileDropdown;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutLink;

    public void clickProfileDropdown() {
        profileDropdown.click();
    }

    public void clickLogout() {
        logoutLink.click();
    }

    public void logout() {
        clickProfileDropdown();
        clickLogout();
    }
}