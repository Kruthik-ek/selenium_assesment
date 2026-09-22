package final_assesment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class testcase3 {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToCorrect?sublist=2");
		
		WebElement mobc= driver.findElement(By.xpath("//div[text()='Mobile Charger']"));
		WebElement lapc= driver.findElement(By.xpath("//div[text()='Laptop Charger']"));
		
		WebElement mobco= driver.findElement(By.xpath("//div[text()='Mobile Cover']"));
		WebElement lapco= driver.findElement(By.xpath("//div[text()='Laptop Cover']"));
		
		WebElement mobac=driver.findElement(By.xpath("//div[text()='Mobile Accessories']"));
		WebElement lapac=driver.findElement(By.xpath("//div[text()='Laptop Accessories']"));
		
		Actions action=new Actions(driver);
		action.dragAndDrop(mobc, mobac).perform();
		action.dragAndDrop(mobco, mobac).perform();
		action.dragAndDrop(lapc, lapac).perform();
		action.dragAndDrop(lapco, lapac).perform();
	}
}
