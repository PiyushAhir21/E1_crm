package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("http://localhost:8888/");

//		Login in vtiger crm
		WebElement un = driver.findElement(By.name("user_name"));
		un.sendKeys("admin");

		WebElement pwd = driver.findElement(By.name("user_password"));
		pwd.sendKeys("password");

		WebElement loginBtn = driver.findElement(By.id("submitButton"));
		loginBtn.click();

		Thread.sleep(3000);

//		Creating Organization
		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

//		generating organization name with randome number
		String orgName = "qsp_" + (int) (Math.random() * 1000);
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(orgName);

//		Clicking on save button
		WebElement saveBtn = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		saveBtn.click();

//		Verification of organization name
		WebElement header = driver.findElement(By.className("dvHeaderText"));
		String actOrgName = header.getText();

		if (actOrgName.contains(orgName)) {
			System.out.println("Created Organization successfully!!!");
		} else {
			System.out.println("FAILED!!!");
		}

//		Logout
//		hover on profile icon
		WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).perform();

		Thread.sleep(2000);

//		click on sign out link
		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();
	}
}
