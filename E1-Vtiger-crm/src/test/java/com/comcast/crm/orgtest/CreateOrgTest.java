package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest {

	public static void main(String[] args) throws InterruptedException, IOException {
//		step = 1 => get the java representation object of the physical file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\git\\E1\\E1-Vtiger-crm\\src\\test\\resources\\commonData.properties");

//		step - 2 => by using load(), load all the keys in object of properties class
		Properties pObj = new Properties();
		pObj.load(fis);

//		step - 3 => By using getProperty(), get the value
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");

//		getting data from excel file
		FileInputStream fis2 = new FileInputStream("C:\\Users\\User\\Desktop\\tsdE1.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		String orgName = wb.getSheet("org").getRow(4).getCell(3).getStringCellValue() + (int) (Math.random() * 9999) ;
		
//		opening browser	
		WebDriver driver = null;

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

//		Login
		driver.get(URL);

		WebElement usernameField = driver.findElement(By.name("user_name"));
		usernameField.sendKeys(USERNAME);

		WebElement passwordField = driver.findElement(By.name("user_password"));
		passwordField.sendKeys(PASSWORD);

		WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit']"));
		loginBtn.submit();

//		Create organization
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
		if (actualOrgName.equals(orgName)) {
			System.out.println("Created Organization Successfullyy...");
		}

//		Logout
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();

		driver.findElement(By.linkText("Sign Out")).click();

//		close the browser
		Thread.sleep(5000);
		driver.quit();
	}

}
