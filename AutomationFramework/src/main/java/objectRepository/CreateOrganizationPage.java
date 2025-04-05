package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	
	public CreateOrganizationPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="accountname")
	private WebElement organizationnameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(name="accounttype")
	private WebElement accounttypeDrpdown;

	public WebElement getOrganizationameTextField() {
		return organizationnameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getAccounttypeDrpdown() {
		return accounttypeDrpdown;
	}
	










}
