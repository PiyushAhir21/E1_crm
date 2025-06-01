package com.comcast.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_utility.BaseClass;

public class CreateOrgTest extends BaseClass{
//
//	WebDriver driver = null;
//	FileUtility fUtil = new FileUtility();
//
//	@BeforeClass
//	public void openBro() throws IOException {
////		public static void main(String[] args) throws InterruptedException, IOException {
//		String BROWSER = fUtil.getDataFromPropFile("bro");
////			opening browser	
//
//		if (BROWSER.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equals("edge")) {
//			driver = new EdgeDriver();
//		} else if (BROWSER.equals("firefox")) {
//			driver = new FirefoxDriver();
//		} else {
//			driver = new ChromeDriver();
//		}
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//	}
//
//	@BeforeMethod
//	public void login() throws IOException {
//		LoginPage lp = new LoginPage(driver);
//		lp.login();
//	}

	@Test
	public void createOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {

//		Create organization
//		getting data from excel file
		String orgName = fUtil.getDataFromExcelFile("org", 4, 3);

		WebElement orgLink = driver.findElement(By.linkText("Organizations"));
		orgLink.click();

		WebElement orgPlus = driver.findElement(By.xpath("//img[@title='Create Organization...']"));
		orgPlus.click();

		WebElement orgNameField = driver.findElement(By.name("accountname"));
//		String orgName = "Lenovo" + (int) (Math.random() * 9999);
		orgNameField.sendKeys(orgName);

		WebElement saveBtn = driver.findElement(By.cssSelector("input[title='Save [Alt+S]']"));
		saveBtn.click();

//		Verification
		String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		Assert.assertEquals(orgName, actualOrgName);

	}

//	@AfterMethod
//	public void logout() {
////		Logout
//		HomePage hp = new HomePage(driver);
//		hp.logout();
//	}
//
//	@AfterClass
//	public void closeBro() throws InterruptedException {
////		close the browser
//		Thread.sleep(2000);
//		driver.close();
//	}
}
