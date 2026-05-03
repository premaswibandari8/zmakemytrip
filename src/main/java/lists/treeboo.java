package lists;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class treeboo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.get("https://www.treebo.com/hotels-in-coorg/");
        
        driver.findElement(By.xpath("//i[@class=\"sc-qiv231-0 material-icons hYmfyc\"]")).click();

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
            Thread.sleep(5000);

            // 🔥 Scroll to HOTEL AMENITIES
            WebElement amenitiesHeader = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//*[contains(text(),'HOTEL AMENITIES')]")
                    )
            );

            js.executeScript("arguments[0].scrollIntoView({block:'center'});", amenitiesHeader);
            Thread.sleep(1000);

            // 🔥 Get all checkboxes under HOTEL AMENITIES
            List<WebElement> amenityLabels = driver.findElements(
                    By.xpath("//*[contains(text(),'HOTEL AMENITIES')]/following::label")
            );

            int count = 0;

            for (WebElement label : amenityLabels) {
                try {
                    js.executeScript("arguments[0].scrollIntoView({block:'center'});", label);
                    Thread.sleep(500);

                    js.executeScript("arguments[0].click();", label);

                    System.out.println("Clicked amenity");

                    count++;
                    Thread.sleep(2000); // wait for page refresh

                    if (count == 3) break;

                } catch (Exception e) {
                    System.out.println("Skipped one");
                }
            }

            System.out.println("Selected 3 amenities ✅");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // driver.quit();
    }
}