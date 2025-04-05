package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	public	OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organizationVerification;

	public WebElement getOrganizationVerification() {
		return organizationVerification;
	}

















}
