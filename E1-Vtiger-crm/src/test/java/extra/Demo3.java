package extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo3 {

	@Test
	public void mul() throws InterruptedException {
	
//	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Reporter.log("Demo3",true);
		
		Assert.assertTrue(false);

		System.out.println("hey");
		driver.close();
	}
	
}
