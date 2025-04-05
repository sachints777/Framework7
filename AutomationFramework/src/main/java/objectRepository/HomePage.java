package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);

	}
	@FindBy(linkText="Contacts")
	private WebElement contactslink;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationlink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutlink;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutlink;

	public WebElement getContactslink() {
		return contactslink;
	}

	public WebElement getOrganizationlink() {
		return organizationlink;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}
	
	
	
	
	
	
	
	
	
	
	
	
















}
