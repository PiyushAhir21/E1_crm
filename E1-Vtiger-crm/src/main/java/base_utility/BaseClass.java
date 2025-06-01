package base_utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import generic_utility.FileUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

public class BaseClass {

	public WebDriver driver ;
	public FileUtility fUtil = new FileUtility();

	@Parameters("bro")
	@BeforeClass
	public void openBro(String browser) throws IOException {
//		public static void main(String[] args) throws InterruptedException, IOException {
//		String BROWSER = fUtil.getDataFromPropFile("bro");
//			opening browser	

		String BROWSER = browser ;
		
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@BeforeMethod
	public void login() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.login();
	}

	@AfterMethod
	public void logout() {
//		Logout
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass
	public void closeBro() throws InterruptedException {
//		close the browser
		Thread.sleep(2000);
		driver.close();
	}

}
