package seleniumassesment;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day2_assesment_tc2 {

	public static void main(String[] args)throws InterruptedException 
	{
		//launch the browser
		WebDriver driver = new ChromeDriver();
		// maximize
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// go to application
		driver.get("https://www.facebook.com/");
		Thread.sleep(1000);
		// get location of create new account button
		WebElement createaccount = driver.findElement(By.xpath("//span[text()='Create new account']"));
		Point loc=createaccount.getLocation();
		System.out.println("Location of create new Act "+loc);
		// domattribute and domproperty before 
		WebElement emailf = driver.findElement(By.id("_R_1h6kqsqppb6amH1_"));
		String beforeAttribute=emailf.getDomAttribute("value");
		String beforeProperty=emailf.getDomProperty("value");
		System.out.println(beforeAttribute);
		System.out.println(beforeProperty);
		emailf.sendKeys("kruthik@gmail.com");
		String afterAttribute=emailf.getDomAttribute("value");
		String afterProperty=emailf.getDomProperty("value");
		System.out.println(afterAttribute);
		System.out.println(afterProperty);
		// click on create new account
		createaccount.click();
		// cssvalue for submit button
		WebElement subbtn = driver.findElement(By.xpath("(//span[text()='Submit'])[2]"));
		System.out.println("Submit size "+subbtn.getSize());
		System.out.println(subbtn.getCssValue("color"));
		System.out.println(subbtn.getCssValue("font-size"));
		System.out.println(subbtn.getCssValue("box-sizing"));
		driver.quit();
		
	}

}