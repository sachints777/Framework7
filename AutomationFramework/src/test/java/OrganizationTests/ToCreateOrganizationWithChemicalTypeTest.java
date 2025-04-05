package OrganizationTests;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.CreateOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;

public class ToCreateOrganizationWithChemicalTypeTest extends BaseClass {
	@Test(groups="Regression")
	public void toCreateOrganizationWithChemicalType_003() throws EncryptedDocumentException, IOException {

		HomePage hp = new HomePage(driver);
		hp.getOrganizationlink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationLookupImage().click();

		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		

		ExcelFileUtility eutil = new ExcelFileUtility();
		String org = eutil.toReadDataFromExcelFile("Organization", 1, 2);
		
		Random r = new Random();
		int random = r.nextInt(5600);
		cop.getOrganizationameTextField().sendKeys(org+random);
		
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toHandleDropDown(cop.getIndustryDropdown(), "Chemicals");
		wutil.toHandleDropDown(cop.getAccounttypeDrpdown(), "Investor");

		cop.getSaveButton().click();
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		 String header = oip.getOrganizationVerification().getText();
		 
		 if(header.contains(org)) {
			
			System.out.println("-----Passed And Organization Created With Industry As Chemical");
		 }
		 else {
		
			 System.out.println("-----Failed And Organization not created");
			 
		 }
	}

}
