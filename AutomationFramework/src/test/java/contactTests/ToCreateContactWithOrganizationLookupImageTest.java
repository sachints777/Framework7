package contactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateContactPage;
import objectRepository.CreateOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;

public class ToCreateContactWithOrganizationLookupImageTest extends BaseClass {

	@Test(groups="Smoke")

	public void toCreateContactWithOrganizationLookupImage()
			throws EncryptedDocumentException, IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.getContactslink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreatecontactlookupimg().click();

		CreateContactPage ccp = new CreateContactPage(driver);
		ExcelFileUtility eutil = new ExcelFileUtility();
		String lastname = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
		ccp.getLastnameTextfield().sendKeys(lastname);
		ccp.getSavebutton().click();

		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String contactname = cip.getContactVerification().getText();

		hp.getOrganizationlink().click();
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationLookupImage().click();

		JavaUtility jutil = new JavaUtility();
		int randomno = jutil.toGetRandomNumber();

		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.getOrganizationameTextField().sendKeys("Empuran" + randomno);

		cop.getSaveButton().click();

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String organizationname = oip.getOrganizationVerification().getText();

		// Assert is used for Validation

		Assert.assertTrue(contactname.contains(lastname));
		Assert.assertTrue(organizationname.contains("Empuran" + randomno));

	}

}
