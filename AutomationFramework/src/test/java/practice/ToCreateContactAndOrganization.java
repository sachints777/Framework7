package practice;
import java.time.Duration;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ToCreateContactAndOrganization {

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
		Thread.sleep(4000);

		// Step 3:- Navigate to contact link
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(4000);

		// Step 4:- Click on Create Contact lookup image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		Thread.sleep(4000);

		// Step 5:- Create a contact mandatory file

		driver.findElement(By.name("lastname")).sendKeys("T S");
		Thread.sleep(5000);

		// Step 6:- Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(4000);
		String lastName = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();

		// Step 7:- Navigate to Organization Link
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(4000);

		// Step 8:- Click on Create Organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Thread.sleep(4000);

		Random r = new Random();
		int random = r.nextInt(1000);

		// Step 9:- Create organization with mandatory fields

		driver.findElement(By.name("accountname")).sendKeys("amazon" + random);
		Thread.sleep(4000);

		// Step 10:- Save
		driver.findElement(By.name("button")).click();
		Thread.sleep(4000);
		String organizationname = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();

		// Step 11:- Verify Contact and Organization
		Set<String> all_tab_id = driver.getWindowHandles();
		for (String id : all_tab_id) {
			driver.switchTo().window(id);
			String tabtitle = driver.getTitle();
			if (tabtitle.contains("contacts")) {
				System.out.println("Verification for Contact Link Starts....");
				if (lastName.contains("T S")) {
					System.out.println(lastName + "---passed");

				} else {

					System.out.println("Failed to create contact");

				}
				 
			
			
			}
		}

		// Step 12:- Logout Of Application
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logout).perform();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(4000);

		// Step 13:- Close the browser
		driver.quit();

	}

}
