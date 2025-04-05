package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	public CreateContactPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}
	@FindBy(name="lastname")
	private WebElement lastnameTextfield;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	public WebElement getLastnameTextfield() {
		return lastnameTextfield;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	















}
