package extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		step 1 -> get the java rep object of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\tsdE1.xlsx");

//		open the workbook in read mode
		Workbook wb = WorkbookFactory.create(fis);

//		Sheet sh = wb.getSheet("org");
//		Row row = sh.getRow(4);
//		Cell cell1 = row.getCell(3);

//		give sheetName, rownum and cellNum and get the value
		String orgName = wb.getSheet("org").getRow(4).getCell(3).getStringCellValue() + (int) (Math.random() * 9999);
//		String phoneNum = wb.getSheet("org").getRow(4).getCell(4).getStringCellValue();
		System.out.println(orgName);
//		System.out.println(phoneNum);

//		Cell cell2 = row.getCell(4);
//		String phoneNum = cell2.getStringCellValue();
//		System.out.println(phoneNum);

	}
}
