package testPack;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class StaleElementReferenceException {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver,chrome.driver", "C:\\Users\\swain\\OneDrive\\Desktop\\Selenium\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		// Attach Event Listener
        EventListener eventListener = new EventListener();
        WebDriver eventDriver = new EventFiringDecorator<>(eventListener).decorate(driver);
		
		try 
		{
            
			eventDriver.get("https://the-internet.herokuapp.com/");
			eventDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			eventDriver.manage().window().maximize();

			
			eventDriver.findElement(By.xpath("//a[text()='Dynamic Controls']")).click();
			eventDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//			Clicking on Remove button 
			eventDriver.findElement(By.xpath("//button[text()='Remove']")).click();
			TimeUnit.SECONDS.sleep(7);
//			This action removes the checkbox from the screen. 
//			If you do the same action again, you wont find the same element again leading to a Stale Element Reference Exception
			eventDriver.findElement(By.xpath("//button[text()='Remove']")).click();
			
        } 
		catch (Exception e) 
		{
			System.out.println("Stale element detected! Retrying...");
            
            // Re-locate the element before retrying
			eventDriver.findElement(By.xpath("//button[text()='Add']")).click();
			TimeUnit.SECONDS.sleep(7);
			eventDriver.findElement(By.xpath("//button[text()='Remove']")).click();
		}
		finally {
			driver.quit();
		}	
	}

}
