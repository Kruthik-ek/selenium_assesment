package POMmain;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomutilities.orangehrmpage;
public class orangehrmtest {
	public static void main(String[] args) throws IOException {

        

        FileInputStream file =
                new FileInputStream(
                        "src/test/resources/orangeHrmAssesment/orghrmDay8.properties");

        Properties p = new Properties();

        p.load(file);



        String Browser = p.getProperty("Browser");

        String url = p.getProperty("url");

        String username = p.getProperty("username");

        String password = p.getProperty("password");

        String firstName = p.getProperty("firstName");

        String middleName = p.getProperty("middleName");

        String lastName = p.getProperty("lastName");

        String email = p.getProperty("email");

        String mobile = p.getProperty("mobile");

        String filePath = p.getProperty("filePath");


       

        WebDriver driver = null;

        if (Browser.equals("chrome")) {

            driver = new ChromeDriver();
        }


       
        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));


       
        driver.get(url);


        

        orangehrmpage o =
                new orangehrmpage(driver);


        
        o.enterUsername(username);

        o.enterPassword(password);

        o.clickLogin();


      

        o.clickRecruitment();


  
        o.clickAdd();

        o.enterFirstName(firstName);

        o.enterMiddleName(middleName);

        o.enterLastName(lastName);

        o.selectVacancy();

        o.enterEmail(email);

        o.enterMobile(mobile);

        o.uploadFile(filePath);

        o.selectApplicationDate();

        o.clickSave();


       
        o.clickCandidates();


      

        o.selectJobTitle();

        o.selectVacancyForSearch();

        o.selectHiringManager();

        o.selectStatus();

        o.enterCandidateName(firstName);

        o.selectSearchApplicationDate();

        o.clickSearch();


       
        boolean result =
                o.verifyCandidate(firstName);

        if (result) {

            System.out.println(
                    "Candidate is present in Records Found section");

        } else {

            System.out.println(
                    "Candidate is NOT present in Records Found section");
        }



        o.logout();


        System.out.println("Testcase completed");

        // driver.quit();

}
}
