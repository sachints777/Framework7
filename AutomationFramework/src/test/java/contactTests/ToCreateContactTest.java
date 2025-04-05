package contactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateContactPage;
import objectRepository.HomePage;

@Listeners(genericUtility.ListenersImplementation.class)
public class ToCreateContactTest extends BaseClass {
	@Test(groups = "Smoke")

	public void toCreateContacts_001() throws EncryptedDocumentException, IOException {

		HomePage hp = new HomePage(driver);
		hp.getContactslink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreatecontactlookupimg().click();

		CreateContactPage ccp = new CreateContactPage(driver);
		ExcelFileUtility eutil = new ExcelFileUtility();
		String lastname = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
		ccp.getLastnameTextfield().sendKeys(lastname);
		ccp.getSavebutton().click();

		Assert.fail(); // test case failure

		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String title = cip.getContactVerification().getText();
		Assert.fail();

		Assert.assertTrue(title.contains(lastname));
		Reporter.log(title + "Contact created successfully");
		/*
		 * if (title.contains(lastname)) {
		 * 
		 * System.out.println(title + "---passed and contact got created"); } else {
		 * System.out.println("----failed and contact not created"); }
		 */
	}

}
