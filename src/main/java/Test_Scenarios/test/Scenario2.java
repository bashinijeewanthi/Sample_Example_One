package Test_Scenarios.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario2 {
	
	WebDriver driver;
	WebElement wikienglishpage;

  @BeforeTest
  public void setup() {
	  
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		
  }
  
  @Test
  public void test_Search_Country() {
	  
	  driver.findElement(By.xpath("//strong[contains(text(),'English')]")).click();

	  
	 WebDriverWait wait = new WebDriverWait(driver,50);
	 
	 wikienglishpage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
	  
	 driver.findElement(By.name("search")).sendKeys("Sri Lanaka");
	  
	 String header1 = driver.getTitle();
	  
	   if (header1.equals("Sri Lanka - Wikipedia"))
			   {
		   System.out.println("Sri Lanka details view!");
			   }
	   else
	   {
		   System.out.println("Sri Lanka details not view!");
	   }
	   	  
  }

  @AfterTest
  public void afterTest() {
		driver.close();
		driver.quit();
  }

}
