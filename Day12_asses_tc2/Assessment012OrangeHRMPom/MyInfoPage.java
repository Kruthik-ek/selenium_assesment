package Assessment012OrangeHRMPom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {

    WebDriver driver;

    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoLink;

    @FindBy(name = "firstName")
    private WebElement firstNameTF;

    @FindBy(name = "middleName")
    private WebElement middleNameTF;

    @FindBy(name = "lastName")
    private WebElement lastNameTF;

    @FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
    private WebElement employeeIdTF;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    public void clickMyInfo() throws InterruptedException {
        myInfoLink.click();
        Thread.sleep(3000);
    }

    public void changeFirstName(String firstName) {
        firstNameTF.click();
        firstNameTF.sendKeys(Keys.CONTROL, "a");
        firstNameTF.sendKeys(Keys.BACK_SPACE);
        firstNameTF.sendKeys(firstName);
    }

    public void changeLastName(String lastName) {
        lastNameTF.click();
        lastNameTF.sendKeys(Keys.CONTROL, "a");
        lastNameTF.sendKeys(Keys.BACK_SPACE);
        lastNameTF.sendKeys(lastName);
    }

    public void changeEmployeeId(String employeeId) {
        employeeIdTF.click();
        employeeIdTF.sendKeys(Keys.CONTROL, "a");
        employeeIdTF.sendKeys(Keys.BACK_SPACE);
        employeeIdTF.sendKeys(employeeId);
    }

    public void clickSave() {
        saveButton.click();
    }

    public String getFirstName() {
        return firstNameTF.getAttribute("value");
    }

    public String getLastName() {
        return lastNameTF.getAttribute("value");
    }

    public String getEmployeeId() {
        return employeeIdTF.getAttribute("value");
    }
}
