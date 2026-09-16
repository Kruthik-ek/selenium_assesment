package pomutilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class orangehrmpage {
	WebDriver driver;
	WebDriverWait wait;
	
	public  orangehrmpage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
	}
        
        //LOgin PAGE CREDENTIALS
        @FindBy(name = "username")
        private WebElement username;
        
        @FindBy(name = "password")
        private WebElement password;
        
        @FindBy(xpath= "//button[@type='submit']" )
        private WebElement loginbutton;
        
        /// RECRIUTMENT
        @FindBy(xpath = "//span[text()='Recruitment']")
        private WebElement recruitment;
        
        // ADD CANDIDATE 
        @FindBy(xpath = "//button[normalize-space()='Add']")
        private WebElement add;

        @FindBy(name = "firstName")
        private WebElement firstName;

        @FindBy(name = "middleName")
        private WebElement middleName;

        @FindBy(name = "lastName")
        private WebElement lastName;

        @FindBy(xpath = "//label[text()='Vacancy']/following::div[contains(@class,'oxd-select-text')][1]")
        private WebElement vacancy;

        @FindBy(xpath = "//input[@placeholder='Type here']")
        private WebElement email;

        @FindBy(xpath = "//label[text()='Contact Number']/following::input[1]")
        private WebElement mobile;

        @FindBy(xpath = "//input[@type='file']")
        private WebElement resume;

        @FindBy(xpath = "//label[contains(text(),'Date of Application')]/following::input[1]")
        private WebElement applicationDate;

        @FindBy(xpath = "//button[normalize-space()='Save']")
        private WebElement saveButton;
        
        // CANDIDATES
        @FindBy(xpath = "//a[normalize-space()='Candidates']")
        private WebElement candidates;
        
        @FindBy(xpath = "//label[text()='Job Title']/following::div[contains(@class,'oxd-select-text')][1]")
        private WebElement jobTitle;

        @FindBy(xpath = "//label[text()='Hiring Manager']/following::div[contains(@class,'oxd-select-text')][1]")
        private WebElement hiringManager;

        @FindBy(xpath = "//label[text()='Status']/following::div[contains(@class,'oxd-select-text')][1]")
        private WebElement status;

        @FindBy(xpath = "//label[text()='Candidate Name']/following::input[1]")
        private WebElement candidateName;

        @FindBy(xpath = "//button[normalize-space()='Search']")
        private WebElement searchButton;
        @FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]")
        private WebElement userMenu;

        @FindBy(xpath = "//a[text()='Logout']")
        private WebElement logout;


      

        public void enterUsername(String arg) {
            username.sendKeys(arg);
        }

        public void enterPassword(String arg) {
            password.sendKeys(arg);
        }

        public void clickLogin() {
            loginbutton.click();
        }



        public void clickRecruitment() {
            wait.until(ExpectedConditions.elementToBeClickable(recruitment)).click();
        }


    

        public void clickAdd() {
            wait.until(ExpectedConditions.elementToBeClickable(add)).click();
        }

        public void enterFirstName(String arg) {
            firstName.sendKeys(arg);
        }

        public void enterMiddleName(String arg) {
            middleName.sendKeys(arg);
        }

        public void enterLastName(String arg) {
            lastName.sendKeys(arg);
        }

        public void selectVacancy() {

            vacancy.click();

            WebElement firstOption = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[@role='option'][1]")));

            firstOption.click();
        }

        public void enterEmail(String arg) {
            email.sendKeys(arg);
        }

        public void enterMobile(String arg) {
            mobile.sendKeys(arg);
        }

        public void uploadFile(String arg) {
            resume.sendKeys(arg);
        }

        public void selectApplicationDate() {

            applicationDate.click();

            applicationDate.sendKeys(Keys.TAB);
        }

        public void clickSave() {
        	wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();

        }



        public void clickCandidates() {

            wait.until(ExpectedConditions.elementToBeClickable(candidates)).click();

        }

        public void selectJobTitle() {

            jobTitle.click();

            WebElement firstOption = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[@role='option'][1]")));

            firstOption.click();
        }

        public void selectVacancyForSearch() {

            vacancy.click();

            WebElement firstOption = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[@role='option'][1]")));

            firstOption.click();
        }

        public void selectHiringManager() {

            hiringManager.click();

            WebElement firstOption = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[@role='option'][1]")));

            firstOption.click();
        }

        public void selectStatus() {

            status.click();

            WebElement firstOption = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[@role='option'][1]")));

            firstOption.click();
        }

        public void enterCandidateName(String arg) {
            candidateName.sendKeys(arg);
        }

        public void selectSearchApplicationDate() {

            // Enter today's date
            WebElement fromDate = driver.findElement(
                    By.xpath("//label[contains(text(),'Date of Application')]/following::input[1]"));

            fromDate.sendKeys("2026-09-15");
        }

        public void clickSearch() {
            searchButton.click();
        }


   

        public boolean verifyCandidate(String arg) {

            try {

                WebElement candidate = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//div[@role='row']//div[contains(text(),'" 
                                        + arg + "')]")));

                return candidate.isDisplayed();

            } catch (Exception e) {

                return false;
            }
        }


       
        public void logout() {

            userMenu.click();

            wait.until(ExpectedConditions.elementToBeClickable(logout)).click();



	}

}
