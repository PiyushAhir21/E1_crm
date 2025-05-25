package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class Facebook {
	
	
	@FindBy(name = "login")
	WebElement loginBtn;
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.facebook.com/");
		
		
//		WebElement loginBtn = driver.findElement(By.name("login"));
		
		driver.navigate().refresh();
		
//		loginBtn.click();
	}
}
