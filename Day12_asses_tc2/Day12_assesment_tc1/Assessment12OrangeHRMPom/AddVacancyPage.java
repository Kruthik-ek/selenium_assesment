package Assessment12OrangeHRMPom;

import org.openqa.selenium.By;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddVacancyPage {
	 WebDriver driver;

	    public AddVacancyPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }


	    @FindBy(xpath = "//label[text()='Vacancy Name']/following::input[1]")
	    private WebElement vacancyNameTF;


	    @FindBy(xpath = "//label[text()='Job Title']/following::div[contains(@class,'oxd-select-text')][1]")
	    private WebElement jobTitleDropdown;


	    @FindBy(xpath = "//textarea")
	    private WebElement descriptionTF;


	    @FindBy(xpath = "//label[text()='Hiring Manager']/following::input[1]")
	    private WebElement hiringManagerTF;


	    @FindBy(xpath = "//label[text()='Number of Positions']/following::input[1]")
	    private WebElement numberOfPositionsTF;


	    @FindBy(xpath = "//button[@type='submit']")
	    private WebElement saveButton;


	    @FindBy(xpath = "//h5[text()='Vacancies']")
	    private WebElement vacanciesText;


	    public void enterVacancyName(String vacancyName) {
	        vacancyNameTF.sendKeys(vacancyName);
	    }


	    public void selectJobTitle(String jobTitle) {

	        jobTitleDropdown.click();

	        WebElement option = driver.findElement(
	                By.xpath(
	                    "//div[@role='option']//span[text()='"
	                    + jobTitle +
	                    "']"
	                )
	        );

	        option.click();
	    }


	    public void enterDescription(String description) {
	        descriptionTF.sendKeys(description);
	    }


	    public void selectHiringManager(String hiringManager) {

	        hiringManagerTF.clear();

	        hiringManagerTF.sendKeys(hiringManager);

	        By optionLocator = By.xpath(
	            "//div[@role='option']//*[contains(normalize-space(),'"
	            + hiringManager +
	            "')]"
	        );

	        try {

	            WebDriverWait wait =
	                    new WebDriverWait(driver, Duration.ofSeconds(10));

	            WebElement option = wait.until(
	                    ExpectedConditions.elementToBeClickable(optionLocator)
	            );

	            option.click();

	        } catch (Exception e) {

	            System.out.println(
	                "Hiring Manager '" + hiringManager + "' was not found."
	            );

	            throw e;
	        }
	    }


	    public void enterNumberOfPositions(String numberOfPositions) {
	        numberOfPositionsTF.sendKeys(numberOfPositions);
	    }


	    public void clickSave() {
	        saveButton.click();
	    }


	    public boolean verifyVacancyCreated() {
	        return vacanciesText.isDisplayed();
	    }

}