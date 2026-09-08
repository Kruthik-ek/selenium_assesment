package seleniumassesment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assesment1 {
     public static void main(String[] args) throws IOException{
		// Launch the browser
    	 WebDriver driver = new ChromeDriver();
    	 // maximize the Browser
    	 driver.manage().window().maximize();
    	 //implicity wait for all find element
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	 //navigate to the browser
    	 driver.get("https://www.saucedemo.com/");
    	 //pass user creditionla
    	 driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
    	 // pass password
    	 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
    	 //Login
    	 driver.findElement(By.xpath("//input[@id='login-button']")).click();
    	 //use javascript executor to scroll
    	 JavascriptExecutor js = (JavascriptExecutor)driver;
    	 js.executeScript("window.scrollTo(0,500)");
    	 //Take ScreenShot and save
    	 TakesScreenshot ts = (TakesScreenshot)driver;
    	 File src = ts.getScreenshotAs(OutputType.FILE);
    	 File dest = new File("./Ss/products-page.png");
    	 FileHandler.copy(src,dest);
	}
}
