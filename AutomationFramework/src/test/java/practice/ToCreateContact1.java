		package practice;

		import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

		public class ToCreateContact1 {
		
		public static void main(String[] args) throws InterruptedException {
	
		// step 1:- launch Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		// Step 2:- Login to application with valid credential
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(4000);
		
		//Step 3:- Navigate to contact link
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(4000);
		
		//Step 4:- Click on Create Contact lookup image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		Thread.sleep(4000);
		
		//Step 5:- Create a contact mandatory file
		
		driver.findElement(By.name("lastname")).sendKeys("T S");
		Thread.sleep(5000);
		
		//Step 6:- Save and Verify
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(4000);
		String lastName = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		
		if(lastName.contains("T S")) {
		System.out.println(lastName+"---passed");
		
		}
		else {
		
		System.out.println("Failed to create contact");	
			
		}
		
		//Step 7:- Logout Of Application
		WebElement logout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action=new Actions(driver);
		action.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(5000);
		
		//Step 8:- Close the Browser
		driver.quit();
		
		

	}

}
