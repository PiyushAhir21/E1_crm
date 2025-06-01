package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateContactTest {

	@Test
	public void add() throws IOException, InterruptedException {
//	public static void main(String[] args) throws InterruptedException, IOException {
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
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(URL);

		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys(USERNAME);

		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys(PASSWORD);

		Actions act = new Actions(driver);
		act.keyDown(Keys.ENTER).build().perform();
		act.keyUp(Keys.ENTER).build().perform();

		Thread.sleep(10000);
		driver.close();
	}

}
