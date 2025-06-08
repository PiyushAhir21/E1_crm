package extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners_utility.List_Imp.class)
public class DemoForDP {
	@Test(dataProvider = "getData")
	public void loginToFb(String un , String pwd) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.facebook.com/");

		driver.findElement(By.id("email")).sendKeys(un);
		driver.findElement(By.id("pass")).sendKeys(pwd);

		Thread.sleep(1000);
		driver.quit();
	}

	@DataProvider
	public String[][] getData() {
		String i[][] = new String[3][2];

		i[0][0] = "Deepak";
		i[0][1] = "Kumar@123";

		i[1][0] = "Abhijeet";
		i[1][1] = "Kumar456";

		i[2][0] = "Kuldeep";
		i[2][1] = "Singh05";

		return i;
	}
}
