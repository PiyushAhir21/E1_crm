package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="img[src='themes/softed/images/user.PNG']")
	private WebElement profile;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;

	public WebElement getProfile() {
		return profile;
	}

	public WebElement getSignOut() {
		return signOut;
	}
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(getProfile()).build().perform();
		act.click(getSignOut()).build().perform();
	}
	
	



}
