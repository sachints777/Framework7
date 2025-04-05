package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "user_name")
	private WebElement usernametextfield;
	
	@FindBy(name="user_password")
	private WebElement passwordtextField;
	
	@FindBy(id="submitButton")
	private WebElement logintextfield;

	public WebElement getUsernametextfield() {
		return usernametextfield;
	}

	public WebElement getPasswordtextField() {
		return passwordtextField;
	}

	public WebElement getLogintextfield() {
		return logintextfield;
	}

	


	

	
}
