package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class CreateOrgTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		FileUtility fUtil = new FileUtility();
		
		String BROWSER = fUtil.getDataFromPropFile("bro");
		String URL = fUtil.getDataFromPropFile("url");
		String USERNAME = fUtil.getDataFromPropFile("un");
		String PASSWORD = fUtil.getDataFromPropFile("pwd");

//		getting data from excel file
		String orgName = fUtil.getDataFromExcelFile("org", 4, 3);
		
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

		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		
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
		wdUtil.hover(profile);


		driver.findElement(By.linkText("Sign Out")).click();

//		close the browser
		Thread.sleep(5000);
		wdUtil.closingBrowser();
	}

}
