package Test_Scenarios.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.org.apache.xpath.internal.operations.Bool;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import ExtentReport.ExtentReport;
import ReadEXCEL.ReadExcel;
import java.io.IOException;

public class Scenario4 {
	
	WebDriver driver;
	WebElement wikienglishpage;
	WebElement annaunipage;
	ReadExcel ExcelFile = new ReadExcel ();
	ExtentReport EReport = new ExtentReport();
	

@BeforeTest
public void beforeTest() throws IOException {
	EReport.setUpReport();
	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://www.wikipedia.org/");
		driver.get(ExcelFile.readExcel(1, 0, ".\\data\\InputData.xlsx", "Details"));
		
}
	  
@Test
public void Search_Anna_University() throws IOException {
	  
	EReport.startTestCase("Search_Anna_University");
	String articls = driver.findElement(By.xpath("//strong[contains(text(),'English')]/../small/bdi")).getText();
	System.out.println(articls);

	driver.findElement(By.xpath("//strong[contains(text(),'English')]")).click();
	WebDriverWait wait = new WebDriverWait(driver,50);
		 
		wikienglishpage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
		  
		//driver.findElement(By.name("search")).sendKeys("Anna University");
		driver.findElement(By.name("search")).sendKeys(ExcelFile.readExcel(1, 1,".\\data\\InputData.xlsx","Details"));
		 
		//Select uni = new Select(driver.findElement(By.className("suggestions-results")));
/*
		List < WebElement >
		
        mylist=driver.findElements(By.xpath("/html/body/div[7]/div/a[1]/div/span"));
		System.out.println(mylist.size());
		for (int i = 0; i < mylist.size(); i++) {

	      String x = mylist.get(i).getText();
	      Boolean c =  mylist.get(i).getText().contains("Anna University");
        		
           mylist.get(i).click();
        	
		}  */
		driver.findElement(By.name("go")).click();
		 
		WebDriverWait wait1 = new WebDriverWait(driver,100);
		
			annaunipage = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"firstHeading\"]")));
		
			String moto = driver.findElement(By.xpath("//div[contains(text(),\"Motto in\")]/../../td[1]/i")).getText();
		
			String header1 = driver.getTitle();
		  
			if (header1.equals("Anna University - Wikipedia"))
			{
				System.out.println(moto); 
				EReport.logEventsPass("Search Anna University pass");
			}
		   else
		   {
			   //System.out.println("Test Fail"); 
			   EReport.logEventsFail("Search Anna University Fail");
		   }
		   
			
		  //String name = driver.findElement(By.linkText("Shiv Nadar")).getText();
		  String name = driver.findElement(By.linkText(ExcelFile.readExcel(1, 2,".\\data\\InputData.xlsx","Details"))).getText();
		   if (name.equals("Shiv Nadar"))
		   {
			  System.out.println(name + "is exist on listed in notable people section"); 
		   }
		   else
		   {
			   System.out.println("Test Fail"); 
		   }
  }


@AfterTest
public void afterTest() {
		driver.close();
		driver.quit();
  }

}
