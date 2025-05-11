package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {
	WebDriver driver;
	Actions act ;

	
	public WebDriverUtility(WebDriver driver){
		this.driver = driver;
		this.act = new Actions(driver);
//		this will define the current object
	}
	
	public void closingBrowser() {
		driver.close();
	}
	
	public void hover(WebElement element) {
		act.moveToElement(element).build().perform();
	}
	
	public void rightClick(WebElement element) {
		act.contextClick(element).build().perform();
	}
	
	public void switchToWindow() {
				
	}
	
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

//	manage methods
//  navigate methods
//	switch methods
//	actions clas
//	select class
//	pop up	
	
}	
