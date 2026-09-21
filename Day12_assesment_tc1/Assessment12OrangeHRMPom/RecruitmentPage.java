package Assessment12OrangeHRMPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {
	WebDriver driver;
	public RecruitmentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
    @FindBy(xpath = "//span[text()='Recruitment']")
    private WebElement recruitmentLink;

    @FindBy(xpath = "//a[text()='Vacancies']")
    private WebElement vacanciesLink;


    public void clickRecruitment() {
        recruitmentLink.click();
    }

    public void clickVacancies() {
        vacanciesLink.click();
    }

}