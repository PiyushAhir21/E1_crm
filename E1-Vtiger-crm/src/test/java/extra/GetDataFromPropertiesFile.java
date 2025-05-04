package extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
//		step = 1 => get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\git\\E1\\E1-Vtiger-crm\\src\\test\\resources\\commonData.properties");
		
//		step - 2 => by using load(), load all the keys in object of properties class
		Properties pObj = new Properties();
		pObj.load(fis);
		
//		step - 3 => By using getProperty(), get the value
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
	}
}
