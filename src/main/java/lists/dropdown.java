package lists;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dropdown {
	
	public static void main(String[] args) {
	
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	JavascriptExecutor js = (JavascriptExecutor) driver;

	driver.get("https://www.treebo.com/hotels-in-coorg/");
	driver.manage().window().maximize();

	// 1️⃣ Click guest dropdown
	WebElement guestDropdown = wait.until(
	        ExpectedConditions.elementToBeClickable(
	                By.xpath("//span[contains(text(),'Room')]")
	        )
	);

	js.executeScript("arguments[0].click();", guestDropdown);

	// 2️⃣ Increase adult count
	WebElement plusAdult = wait.until(
	        ExpectedConditions.elementToBeClickable(
	                By.xpath("//span[contains(text(),'Adults')]/following::button[1]")
	        )
	);

	js.executeScript("arguments[0].click();", plusAdult);

	// 3️⃣ Click Done / Apply
	WebElement doneBtn = wait.until(
	        ExpectedConditions.elementToBeClickable(
	                By.xpath("//button[contains(text(),'Done') or contains(text(),'Apply')]")
	        )
	);

	js.executeScript("arguments[0].click();", doneBtn);
}

}

