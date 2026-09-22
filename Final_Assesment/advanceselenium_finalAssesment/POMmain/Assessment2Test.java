package POMmain;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import orangehrmutil.HRMhomepg;
import orangehrmutil.HRMloginpg;
import orangehrmutil.HRMlogoutpg;
import orangehrmutil.HRmBuzzpg;

public class Assessment2Test {

    WebDriver driver;

    Properties prop;

    HRMloginpg loginPage;
    HRMhomepg homePage;
    HRmBuzzpg buzzPage;
    HRMlogoutpg logoutPage;

    @BeforeMethod
    public void setup() throws IOException {
        FileInputStream propFile = new FileInputStream("./src/test/resources/orangehrm/orangehrm.properties");
        prop = new Properties();
        prop.load(propFile);
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));
        
        loginPage = new HRMloginpg(driver);
        homePage = new HRMhomepg(driver);
        buzzPage = new HRmBuzzpg(driver);
        logoutPage = new HRMlogoutpg(driver);
    }

    @Test
    public void assessment2() throws IOException {

        loginPage.enterUsername(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("password") );
        loginPage.clickLogin();
        System.out.println("Login successful");
        homePage.clickBuzz();
        System.out.println("Buzz page opened");
        
        FileInputStream excelFile = new FileInputStream(prop.getProperty("excelPath"));
        Workbook workbook = WorkbookFactory.create(excelFile);
        Sheet sheet = workbook.getSheet(prop.getProperty("sheetName"));
        Row row = sheet.getRow(1);
        
        DataFormatter formatter = new DataFormatter();
        String postData = formatter.formatCellValue( row.getCell(0));
        System.out.println("Post from Excel: " + postData);
        workbook.close();
        excelFile.close();
        
        buzzPage.enterPost(postData);
        System.out.println("Post data entered");

        buzzPage.clickPost();
        System.out.println("Post button clicked");
        buzzPage.verifyPost(postData);
        logoutPage.logout();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            //driver.quit();
        }
    }
}