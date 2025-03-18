package testPack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoSuchElementException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver,chrome.driver", "C:\\Users\\swain\\OneDrive\\Desktop\\Selenium\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		try 
		{
            
			driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().window().maximize();

			// Trying to find a non-existent element
			WebElement alertButton = driver.findElement(By.xpath("//button[text()='Try it']"));//Element is present inside a iframe.
			alertButton.click();
        } 
		catch (Exception e) 
		{
            System.out.println("Element not found! Handling NoSuchElementException.");
        }

        driver.quit();
	}

}
