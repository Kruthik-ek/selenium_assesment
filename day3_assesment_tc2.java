package seleniumassesment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class day3_assesment_tc2 {

public static void main(String[] args) throws InterruptedException {

	  WebDriver driver = new EdgeDriver();

      // 1. Navigate to QSpiders Demo App
      driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
      driver.manage().window().maximize();
      Thread.sleep(2000);

      // 2. Click on calendar/date field
      driver.findElement(By.xpath("//input[@placeholder='Select A Date']")).click();
      Thread.sleep(1000);
      //3.Navigate to the next month in the current year.
      //4.Select any valid date from that month.
      driver.findElement(By.xpath("//*[@id=\"demoUI\"]/main/section/article/aside/div/aside/div/article/div/div[1]/div/input")).sendKeys("01/10/2026");
      Thread.sleep(1000);

      // 5. Get selected date
      String selectedDate = driver.findElement(By.xpath("//input[@placeholder='Select A Date']")).getAttribute("value");
      System.out.println("Selected Date: " + selectedDate);

      // Verification
      if (selectedDate.contains("01/10/2026")) {
          System.out.println(" corrrect Date selected successfully");
      } else {
          System.out.println("not correct Date selection failed");
      }

      driver.quit();
		    }
		
	}


