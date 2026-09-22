package final_assesment;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testcase1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoapps.qspiders.com/ui/toggle/disabled?sublist=1");
        Thread.sleep(2000);

        List<WebElement> toggles = driver.findElements(By.xpath("//input[@type='checkbox'] | //span[contains(@class,'relative')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (WebElement toggle : toggles) 
        {
            js.executeScript("arguments[0].click();", toggle);
        }

        Thread.sleep(1000);

        WebElement placeOrderBtn = driver.findElement(By.xpath("//button[text()='Place Order']"));
        placeOrderBtn.click();

        Thread.sleep(2000);

       
        WebElement toastMessage = driver.findElement(By.xpath("//*[contains(text(),'Placed') or contains(text(),'Order') or contains(@class,'Toastify')]"));
        String message = toastMessage.getText();

        System.out.println("Notification: " + message);

        if (toastMessage.isDisplayed()) {
            System.out.println("Order is placed successfully");
        } else {
            System.out.println("Order is not placed");
        }

        driver.quit();
    }
}

