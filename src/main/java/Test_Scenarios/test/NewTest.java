package Test_Scenarios.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import io.github.bonigarcia.wdm.WebDriverManager;


public class NewTest {
	
	WebDriver driver;
	
 @BeforeTest
	  public void setup() {
	 
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
	  }
  @Test
  public void test() {

	  String webTitle1 = driver.getTitle();
	  
	  if (webTitle1.equals("Wikipedia"))
		{
		  System.out.println("Page Loaded!");
		  System.out.println("Wikipedia is a free online encyclopedia, created and edited by volunteers around the world and hosted by the Wikimedia Foundation.");
			
		}else
				{
			System.out.println("Page not Loaded");
				}
	 // System.out.println("Pass");	
  }


  @AfterTest
  public void teardown() {
		driver.close();
		driver.quit();
  }

}
