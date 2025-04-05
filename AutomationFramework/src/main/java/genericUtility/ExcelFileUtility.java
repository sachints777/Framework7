package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
/**
 * This method is used to read Data from excel file provide sheet name , row and cell
 * @param sheet name
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String toReadDataFromExcelFile(String sheetname, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\testDataM8.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return value;
  	}

}
