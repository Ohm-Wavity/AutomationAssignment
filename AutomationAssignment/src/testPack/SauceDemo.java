package testPack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SauceDemo {
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver,chrome.driver", "C:\\Users\\swain\\OneDrive\\Desktop\\Selenium\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
		
		//Fetching User Name and filling the User Name field
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
		WebElement userNameDiv = driver.findElement(By.id("login_credentials"));
        // Get the text content
        String fullText = userNameDiv.getText();
        // Print the full text (new lines will appear where <br> tags exist)
        System.out.println(fullText);
        // Split text by newline (\n) to get each line separately
        String[] lines1 = fullText.split("\n");
        userNameField.sendKeys(lines1[1]);

        //Fetching password and filling the Password field
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement passwordDiv = driver.findElement(By.className("login_password"));

        fullText = passwordDiv.getText();

        System.out.println(fullText);

        String[] lines2 = fullText.split("\n");
        passwordField.sendKeys(lines2[1]);
      		
        //Logging in
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        
		//Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		// Find all product elements
        List<WebElement> productNames = driver.findElements(By.cssSelector("a[id*='title_link']"));//driver.findElements(By.xpath("//div[@class='inventory_item']//a[contains(@id,'title_link')]"));

        // Print all product names
        System.out.println("Product Names:");
        for (WebElement product : productNames) {
            System.out.println(product.getText());
        }
        
        
        //Find price 
        List<WebElement> price = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        // Print all product names
        System.out.println("Price of the products:");
        for (WebElement product : price) {
            System.out.println(product.getText());
        }
        
        
        // Select an item and add to cart (Example: Sauce Labs Backpack)
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();

        // Navigate to cart
        driver.findElement(By.className("shopping_cart_link")).click();

        // Use explicit wait to ensure the item appears in the cart
        WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']")));

        // Verify if the item is present in the cart
        if (cartItem.isDisplayed()) {
            System.out.println("Item successfully added to cart and verified.");
        } else {
            System.out.println("Item not found in cart.");
        }
        
        
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5000));
		
	}

}
