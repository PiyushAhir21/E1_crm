package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {

	public String getDataFromPropFile(String key) throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\git\\E1\\E1-Vtiger-crm\\src\\test\\resources\\commonData.properties");

		Properties pObj = new Properties();
		pObj.load(fis);

		String value = pObj.getProperty(key);
		return value;
	}
	

	public String getDataFromExcelFile(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\tsdE1.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		JavaUtility jutil = new JavaUtility();
		String value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue() + jutil.generateRanNum();
		
		return value;

	}
}
