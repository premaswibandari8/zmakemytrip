package lists;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lists {
	

    public static void main(String[] args) {

    	 // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open MakeMyTrip
        driver.get("https://www.airpaz.com/en/hotel/search?ad=2&ci=2026-04-29&co=2026-04-30&d=Coorg&id=833&ro=1&t=region");
        
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid=\"apz-button\"]"))).click();
        driver.findElement(By.xpath("//div[text()='Departure']")).click();
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)");
        
        
        
        //WebElement element = driver.findElement(By.xpath("//your-bottom-element"));
        //element.click();
                
        Actions act = new Actions(driver);
        act.moveByOffset(0, 0).click().perform();
       // driver.quit();

    }
}
