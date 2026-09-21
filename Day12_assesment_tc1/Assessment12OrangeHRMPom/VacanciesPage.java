package Assessment12OrangeHRMPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VacanciesPage {
	
	WebDriver driver;
	public VacanciesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
    @FindBy(xpath = "//h5[text()='Vacancies']")
    private WebElement vacanciesText;

    @FindBy(xpath = "//button[contains(.,'Add')]")
    private WebElement addButton;


    public boolean verifyVacanciesPage() {
        return vacanciesText.isDisplayed();
    }

    public void clickAddVacancy() {
        addButton.click();
    }

}