package OrganizationTests;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.CreateOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;

public class ToCreateOrganizationWithChemicalTest extends BaseClass {
	@Test(groups="Regression")
	
	public void toCreateOrganizationWithChemical_002() throws EncryptedDocumentException, IOException {

		HomePage hp = new HomePage(driver);
		hp.getOrganizationlink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationLookupImage().click();

		CreateOrganizationPage corp = new CreateOrganizationPage(driver);

		ExcelFileUtility eutil = new ExcelFileUtility();
		String org = eutil.toReadDataFromExcelFile("Organization", 1, 2);
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toHandleDropDown(corp.getIndustryDropdown(),"Chemicals");

		Random r = new Random();
		int random = r.nextInt(1000);
		corp.getOrganizationameTextField().sendKeys(org + random);
		corp.getSaveButton().click();
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String organizationname = oip.getOrganizationVerification().getText();

		Assert.assertTrue(organizationname.contains(org+random));
		
		

	}
}
