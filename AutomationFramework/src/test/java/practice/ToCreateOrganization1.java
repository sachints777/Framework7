package practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToCreateOrganization1 {

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
		
		// Step 3:- Navigate to Organization Link
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(4000);
		
		// Step 4:- Click on Create Organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Thread.sleep(4000);
		
		Random r=new Random();
		int random=r.nextInt(1000);
		
		//Step 5:- Create organization with mandatory fields
		
		driver.findElement(By.name("accountname")).sendKeys("amazon"+random);
		Thread.sleep(4000);
		
		//Step 6:- Save and Verify
		driver.findElement(By.name("button")).click();
		Thread.sleep(4000);
		
		String organizationname = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if(organizationname.contains("amazon"+random)) {
			
			System.out.println(organizationname+"------passed");
		}
		else {
		System.out.println("Failed to create organizatioin");
			
		}
		//Step 7:- Logout Of Application
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action=new Actions(driver);
		action.moveToElement(logout).perform();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(4000);
		
		//Step 8:- Close the browser
		driver.quit();
		

}
	
}
