package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateOrganizationLookupImage;

	public WebElement getCreateOrganizationLookupImage() {
		return CreateOrganizationLookupImage;
	}

}
