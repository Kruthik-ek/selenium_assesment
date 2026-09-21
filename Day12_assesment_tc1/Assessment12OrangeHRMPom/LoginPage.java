package Assessment12OrangeHRMPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    private WebElement usernameTF;

    @FindBy(name = "password")
    private WebElement passwordTF;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;

    public void enterUsername(String username) {
        usernameTF.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordTF.sendKeys(password);
    }

    public void clickLogin() throws InterruptedException {
        loginBtn.click();
        Thread.sleep(5000);
    }

    public void login(String username, String password)
            throws InterruptedException {

        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}