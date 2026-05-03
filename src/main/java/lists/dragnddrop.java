package lists;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dragnddrop {
	
    public static void main(String[] args) {

   	 // Setup ChromeDriver automatically
       WebDriverManager.chromedriver().setup();

       WebDriver driver = new ChromeDriver();

       // Maximize window
       driver.manage().window().maximize();
       
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       // Open MakeMyTrip
       driver.get("https://www.treebo.com/hotels-in-coorg/");
       
       driver.findElement(By.xpath("//i[@class=\"sc-qiv231-0 material-icons hYmfyc\"]")).click();
       
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0, 1400)");      
       
       driver.findElement(By.xpath("//span[text()='View 7 more']")).click();
       
       List<WebElement> amenities = wait.until(
    		    ExpectedConditions.visibilityOfAllElementsLocatedBy(
    		        By.xpath("//div[text()='HOTEL AMENITIES']/following-sibling::div[1]//input[@type='checkbox']")
    		    )
    		);
    		
       
       for(WebElement amenity : amenities)
       {
    	   String text = amenity.getText().trim().toLowerCase();
    	   if (text.contains("parking")||text.contains("restaurant")||text.contains("pool"))
    	   {
    		   WebElement checkbox = amenity.findElement(By.xpath(".//input"));
    	        js.executeScript("arguments[0].click();", amenities);
    	
    	   }
       }
       
    }
}
