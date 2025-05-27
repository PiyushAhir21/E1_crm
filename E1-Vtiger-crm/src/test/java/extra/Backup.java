package extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Backup {
	public static void main(String[] args) throws InterruptedException, IOException {

//		Get data from properties file

//		step 1> Get the java representation object of the physical file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\git\\E1\\E1-Vtiger-crm\\src\\test\\resources\\cd.properties");

//		step 2> Use load() of Properties class to load all the keys
		Properties pObj = new Properties();
		pObj.load(fis);

//		Step 3> use getProperty() of properties class to get the value of particular key
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");

//		Get data from excel file
//		step 1> Get the java representation object of the physical file
		FileInputStream fis2 = new FileInputStream("C:\\Users\\User\\Desktop\\testScriptDataM6.xlsx");
		
//		step 2> Open the workbook in read mode
		Workbook wb = WorkbookFactory.create(fis2); // it won't create anything it will open the workbook in read mode.
		
//		step 3> getting data via these methods in String format
		Sheet sh = wb.getSheet("org");
		
		Row row = sh.getRow(2);
		
		Cell cell = row.getCell(0);
		
		String value = cell.getStringCellValue();
		
		System.out.println(value);
		
		wb.close();
		
		
		
			
		WebDriver driver = new ChromeDriver();

		driver.get(URL);

//		We should never ever hardcode the data
//		read the data from external resources and run the ts is called DDT

//		Login 
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		Thread.sleep(3000);
		driver.close();
	}
}
