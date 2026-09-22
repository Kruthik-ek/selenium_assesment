package orangehrmutil;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HRmBuzzpg {

    WebDriver driver;
    WebDriverWait wait;

    public HRmBuzzpg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath = "//textarea[@placeholder=\"What's on your mind?\"]")
    WebElement whatsOnYourMind;

    @FindBy(xpath = "//button[normalize-space()='Post']")
    WebElement postButton;

    public void enterPost(String postData) {
        wait.until(ExpectedConditions.visibilityOf(whatsOnYourMind));
        whatsOnYourMind.click();
        whatsOnYourMind.clear();
        whatsOnYourMind.sendKeys(postData);
    }

    public void clickPost() {
        wait.until(ExpectedConditions.elementToBeClickable(postButton));
        postButton.click();
    }

    public void verifyPost(String postData) {

        By postLocator = By.xpath("//div[contains(@class,'orangehrm-buzz-post-body')]" +"[contains(normalize-space(),'" + postData + "')]");
      wait.until(ExpectedConditions.visibilityOfElementLocated(postLocator));
        WebElement post = driver.findElement(postLocator);
        
        if (post.getText().contains(postData)) 
        {

            System.out.println("Post is present in Recent Posts");

        } else
        {

            System.out.println("Post is NOT present in Recent Posts");
        }
    }
}