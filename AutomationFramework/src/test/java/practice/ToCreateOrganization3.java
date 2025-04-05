package practice;

import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ToCreateOrganization3 {

	public static void main(String[] args) throws InterruptedException {

		// step 1:- launch Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Step 2:- Login to application with valid credential
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);

		// Step 3:- Navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();

		// Step 4:- Click on create organization look up image

		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Thread.sleep(3000);

		Random r = new Random();
		int random = r.nextInt(1000);

		// Step 5:- Create organization with mandatory fields

		driver.findElement(By.name("accountname")).sendKeys("amazon" + random);

		// Step 6:- Select "Energy" in the industry drop down

		WebElement industrydropdown = driver.findElement(By.name("industry"));
		Select industry = new Select(industrydropdown);
		industry.selectByValue("Energy");
		
		// Step 7:- Select "customer" in the type drop down
		
		WebElement TypeDropdown =driver.findElement(By.name("accounttype"));
		Select type= new Select(TypeDropdown);
		type.selectByValue("Customer");

		// Step 8:- Save and Verify

		driver.findElement(By.name("button")).click();
		Thread.sleep(3000);

		String organizationname = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (organizationname.contains("amazon" + random)) {

			System.out.println(organizationname + "----passed");
		} else {
			System.out.println("Failed to create organization");
		}

		// Step 9:- Logout From Application

		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(3000);

		// Step 10: Close Browser

		driver.quit();

	}

}
