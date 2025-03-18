package testPack;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
//		https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert
		
		System.setProperty("webdriver,chrome.driver", "C:\\Users\\swain\\OneDrive\\Desktop\\Selenium\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		try {
			 
			 	driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
				driver.manage().window().maximize();

				// Switching to iframe using ID
	            driver.switchTo().frame("iframeResult"); 

	            // Clicking the alert button inside the iframe
	            WebElement alertButton = driver.findElement(By.xpath("//button[text()='Try it']"));
	            alertButton.click();

	            // Switching to alert to handle it
	            Alert alert = driver.switchTo().alert();
	            System.out.println("Alert Message: " + alert.getText());
	            TimeUnit.SECONDS.sleep(3);
	            alert.accept(); // Click on the OK button

	            // Switch back to the main page
	            driver.switchTo().defaultContent();  
		 }
		 catch (Exception e) 
		 {
	            System.out.println("Error: " + e.getMessage());
	     } 
		 finally 
		 {
	            // Close the browser
	            driver.quit();
	     }

	}

}
