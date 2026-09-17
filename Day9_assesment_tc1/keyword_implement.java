package keyworddrivenclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class keyword_implement {
	WebDriver driver;
	public void launchBrowser()
	{
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
	public void openurl()
	{
		driver.get("https://demowebshop.tricentis.com/");
	}
	public void searchtf() {
		driver.findElement(By.id("small-searchterms")).sendKeys("computers");
	}
	public void searchbutton() {
		driver.findElement(By.cssSelector("[value='Search']")).click();;
	}
	public void closebrowser() {
		driver.quit();
	}
}
