package Assessment12OrangeHRMBase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Assessment12OrangeHRMData.PropertyFileUtility;
import Assessment12OrangeHRMPom.LoginPage;

public class BaseClass {

    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Database connected");
    }

    @BeforeTest
    public void BT() {
        System.out.println("Pre-condition");
    }

    @BeforeClass
    public void beforeClass() throws IOException {

        String browser = PropertyFileUtility.getData("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions option = new ChromeOptions();

            option.addArguments("--disable-notifications");

            driver = new ChromeDriver(option);
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @BeforeMethod
    public void beforeMethod() throws IOException, InterruptedException {

        // Open OrangeHRM
        driver.get(
                PropertyFileUtility.getData("url")
        );

        // Login
        LoginPage loginPage = new LoginPage(driver);

        String username =
                PropertyFileUtility.getData("username");

        String password =
                PropertyFileUtility.getData("password");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        System.out.println("Login Successful");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Test Method Completed");
    }

    @AfterClass
    public void afterClass() {
            driver.quit();
    }
    @AfterTest
    public void At() {
        System.out.println("Post-condition");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Close DataBase");
    }
}